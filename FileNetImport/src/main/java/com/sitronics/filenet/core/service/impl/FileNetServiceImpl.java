package com.sitronics.filenet.core.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.filenet.api.admin.*;
import com.filenet.api.admin.ChoiceList;
import com.filenet.api.collection.*;
import com.filenet.api.constants.Cardinality;
import com.filenet.api.constants.ChoiceType;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.constants.TypeID;
import com.filenet.api.core.Factory;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.query.SearchSQL;
import com.filenet.api.query.SearchScope;
import com.filenet.api.util.Id;
import com.filenet.api.util.UserContext;
import com.sitronics.filenet.core.model.*;
import com.sitronics.filenet.core.service.FileNetService;
import com.sitronics.filenet.core.storage.FileNetStorage;


/**
 * @author Andrey Popov creates on 01.07.11 (15:48)
 */
@Service("fileNetService")
public class FileNetServiceImpl implements FileNetService {
    final Logger logger = LoggerFactory.getLogger(FileNetServiceImpl.class);

    @Qualifier("fileNetStorage")
    @Autowired
    private FileNetStorage fileNetStorage;

    @Qualifier("classBaseSql")
    @Autowired
    private String classBaseSql;

    @Value("${string.Length}")
    private Integer stringLength;

    private static ObjectStore objectStore = null;

    private StringBuffer buffer = new StringBuffer();

    @Override
    public void storeEntityDefinition(EntityDefinition entityDefinition) {
        openConnection();
        if (entityDefinition != null) {
            if (entityDefinition.getEntityType().equals(EntityType.CHOICELIST)) {
                storeChoiceList(entityDefinition);
            } else if (entityDefinition.getEntityType().equals(EntityType.PROPERTY)) {
                storePropertyTemplate(entityDefinition);
            } else if (entityDefinition.getEntityType().equals(EntityType.CLASS)) {
                storeClassDefinition(entityDefinition);
            }
        } else {
            logger.debug("EntityDefinition is null...");
        }
    }

    @SuppressWarnings("unchecked")
    private void storeChoiceList(EntityDefinition entityDefinition) {
        //Айдишник для новой проперти.
        Id id = new Id(UUID.randomUUID().toString());

        //Создаем описание для новых пропертей, это для полей DisplayName и DescriptiveText, делаем их одинаковыми.
        LocalizedStringList localizedStringList = Factory.LocalizedString.createList();
        LocalizedString string = Factory.LocalizedString.createInstance();
        string.set_LocaleName("en-us");

        ChoiceList choiceList = Factory.ChoiceList.createInstance(objectStore, id);

        choiceList.set_DescriptiveText(entityDefinition.getEntityName());
        choiceList.set_DisplayName(entityDefinition.getEntityName());
        choiceList.set_DataType(TypeID.STRING);

        com.filenet.api.collection.ChoiceList choiceListValues = Factory.Choice.createList();

        Choice choice;

        for (Map.Entry<String, FieldDefinition> entry : entityDefinition.getProperties().entrySet()) {
            choice = Factory.Choice.createInstance();

            choice.set_ChoiceStringValue(entry.getValue().getFieldName());
            choice.set_ChoiceType(ChoiceType.STRING);

            string.set_LocalizedText(entry.getValue().getFieldName());
            localizedStringList.add(string);

            choice.set_DisplayNames(localizedStringList);

            choiceListValues.add(choice);
        }

        choiceList.set_ChoiceValues(choiceListValues);
        choiceList.save(RefreshMode.NO_REFRESH);
    }

    @SuppressWarnings("unchecked")
    private void storePropertyTemplate(EntityDefinition entityDefinition) {
        //Айдишник для новой проперти.
        Id id = new Id(UUID.randomUUID().toString());

        //Создаем описание для новых пропертей, это для полей DisplayName и DescriptiveText, делаем их одинаковыми.
        LocalizedStringList localizedStringList = Factory.LocalizedString.createList();
        LocalizedString string = Factory.LocalizedString.createInstance();
        string.set_LocaleName("en-us");
        string.set_LocalizedText(entityDefinition.getEntityName());
        localizedStringList.add(string);


        FieldType fieldType = getFieldType(entityDefinition);

        if (fieldType.equals(FieldType.STRING) || fieldType.equals(FieldType.CHOICELIST)) {

            PropertyTemplateString propertyTemplateString = Factory.PropertyTemplateString.createInstance(objectStore, id);

            propertyTemplateString.set_SymbolicName(entityDefinition.getEntitySymbolicName());
            propertyTemplateString.set_DisplayNames(localizedStringList);
            propertyTemplateString.set_DescriptiveTexts(localizedStringList);
            propertyTemplateString.set_Cardinality(Cardinality.SINGLE);

            propertyTemplateString.set_MaximumLengthString(stringLength);

            if (fieldType.equals(FieldType.CHOICELIST)) {
                ChoiceListSet set = (ChoiceListSet) getObjectCollection(ChoiceList.class);
                Iterator iterator = set.iterator();
                while (iterator.hasNext()) {
                    ChoiceList choiceList = (ChoiceList) iterator.next();
                    if (choiceList.get_Name().equals(entityDefinition.getParentEntitySymbolicName())) {
                        propertyTemplateString.set_ChoiceList(choiceList);
                        break;
                    }
                }
            }

            //Сохраняем ее...
            propertyTemplateString.save(RefreshMode.NO_REFRESH);
        } else if (fieldType.equals(FieldType.DATE)) {
            PropertyTemplateDateTime propertyTemplateDateTime = Factory.PropertyTemplateDateTime.createInstance(objectStore, id);

            propertyTemplateDateTime.set_SymbolicName(entityDefinition.getEntitySymbolicName());
            propertyTemplateDateTime.set_DisplayNames(localizedStringList);
            propertyTemplateDateTime.set_DescriptiveTexts(localizedStringList);
            propertyTemplateDateTime.set_Cardinality(Cardinality.SINGLE);

            //Сохраняем ее...
            propertyTemplateDateTime.save(RefreshMode.NO_REFRESH);
        } else if (fieldType.equals(FieldType.INTEGER)) {
            PropertyTemplateInteger32 propertyTemplateInteger32 = Factory.PropertyTemplateInteger32.createInstance(objectStore, id);

            propertyTemplateInteger32.set_SymbolicName(entityDefinition.getEntitySymbolicName());
            propertyTemplateInteger32.set_DisplayNames(localizedStringList);
            propertyTemplateInteger32.set_DescriptiveTexts(localizedStringList);
            propertyTemplateInteger32.set_Cardinality(Cardinality.SINGLE);

            //Сохраняем ее...
            propertyTemplateInteger32.save(RefreshMode.NO_REFRESH);
        } else {
            PropertyTemplateBoolean propertyTemplateBoolean = Factory.PropertyTemplateBoolean.createInstance(objectStore, id);

            propertyTemplateBoolean.set_SymbolicName(entityDefinition.getEntitySymbolicName());
            propertyTemplateBoolean.set_DisplayNames(localizedStringList);
            propertyTemplateBoolean.set_DescriptiveTexts(localizedStringList);
            propertyTemplateBoolean.set_Cardinality(Cardinality.SINGLE);

            //Сохраняем ее...
            propertyTemplateBoolean.save(RefreshMode.NO_REFRESH);
        }
    }

    @SuppressWarnings("unchecked")
    private void storeClassDefinition(EntityDefinition entityDefinition) {
        openConnection();

        //Достаем все проперти темплейты из системы...
        PropertyTemplateSet propertyTemplateSet = (PropertyTemplateSet) getObjectCollection(PropertyTemplate.class);

        //Достаем из системы родительский класс в которым мы будем впоследствии вставлять новые классы.
        DocumentClassDefinition documentClassDefinition = (DocumentClassDefinition) getObjectBySymbolicName(DocumentClassDefinition.class, entityDefinition.getParentEntitySymbolicName());

        //Создаем описание для новых классов, это для полей DisplayName и DescriptiveText, делаем их одинаковыми.
        LocalizedStringList localizedStringList = Factory.LocalizedString.createList();
        LocalizedString string = Factory.LocalizedString.createInstance();
        string.set_LocaleName("en-us");
        string.set_LocalizedText(entityDefinition.getEntityName());
        localizedStringList.add(string);

        //Айдишник для нового класса.
        Id id = new Id(UUID.randomUUID().toString());

        //Создаем новый класс как наследника родителю определенному выше.
        ClassDefinition clazz = documentClassDefinition.createSubclass(id);

        //Заполняем новый класс...
        clazz.set_SymbolicName(entityDefinition.getEntitySymbolicName());
        clazz.set_DisplayNames(localizedStringList);
        clazz.set_DescriptiveTexts(localizedStringList);

        //Итератор для всех пропертей системы.
        Iterator iterator;

        for (Map.Entry<String, FieldDefinition> entry : entityDefinition.getProperties().entrySet()) {
            iterator = propertyTemplateSet.iterator();
            while (iterator.hasNext()) {
                PropertyTemplate template = (PropertyTemplate) iterator.next();
                if (template.get_SymbolicName().equals(entry.getKey()) && !containsIn(entry.getKey(), clazz.get_PropertyDefinitions())) {
                    clazz.get_PropertyDefinitions().add(template.createClassProperty());
                }

            }

        }

        clazz.save(RefreshMode.NO_REFRESH);


        closeConnection();
    }

    private FieldType getFieldType(EntityDefinition entityDefinition) {
        for (Map.Entry<String, FieldDefinition> entry : entityDefinition.getProperties().entrySet()) {
            if (entry.getValue().getFieldType() != null) {
                return entry.getValue().getFieldType();
            }
        }
        return null;

    }

    private Object getObjectCollection(Class aClass) {

        openConnection();

        if (aClass.equals(PropertyTemplate.class)) {
            return objectStore.get_PropertyTemplates();
        } else if (aClass.equals(ChoiceList.class)) {
            return objectStore.get_ChoiceLists();
        }

        return null;
    }

    private Object getObjectBySymbolicName(Class aClass, String name) {

        openConnection();

        buffer.append(classBaseSql.replaceFirst("\\{0\\}", name));

        logger.debug("Serch SQL Code for DocumentClassDefinition with Name \"{}\" is \"{}\"", name, buffer.toString());

        SearchScope scope = new SearchScope(objectStore);
        SearchSQL sql = new SearchSQL(buffer.toString());
        IndependentObjectSet set = scope.fetchObjects(sql, null, null, false);

        buffer.delete(0, buffer.length());

        Iterator iterator = set.iterator();

        return iterator.hasNext() ? iterator.next() : null;
    }


    private boolean containsIn(String pattern, PropertyDefinitionList list) {
        for (Object aList : list) {
//            PropertyDefinition definition = (PropertyDefinition) iterator.next();
            try {
                PropertyDefinition definition = (PropertyDefinition) aList;
                if (pattern.equals(definition.get_SymbolicName())) {
                    return true;
                }
            } catch (Exception exception) {
                logger.error(exception.getMessage());
            }
        }
        return false;
    }

    private void openConnection() {
        if (objectStore == null) {
            objectStore = fileNetStorage.getObjectStore();
            objectStore.refresh();
        }
    }

    private void closeConnection() {
        UserContext.get().popSubject();
        objectStore = null;
    }
}

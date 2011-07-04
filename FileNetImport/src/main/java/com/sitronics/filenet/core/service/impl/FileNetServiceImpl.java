package com.sitronics.filenet.core.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.filenet.api.admin.*;
import com.filenet.api.collection.*;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.Factory;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.exception.EngineRuntimeException;
import com.filenet.api.property.Properties;
import com.filenet.api.query.SearchSQL;
import com.filenet.api.query.SearchScope;
import com.filenet.api.util.Id;
import com.filenet.api.util.UserContext;
import com.sitronics.filenet.core.model.ExcelClassDefinition;
import com.sitronics.filenet.core.service.FileNetService;
import com.sitronics.filenet.core.storage.FileNetStorage;


/**
 * @author Andrey Popov creates on 01.07.11 (15:48)
 */
@Service("fileNetService")
public class FileNetServiceImpl implements FileNetService {
    final Logger logger = LoggerFactory.getLogger(FileNetServiceImpl.class);

    @Autowired
    private FileNetStorage fileNetStorage;

    @Qualifier("classBaseSql")
    @Autowired
    private String classBaseSql;

    private static ObjectStore OBJECT_STORE = null;
    private SearchSQL sql;
    private SearchScope scope;
    private IndependentObjectSet set;

    private StringBuffer buffer = new StringBuffer();


    @Override
    @SuppressWarnings("unchecked")
    public void storeObjects2FileNet(List<ExcelClassDefinition> excelClassDefinitions) {
        PropertyTemplateSet set = (PropertyTemplateSet) getObjectCollection(PropertyTemplate.class);

        for (ExcelClassDefinition excelClassDefinition : excelClassDefinitions) {

            DocumentClassDefinition documentClassDefinition = (DocumentClassDefinition) getObjectBySymbolicName(DocumentClassDefinition.class, excelClassDefinition.getSuperClassSymbolicName());

            LocalizedStringList localizedStringList = Factory.LocalizedString.createList();
            LocalizedString string = Factory.LocalizedString.createInstance();
            string.set_LocaleName("en-us");
            string.set_LocalizedText(excelClassDefinition.getNewClassName());
            localizedStringList.add(string);

            Id id = new Id(UUID.randomUUID().toString());

            ClassDefinition clazz = documentClassDefinition.createSubclass(id);

            clazz.set_SymbolicName(excelClassDefinition.getNewClassSymbolicName());
            clazz.set_DisplayNames(localizedStringList);
            clazz.set_DescriptiveTexts(localizedStringList);

            Iterator iterator = set.iterator();

            while (iterator.hasNext()) {
                PropertyTemplate template = (PropertyTemplate) iterator.next();
                for (Map.Entry<String, String> entry : excelClassDefinition.getProperties().entrySet()) {
                    if (template.get_SymbolicName().equals(entry.getKey()) && !containsIn(entry.getKey(), clazz.get_PropertyDefinitions())) {
                        clazz.get_PropertyDefinitions().add(template.createClassProperty());

                    }
                }
            }
                clazz.save(RefreshMode.REFRESH);

            closeConnection();
        }

    }


    private Object getObjectCollection(Class aClass) {

        openConnection();

        if (aClass.equals(PropertyTemplate.class)) {
            return OBJECT_STORE.get_PropertyTemplates();
        } else if (aClass.equals(ChoiceListSet.class)) {
            return OBJECT_STORE.get_ChoiceLists();
        }

        return null;
    }

    private Object getObjectBySymbolicName(Class aClass, String name) {

        openConnection();

        buffer.append(classBaseSql.replaceFirst("\\{0\\}", name));

        logger.debug("Serch SQL Code for DocumentClassDefinition with Name \"{}\" is \"{}\"", name, buffer.toString());

        scope = new SearchScope(OBJECT_STORE);
        sql = new SearchSQL(buffer.toString());
        set = scope.fetchObjects(sql, null, null, false);

        buffer.delete(0, buffer.length());

        Iterator iterator = set.iterator();

        return iterator.hasNext() ? iterator.next() : null;
    }

    private boolean containsIn(String pattern, PropertyDefinitionList list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            PropertyDefinition definition = (PropertyDefinition) iterator.next();
            try {
                if (pattern.equals(definition.get_SymbolicName())) {
                    return true;
                }
            } catch (EngineRuntimeException exception) {
            }
        }
        return false;
    }

    private void openConnection() {
        if (OBJECT_STORE == null) {
            OBJECT_STORE = fileNetStorage.getObjectStore();
            OBJECT_STORE.refresh();
        }
    }

    private void closeConnection() {
        UserContext.get().popSubject();
    }
}

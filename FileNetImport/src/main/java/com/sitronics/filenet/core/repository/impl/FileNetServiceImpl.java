package com.sitronics.filenet.core.repository.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filenet.api.admin.ClassDefinition;
import com.filenet.api.admin.DocumentClassDefinition;
import com.filenet.api.admin.LocalizedString;
import com.filenet.api.collection.IndependentObjectSet;
import com.filenet.api.collection.LocalizedStringList;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.Document;
import com.filenet.api.core.Factory;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.query.SearchSQL;
import com.filenet.api.query.SearchScope;
import com.filenet.api.util.Id;
import com.filenet.api.util.UserContext;
import com.sitronics.filenet.core.repository.FileNetService;
import com.sitronics.filenet.core.storage.FileNetStorage;


/**
 * @author Andrey Popov creates on 01.07.11 (15:48)
 */
@Service("fileNetService")
public class FileNetServiceImpl implements FileNetService {
    final Logger logger = LoggerFactory.getLogger(FileNetServiceImpl.class);

    @Autowired
    private FileNetStorage fileNetStorage;

    private ObjectStore objectStore;
    private SearchSQL sql;
    private SearchScope scope;
    private IndependentObjectSet set;

    @Override
    public void createDocumentClassDefinition() {

        objectStore = fileNetStorage.getObjectStore();
        objectStore.refresh();
        DocumentClassDefinition classDefinition = Factory.DocumentClassDefinition.fetchInstance(objectStore, "{46B2578C-2769-457F-AEFE-07609F57274B}", null);
//        CustomObject classDefinition = Factory.ClassDefinition.
//        scope = new SearchScope(objectStore);
//        sql = new SearchSQL(buffer.toString());
//        set = scope.fetchObjects(sql, null, null, false);
//
//        buffer.delete(0, buffer.length());
        LocalizedStringList list = Factory.LocalizedString.createList();
        LocalizedString string =  Factory.LocalizedString.createInstance();
        string.set_LocaleName("en-us");
        string.set_LocalizedText("Test Name");
        list.add(string);

        Id id = new Id(UUID.randomUUID().toString());

        ClassDefinition clazz = classDefinition.createSubclass(id);
        clazz.set_SymbolicName("TESTSIMNAME");
        clazz.set_DisplayNames(list);
//        clazz.set_DescriptiveTexts(list);
        clazz.save(RefreshMode.REFRESH);
        UserContext.get().popSubject();
    }
}

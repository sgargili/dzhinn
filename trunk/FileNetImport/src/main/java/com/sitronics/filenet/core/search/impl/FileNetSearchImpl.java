package com.sitronics.filenet.core.search.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filenet.api.collection.IndependentObjectSet;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.query.SearchSQL;
import com.filenet.api.query.SearchScope;
import com.filenet.api.util.UserContext;
import com.sitronics.filenet.core.search.FileNetSearch;
import com.sitronics.filenet.core.storage.FileNetStorage;

/**
 * @author Andrey Popov creates on 01.07.11 (12:13)
 */
@Service("fileNetSearch")
public class FileNetSearchImpl implements FileNetSearch {
    final Logger logger = LoggerFactory.getLogger(FileNetSearchImpl.class);

    @Autowired
    private FileNetStorage fileNetStorage;
    @Autowired
    private String classBaseSql;
//    @Autowired
//    private String propertyBaseSql;
//    @Autowired
//    private String choiceListBaseSql;

    private ObjectStore objectStore;
    private SearchSQL sql;
    private SearchScope scope;
    private IndependentObjectSet set;

    private StringBuffer buffer = new StringBuffer();

    @Override
    public boolean isDocumentClassDefinitionPresent(String className) {
        buffer.append(classBaseSql.replaceFirst("\\{0\\}", className));

        logger.error("Serch SQL Code for DocumentClassDefinition with SymbolicName \"{}\" is \"{}\"", className, buffer.toString());

        objectStore = fileNetStorage.getObjectStore();
        objectStore.refresh();
        scope = new SearchScope(objectStore);
        sql = new SearchSQL(buffer.toString());
        set = scope.fetchObjects(sql, null, null, false);

        buffer.delete(0, buffer.length());

        UserContext.get().popSubject();
        return set.iterator().hasNext();
    }

    @Override
    public boolean isPropertyTemplatePresent(String propertyName) {
        return false;
    }

    @Override
    public boolean isChoiceListPresent(String choiceListName) {
        return false;
    }
}

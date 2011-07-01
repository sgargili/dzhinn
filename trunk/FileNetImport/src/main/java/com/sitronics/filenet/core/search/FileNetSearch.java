package com.sitronics.filenet.core.search;

import org.springframework.stereotype.Service;

/**
 * @author Andrey Popov creates on 01.07.11 (12:07)
 */
public interface FileNetSearch {
    boolean isDocumentClassDefinitionPresent(String className);

    boolean isPropertyTemplatePresent(String propertyName);
    boolean isChoiceListPresent(String choiceListName);

}

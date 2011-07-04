package com.sitronics.filenet.core.service;

import java.util.List;

import com.filenet.api.util.Id;
import com.sitronics.filenet.core.model.ExcelClassDefinition;

/**
 * @author Andrey Popov creates on 01.07.11 (15:44)
 */
public interface FileNetService {
    void storeObjects2FileNet(List<ExcelClassDefinition> excelClassDefinitions);
}
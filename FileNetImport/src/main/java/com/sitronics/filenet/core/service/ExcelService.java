package com.sitronics.filenet.core.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import com.sitronics.filenet.core.model.ExcelClassDefinition;

/**
 * @author Andrey Popov creates on 04.07.11 (13:04)
 */
public interface ExcelService {
    List<ExcelClassDefinition> getExcelClassDefinitions(FileInputStream excelFileIS);
}

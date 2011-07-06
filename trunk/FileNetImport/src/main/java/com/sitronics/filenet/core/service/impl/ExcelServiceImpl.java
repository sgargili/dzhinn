package com.sitronics.filenet.core.service.impl;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.sitronics.filenet.core.model.ExcelClassDefinition;
import com.sitronics.filenet.core.model.ExcelProperty;
import com.sitronics.filenet.core.model.Status;
import com.sitronics.filenet.core.model.Type;
import com.sitronics.filenet.core.service.ExcelService;

/**
 * @author Andrey Popov creates on 04.07.11 (13:12)
 */
@Service("excelService")
public class ExcelServiceImpl implements ExcelService {
    @Override
    public List<ExcelClassDefinition> getExcelClassDefinitions(FileInputStream excelFileIS) {

        List<ExcelClassDefinition> excelClassDefinitions = new ArrayList<ExcelClassDefinition>();
        ExcelClassDefinition excelClassDefinition = null;

        try {
            XSSFWorkbook workBook = new XSSFWorkbook(excelFileIS);
            XSSFSheet sheet = workBook.getSheetAt(0);

            Iterator<Row> rows = sheet.rowIterator();

            //Опустимся на 1 строку вниз.
            if (rows.hasNext()) {
                rows.next();
            }

            while (rows.hasNext()) {
                XSSFRow row = (XSSFRow) rows.next();

                //Политика пустых ячеек, если она пустая, т.е. null, то делаем ее пустой...
                Row.MissingCellPolicy cellPolicy = Row.CREATE_NULL_AS_BLANK;

                //Берем все ячейки с политикой пустоты...
                XSSFCell superClassSymbolicNameCell = row.getCell(0, cellPolicy);
                XSSFCell newClassNameCell = row.getCell(1, cellPolicy);
                XSSFCell newClassSymbolicNameCell = row.getCell(2, cellPolicy);
                XSSFCell newClassPropertyNameCell = row.getCell(3, cellPolicy);
                XSSFCell newClassPropertySymbolicNameCell = row.getCell(4, cellPolicy);
                XSSFCell newClassPropertyTypeCell = row.getCell(5, cellPolicy);

                //Задаем для всех ячеек тип "Строка"...
                superClassSymbolicNameCell.setCellType(Cell.CELL_TYPE_STRING);
                newClassNameCell.setCellType(Cell.CELL_TYPE_STRING);
                newClassSymbolicNameCell.setCellType(Cell.CELL_TYPE_STRING);
                newClassPropertyNameCell.setCellType(Cell.CELL_TYPE_STRING);
                newClassPropertySymbolicNameCell.setCellType(Cell.CELL_TYPE_STRING);
                newClassPropertyTypeCell.setCellType(Cell.CELL_TYPE_STRING);

                //Если присуствует обозначение SymbolicName родительского класса, то создаем новый объект ExcelClassDefinition.
                if (!"".equals(superClassSymbolicNameCell.getStringCellValue())) {
                    //Добавляем класс в коллекцию, поподут все, кроме, очевидно, последнего...
                    if (excelClassDefinition != null) {
                        excelClassDefinitions.add(excelClassDefinition);
                    }
                    excelClassDefinition = new ExcelClassDefinition();
                    excelClassDefinition.setSuperClassSymbolicName(superClassSymbolicNameCell.getStringCellValue());
                    excelClassDefinition.setNewClassName(newClassNameCell.getStringCellValue());
                    excelClassDefinition.setNewClassSymbolicName(newClassSymbolicNameCell.getStringCellValue());
                    excelClassDefinition.addProperties(newClassPropertySymbolicNameCell.getStringCellValue(), convert(newClassPropertyNameCell.getStringCellValue(), newClassPropertyTypeCell.getStringCellValue()));
                } else if (excelClassDefinition != null) {
                    excelClassDefinition.addProperties(newClassPropertySymbolicNameCell.getStringCellValue(), convert(newClassPropertyNameCell.getStringCellValue(), newClassPropertyTypeCell.getStringCellValue()));
                }

            }
            //А тут и последний запихиваем в коллекцию...
            if (excelClassDefinition != null) {
                excelClassDefinitions.add(excelClassDefinition);
            }

            excelFileIS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return excelClassDefinitions;
    }

    private ExcelProperty convert(String propertyName, String propertyType) {
        ExcelProperty excelProperty = new ExcelProperty();
        excelProperty.setPropertyName(propertyName);
        if ("".equals(propertyType)) {
            excelProperty.setStatus(Status.EXIST);
        } else {
            excelProperty.setStatus(Status.NEW);
            if ("String".equals(propertyType)) {
                excelProperty.setType(Type.STRING);
            } else if ("Date".equals(propertyType)) {
                excelProperty.setType(Type.DATE);
            } else {
                excelProperty.setType(Type.INTEGER);
            }
        }
        return excelProperty;
    }
}

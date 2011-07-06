package com.sitronics.filenet.core.service.impl;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.sitronics.filenet.core.model.*;
import com.sitronics.filenet.core.service.ExcelService;

/**
 * @author Andrey Popov creates on 04.07.11 (13:12)
 */
@Service("excelService")
public class ExcelServiceImpl implements ExcelService {
    @Override
    public List<EntityDefinition> getEntityDefinitionsFromExcel(FileInputStream excelFileIS) {

        List<EntityDefinition> entityDefinitions = new ArrayList<EntityDefinition>();
        EntityDefinition entityDefinition = null;
        FieldDefinition fieldDefinition = null;
        FieldType choiceListType = null;
        try {
            XSSFWorkbook workBook = new XSSFWorkbook(excelFileIS);
            XSSFSheet sheet = workBook.getSheetAt(0);

            Iterator<Row> rows = sheet.rowIterator();

            //Опустимся на 1 строку вниз дабы не читать заголовок...
            if (rows.hasNext()) {
                rows.next();
            }

            while (rows.hasNext()) {
                XSSFRow row = (XSSFRow) rows.next();

                //Политика пустых ячеек, если она пустая, т.е. null, то делаем ее пустой...
                Row.MissingCellPolicy cellPolicy = Row.CREATE_NULL_AS_BLANK;

                //Берем все ячейки с политикой пустоты...
                XSSFCell entityTypeCell = row.getCell(0, cellPolicy);
                XSSFCell parentEntitySymbolicNameCell = row.getCell(1, cellPolicy);
                XSSFCell entityNameCell = row.getCell(2, cellPolicy);
                XSSFCell entitySymbolicNameCell = row.getCell(3, cellPolicy);
                XSSFCell fieldNameCell = row.getCell(4, cellPolicy);
                XSSFCell fieldSymbolicNameCell = row.getCell(5, cellPolicy);
                XSSFCell fieldTypeCell = row.getCell(6, cellPolicy);

                //Задаем для всех ячеек тип "Строка"...
                entityTypeCell.setCellType(Cell.CELL_TYPE_STRING);
                parentEntitySymbolicNameCell.setCellType(Cell.CELL_TYPE_STRING);
                entityNameCell.setCellType(Cell.CELL_TYPE_STRING);
                entitySymbolicNameCell.setCellType(Cell.CELL_TYPE_STRING);
                fieldNameCell.setCellType(Cell.CELL_TYPE_STRING);
                fieldSymbolicNameCell.setCellType(Cell.CELL_TYPE_STRING);
                fieldTypeCell.setCellType(Cell.CELL_TYPE_STRING);

                //Если присуствует обозначение типа сущности, то создаем новый объект сущности...
                if (!"".equals(entityTypeCell.getStringCellValue())) {
                    //Добавляем сущность в коллекцию, попадут все, кроме, очевидно, последнего...
                    if (entityDefinition != null) {
                        entityDefinitions.add(entityDefinition);
                    }

                    if (EntityType.CHOICELIST == EntityType.getFromString(entityTypeCell.getStringCellValue())) {

                        entityDefinition = createEntityDefinition(EntityType.CHOICELIST, null, entityNameCell.getStringCellValue(), entitySymbolicNameCell.getStringCellValue());
                        entityDefinition.addProperties(fieldSymbolicNameCell.getStringCellValue(), getFieldDefinition(fieldNameCell.getStringCellValue(), fieldTypeCell.getStringCellValue()));

                    } else if (EntityType.PROPERTY == EntityType.getFromString(entityTypeCell.getStringCellValue())) {

                        entityDefinition = createEntityDefinition(EntityType.PROPERTY, parentEntitySymbolicNameCell.getStringCellValue(), entityNameCell.getStringCellValue(), entitySymbolicNameCell.getStringCellValue());
                        //Запишем в качестве ключа рандомную строку...
                        entityDefinition.addProperties(UUID.randomUUID().toString(), getFieldDefinition(null, fieldTypeCell.getStringCellValue()));

                    } else if (EntityType.CLASS == EntityType.getFromString(entityTypeCell.getStringCellValue())) {

                        entityDefinition = createEntityDefinition(EntityType.CLASS, parentEntitySymbolicNameCell.getStringCellValue(), entityNameCell.getStringCellValue(), entitySymbolicNameCell.getStringCellValue());
                        entityDefinition.addProperties(fieldSymbolicNameCell.getStringCellValue(), getFieldDefinition(fieldNameCell.getStringCellValue(), fieldTypeCell.getStringCellValue()));

                    }
                } else if (entityDefinition != null) {

                    entityDefinition.addProperties(fieldSymbolicNameCell.getStringCellValue(), getFieldDefinition(fieldNameCell.getStringCellValue(), fieldTypeCell.getStringCellValue()));

                }
            }
            //Ах да, тут и последний запихиваем в коллекцию...
            if (entityDefinition != null) {
                entityDefinitions.add(entityDefinition);
            }

            excelFileIS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entityDefinitions;
    }

    //Соберем-ка мы экземпляр сущности...
    private EntityDefinition createEntityDefinition(EntityType entityType,
                                                    String parentEntitySymbolicName,
                                                    String entityName,
                                                    String entitySymbolicName) {

        EntityDefinition entityDefinition = new EntityDefinition();
        entityDefinition.setEntityType(entityType);
        entityDefinition.setParentEntitySymbolicName(parentEntitySymbolicName);
        entityDefinition.setEntityName(entityName);
        entityDefinition.setEntitySymbolicName(entitySymbolicName);

        return entityDefinition;
    }

    //А тут соберем экземпляр поля сущности...
    private FieldDefinition getFieldDefinition(String fieldName, String fieldType) {
        FieldDefinition fieldDefinition = new FieldDefinition();
        fieldDefinition.setFieldType(FieldType.getFromString(fieldType));
        fieldDefinition.setFieldName(fieldName);
        return fieldDefinition;
    }
}

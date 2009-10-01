/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Admin4DB2
 */
public class POITest {

    public static void main(String[] arg) throws FileNotFoundException, IOException, InvalidFormatException {
        InputStream inp = new FileInputStream("C://workbook.xlsx");
        Workbook wb = WorkbookFactory.create(inp);
        Sheet sheet = wb.getSheetAt(0);
        System.out.println(sheet.getLastRowNum());
        System.out.println(sheet.getPhysicalNumberOfRows());

        Row row = sheet.getRow(0);
        System.out.println(row.getRowNum());
        System.out.println(row.getPhysicalNumberOfCells());

        Cell cell = row.getCell(3);
        if (cell == null) {
            cell = row.createCell(3);
        }
        System.out.println(cell.getStringCellValue());
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue("a test");

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("C://workbook2.xlsx");
        wb.write(fileOut);
        fileOut.close();
    }
}

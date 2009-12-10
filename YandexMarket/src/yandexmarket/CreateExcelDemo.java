/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yandexmarket;

/**
 *
 * @author APopov
 */
import org.apache.poi.hssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class CreateExcelDemo {

    public static void main(String[] args) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet firstSheet = workbook.createSheet("FIRST SHEET");
        HSSFSheet secondSheet = workbook.createSheet("SECOND SHEET");
        HSSFRow rowA = firstSheet.createRow(0);
        HSSFCell cellA = rowA.createCell(0);
        cellA.setCellValue(new HSSFRichTextString("FIRST SHEET"));

        HSSFRow rowB = secondSheet.createRow(0);
        HSSFCell cellB = rowB.createCell(0);
        cellB.setCellValue(new HSSFRichTextString("SECOND SHEET"));

        //
        // To write out the workbook into a file we need to create an output
        // stream where the workbook content will be written to.
        //
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("C://CreateExcelDemo.xlsx"));
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.flush();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


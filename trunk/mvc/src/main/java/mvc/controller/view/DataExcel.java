package mvc.controller.view;

import mvc.model.Data;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import java.util.List;

/**
 * User: Andrey Popov
 * Date: 22.12.10
 * Time: 12:34
 */
public class DataExcel {
    public HSSFWorkbook getDataWorkbook(HSSFWorkbook workbook, List<Data> datas) {
        HSSFSheet sheet = workbook.createSheet("Data");
        HSSFRow row = null;
        HSSFCellStyle style;
//        style.setFillBackgroundColor(HSSFColor.AQUA.index);
//        style.setFillPattern(HSSFCellStyle.BIG_SPOTS);
        HSSFCell cell;
//        cell.setCellValue("X");
//        cell.setCellStyle(style);

        // Orange "foreground",
        //     foreground being the fill foreground not the font color.
//        style = workbook.createCellStyle();
//        style.setFillForegroundColor(HSSFColor.ORANGE.index);
//        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        int x = 0;
        for (Data data : datas) {

            row = sheet.createRow(x++);

            cell = row.createCell(0);
            cell.setCellValue(data.getId());
            cell = row.createCell(1);
            cell.setCellValue(data.getArticle());
            cell = row.createCell(2);
            cell.setCellValue(data.getAttribute());
            cell = row.createCell(3);
            cell.setCellValue(data.getValue());
        }
        return workbook;
    }
}

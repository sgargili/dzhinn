package mvc.controller.view;

import mvc.model.Data;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * User: Andrey Popov
 * Date: 22.12.10
 * Time: 10:50
 */
public class ExcelView extends AbstractExcelView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      HSSFWorkbook workbook,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
//        BusinessPlan businessPlan = new BusinessPlan();
//        workbook = businessPlan.getWorkbook(workbook);
//        System.out.println("dddd");

//        HSSFSheet sheet = workbook.createSheet("new sheet");
//        HSSFRow row = null;
//
//        // Aqua background
//        HSSFCellStyle style;
////        style.setFillBackgroundColor(HSSFColor.AQUA.index);
////        style.setFillPattern(HSSFCellStyle.BIG_SPOTS);
//        HSSFCell cell;
////        cell.setCellValue("X");
////        cell.setCellStyle(style);
//
//        // Orange "foreground",
//        //     foreground being the fill foreground not the font color.
//        style = workbook.createCellStyle();
//        style.setFillForegroundColor(HSSFColor.ORANGE.index);
//        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//
//        for (int x = 0; x < 1000; x++) {
//
//            // Create a row and put some cells in it. Rows are 0 based.
//            row = sheet.createRow(x);
//
//            for (int y = 0; y < 100; y++) {
//                cell = row.createCell(y);
//                cell.setCellValue("X");
//                cell.setCellStyle(style);
//                cell.setCellValue("" + x);
//            }
//        }

        List<Data> datas = (List<Data>) model.get("dataList");
        DataExcel dataExcel = new DataExcel();
        workbook = dataExcel.getDataWorkbook(workbook, datas);
        System.out.println("");

    }
}

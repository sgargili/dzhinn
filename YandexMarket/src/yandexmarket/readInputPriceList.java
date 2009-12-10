/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yandexmarket;

import DAO.ArticlesDAO;
import DAO.FactoryDAO;
import Pojo.Articles;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Admin4DB2
 */
public class readInputPriceList {

    public static void main(String[] args) throws IOException, SQLException {
        Articles art;
        File inputFile = new File("C://input.xlsx");
        String re = "\\.xlsx$";
        Pattern p = Pattern.compile(re);
        Matcher m = p.matcher(inputFile.getName());
        Workbook wb;
        if (m.find()) {
            wb = new XSSFWorkbook(FileUtils.openInputStream(inputFile));
        } else {
            wb = new HSSFWorkbook(FileUtils.openInputStream(inputFile));
        }
        Sheet sheet = wb.getSheetAt(0);
        Row row;
        Cell cell;
        ArticlesDAO artDAO = FactoryDAO.getInstance().getArticlesDAO();
        long tempId;
        for (int rows = 0; rows <= sheet.getLastRowNum(); rows++) {
            art = new Articles();
            row = sheet.getRow(rows);
            cell = row.getCell(0);
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    art.setArticle(cell.getRichStringCellValue().getString().trim());
                    // System.out.println(cell.getRichStringCellValue().getString());
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        art.setArticle(cell.getDateCellValue().toString().trim());
                        //System.out.println(cell.getDateCellValue());
                    } else {
                        art.setArticle(cell.getNumericCellValue() + "");
                        //System.out.println(cell.getNumericCellValue());
                    }
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    art.setArticle(cell.getBooleanCellValue() + "");
                    //System.out.println(cell.getBooleanCellValue());
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    art.setArticle(cell.getCellFormula());
                    // System.out.println(cell.getCellFormula());
                    break;
                default:
                //System.out.println();
            }
            tempId = artDAO.getIdByArticle(art.getArticle());
            if (tempId != 0L) {
                art.setId(tempId);
            }
            cell = row.getCell(1);
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    art.setDescription(cell.getRichStringCellValue().getString().trim());
                    // System.out.println(cell.getRichStringCellValue().getString());
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        art.setDescription(cell.getDateCellValue().toString().trim());
                        //System.out.println(cell.getDateCellValue());
                    } else {
                        art.setDescription(cell.getNumericCellValue() + "");
                        //System.out.println(cell.getNumericCellValue());
                    }
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    art.setDescription(cell.getBooleanCellValue() + "");
                    //System.out.println(cell.getBooleanCellValue());
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    art.setDescription(cell.getCellFormula());
                    // System.out.println(cell.getCellFormula());
                    break;
                default:
                //System.out.println();
            }
            cell = row.getCell(2);
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    art.setPrice(Double.parseDouble(cell.getRichStringCellValue().getString().trim()));
                    // System.out.println(cell.getRichStringCellValue().getString());
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        art.setPrice(Double.parseDouble(cell.getDateCellValue().toString().trim()));
                        //System.out.println(cell.getDateCellValue());
                    } else {
                        art.setPrice(cell.getNumericCellValue());
                        //System.out.println(cell.getNumericCellValue());
                    }
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    art.setPrice(Double.parseDouble(cell.getBooleanCellValue() + ""));
                    //System.out.println(cell.getBooleanCellValue());
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    art.setPrice(Double.parseDouble(cell.getCellFormula()));
                    //System.out.println(cell.getCellFormula());
                    break;
                default:
                //System.out.println();
            }
            FactoryDAO.getInstance().getArticlesDAO().addArticles(art);
        }
    }
}

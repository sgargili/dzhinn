/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yandexmarket;

import DAO.FactoryDAO;
import Pojo.It4articles;
import Pojo.Match;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author APopov
 */
public class DownloadMatchingData {

    public static void main(String[] aargs) throws SQLException, IOException {
        FactoryDAO fd = FactoryDAO.getInstance();
        List it4List = (List) fd.getIt4articlesDAO().getMatchedIt4articles();
        File inputFile = new File("C://MatchingData.xlsx");
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("After Matching Process");
        int j = 1;
        Row row;
        Cell cell1, cell2, cell3, cell4;
        row = sheet.createRow(0);
        cell1 = row.createCell(0);
        cell1.setCellValue("It4Article");
        cell2 = row.createCell(1);
        cell2.setCellValue("It4Description");
        cell3 = row.createCell(2);
        cell3.setCellValue("KeyArticle");
        cell4 = row.createCell(3);
        cell4.setCellValue("KeyDescription");
        for (Iterator artic = it4List.iterator(); artic.hasNext();) {
            It4articles match = (It4articles) artic.next();
            row = sheet.createRow(j);
            cell1 = row.createCell(0);
            cell1.setCellValue(match.getIt4article());
            cell2 = row.createCell(1);
            cell2.setCellValue(match.getDescription());
            cell3 = row.createCell(2);
            cell3.setCellValue(match.getKeyarticle());
            cell4 = row.createCell(3);
            cell4.setCellValue(fd.getArticlesDAO().getDescriptionByArticle(match.getKeyarticle()));
            System.out.println(j++);
        }
        FileOutputStream out = new FileOutputStream(inputFile);
        wb.write(out);
        out.close();
    }
}

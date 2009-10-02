/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xlsprocessing;

import DAO.FactoryDAO;
import Pojo.Matching;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jxl.Sheet;
import jxl.Workbook;

/**
 *
 * @author APopov
 */
public class elabXlsMatch {

    public String addMatching(File file) throws SQLException {

        Long time1 = System.currentTimeMillis();

        FactoryDAO fDao = FactoryDAO.getInstance();

        Long supplierId;
        String supplierArticleName;
        String it4prifitArticleName;
        String supplierArticleDescription;
        String it4prifitArticleDescription;
        Long l = null;
        List lst = new ArrayList();

        try {
            Workbook wb = Workbook.getWorkbook(file); 
            Sheet sheet = wb.getSheet(0);
            int rows = sheet.getRows();
            for (int row = 1; row < rows; row++) {
                supplierId = fDao.getSupplierDAO().getIdBySupplier(sheet.getCell(0, row).getContents());
                supplierArticleName = sheet.getCell(1, row).getContents();
                supplierArticleDescription = sheet.getCell(2, row).getContents();
                it4prifitArticleName = sheet.getCell(3, row).getContents();
                it4prifitArticleDescription = sheet.getCell(4, row).getContents();
              //  Matching mtch = new Matching(supplierId, supplierArticleName, supplierArticleDescription, it4prifitArticleName, l, it4prifitArticleDescription);
              //  lst.add(mtch);
            }
            wb.close();
        } catch (Exception ioe) {
            System.out.println("Error: " + ioe);
        }
        Iterator iterator = lst.iterator();
        while (iterator.hasNext()) {
            Matching matching = (Matching) iterator.next();
            fDao.getMatchingDAO().addMatching(matching);
        }
        Long time2 = System.currentTimeMillis();
        return "Залился Xls файл за: " + (time2 - time1) / 1000 + " сек.";
    }
} 

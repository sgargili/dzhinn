/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xlsprocessing;

import DAO.FactoryDAO;
import Pojo.Supplierprice;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jxl.*;

/**
 *
 * @author APopov
 */
public class elabXslSupp {

    public String addSupplierPrice(File file) throws SQLException {

        Long time1 = System.currentTimeMillis();

        FactoryDAO fDao = FactoryDAO.getInstance();

        Long supplierId = null;
        String supplierArticleName;
        double supplierArticlePrice;
        List lst = new ArrayList();

        try {
            Workbook wb = Workbook.getWorkbook(file);
            Sheet sheet = wb.getSheet(0);
            int rows = sheet.getRows();
            for (int row = 1; row < rows; row++) {

                supplierId = fDao.getSupplierDAO().getIdBySupplier(sheet.getCell(0, row).getContents());
                //  supplierId = 1L;
                supplierArticleName = sheet.getCell(1, row).getContents();
                supplierArticlePrice = Double.valueOf(sheet.getCell(2, row).getContents()).doubleValue();
                Supplierprice sp = new Supplierprice(supplierId, supplierArticleName, supplierArticlePrice);
                lst.add(sp);
            }
            wb.close();
        } catch (Exception ioe) {
            System.out.println("Error: " + ioe);
        }
        Iterator iterator = lst.iterator();
        while (iterator.hasNext()) {
            Supplierprice supplierprice = (Supplierprice) iterator.next();
            if (fDao.getSupplierPriceDAO().isSupplierArticlePresent(supplierprice.getSupplierArticleName())) {
                fDao.getSupplierPriceDAO().updateSupplierprice(supplierprice);
            } else {
                fDao.getSupplierPriceDAO().addSupplierprice(supplierprice);
            }
        }
        Long time2 = System.currentTimeMillis();
        return "Залился Xls файл за: " + (time2 - time1) / 1000 + " сек.";
    }
}

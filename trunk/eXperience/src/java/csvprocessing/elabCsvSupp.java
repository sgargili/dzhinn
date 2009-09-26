/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csvprocessing;

import DAO.FactoryDAO;
import Pojo.Supplierprice;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author APopov
 */
public class elabCsvSupp {

    @SuppressWarnings("static-access")
    public String addSupplierPrice(File file) throws SQLException, IOException {
        Long time1 = System.currentTimeMillis();
        FactoryDAO fDao = FactoryDAO.getInstance();
        Long supplierId;
        String supplierArticleName, supplierArticleDescription;
        int cur;
        double supplierArticlePrice;
        List lst = new ArrayList();
        try {
            CsvReader reader = new CsvReader(file.getAbsolutePath(), ',', Charset.forName("UTF-8"));
            reader.readHeaders();

            while (reader.readRecord()) {

                supplierId = fDao.getSupplierDAO().getIdBySupplier(reader.get(0));
                if (supplierId == null) {
                    continue;
                }
                supplierArticleName = reader.get(1);
                supplierArticleDescription = reader.get(2);
                supplierArticlePrice = Double.valueOf(reader.get(3)).doubleValue();
                cur = fDao.getCurrencyDAO().getCurrencyIdByName(reader.get(4));
                Supplierprice sp = new Supplierprice(supplierId, supplierArticleName, supplierArticleDescription, supplierArticlePrice, cur);
                lst.add(sp);

            }
            reader.close();
        } catch (Exception ioe) {
            System.out.println("Error: " + ioe);
        }
        Iterator iterator = lst.iterator();
        while (iterator.hasNext()) {
            Supplierprice supplierprice = (Supplierprice) iterator.next();
            if (fDao.getSupplierPriceDAO().isSupplierArticlePresentbySupplier(supplierprice.getSupplierArticleName(), supplierprice.getSupplierId())) {
                supplierprice.setId(fDao.getSupplierPriceDAO().getIdBySupplierByArticle(supplierprice.getSupplierId(), supplierprice.getSupplierArticleName()));
                fDao.getSupplierPriceDAO().updateSupplierprice(supplierprice);
            } else {
                fDao.getSupplierPriceDAO().addSupplierprice(supplierprice);
            }

        }

        Long time2 = System.currentTimeMillis();
        return "Залился Csv файл за: " + (time2 - time1) / 1000 + " сек.";
    }
}


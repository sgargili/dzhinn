/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csvprocessing;

import DAO.FactoryDAO;
import Pojo.Matching;
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
public class elabCsvMatch {

    public String addMatching(File file, String SupplierName) throws SQLException, IOException {
        Long time1 = System.currentTimeMillis();
        FactoryDAO fDao = FactoryDAO.getInstance();
        Long supplierId = fDao.getSupplierDAO().getIdBySupplier(SupplierName);
        String supplierArticleName;
        String it4prifitArticleName;
        String supplierArticleDescription;
        String it4prifitArticleDescription;
        Long l = null;
        List lst = new ArrayList();
        try {
            CsvReader reader = new CsvReader(file.getAbsolutePath(), ',', Charset.forName("WINDOWS-1251"));
            reader.readHeaders();

//            while (reader.readRecord()) {
//                supplierArticleName = reader.get(0);
//                supplierArticleDescription = reader.get(1);
//                it4prifitArticleName = reader.get(2);
//                it4prifitArticleDescription = reader.get(3);
//                Matching mtch = new Matching(supplierId, supplierArticleName, supplierArticleDescription, it4prifitArticleName, l, it4prifitArticleDescription);
//                lst.add(mtch);
//
//            }
            reader.close();
        } catch (Exception ioe) {
            System.out.println("Error: " + ioe);
        }
        Iterator iterator = lst.iterator();
        while (iterator.hasNext()) {
            Matching matching = (Matching) iterator.next();
            if (fDao.getMatchingDAO().isMatchingPresent(matching.getSupplierArticleName(), matching.getSupplierId())) {
                fDao.getMatchingDAO().updateMatching(matching);
            } else {
                fDao.getMatchingDAO().addMatching(matching);
            }

            //fDao.getMatchingDAO().addMatching(matching);
        }

        Long time2 = System.currentTimeMillis();
        return "Залился Csv файл за: " + (time2 - time1) / 1000 + " сек.";

    }
}

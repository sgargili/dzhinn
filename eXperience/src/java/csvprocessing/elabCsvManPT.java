/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csvprocessing;

import DAO.FactoryDAO;
import Pojo.Manufacturer;
import java.io.File;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import processing.ArrayDuplDel;

/**
 *
 * @author APopov
 */
public class elabCsvManPT {

    public String addManPT(File file, boolean bool) throws SQLException {
        int i = 0;
        Long time1 = System.currentTimeMillis();
        FactoryDAO fDao = FactoryDAO.getInstance();
        
        String Manufac;
//        Long supplierId = fDao.getSupplierDAO().getIdBySupplier(SupplierName);
//        String supplierArticleName;
//        String it4prifitArticleName;
//        String supplierArticleDescription;
//        String it4prifitArticleDescription;
//        Long l = null;
       List lst = new ArrayList();
        try {
            CsvReader reader = new CsvReader(file.getAbsolutePath(), ',', Charset.forName("UTF-8"));
            reader.readHeaders();
            while (reader.readRecord()) {
                Manufac = reader.get(1);
                lst.add(Manufac);
                i++;
            }
            reader.close();
        } catch (Exception ioe) {
            System.out.println("Error: " + ioe);
        }
       String[] sl = (String[]) lst.toArray(new String[0]);
      // Object[] aaa = lst.toArray();
       // return "" + lst.size()+" "+aaa.length;
        ArrayDuplDel ad = new ArrayDuplDel();
        String[] man;
        man = ad.ArrayDuplDel(sl);
     //   return "" + man.length;
        for (i = 0; i < man.length; i++) {
            Manufacturer mn = new Manufacturer(man[i]);
            System.out.println(man[i]+" ");
            fDao.getManufacturerDAO().addManufacturer(mn);
        }
//        Iterator iterator = lst.iterator();
//        while (iterator.hasNext()) {
//            Matching matching = (Matching) iterator.next();
//            if (fDao.getMatchingDAO().isMatchingPresent(matching.getSupplierArticleName(), matching.getSupplierId())) {
//                fDao.getMatchingDAO().updateMatching(matching);
//            } else {
//                fDao.getMatchingDAO().addMatching(matching);
//            }
//
//            //fDao.getMatchingDAO().addMatching(matching);
//        }

        Long time2 = System.currentTimeMillis();
       return "Залился Csv файл за: " + (time2 - time1) / 1000 + " сек.";
    }
}

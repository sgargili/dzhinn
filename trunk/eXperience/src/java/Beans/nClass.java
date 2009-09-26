package Beans;

import Pojo.Supplierprice;
import csvprocessing.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*To change this template, choose Tools | Templates*/
/* To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author APopov
 */
public class nClass {
//
//    public List FullBean() throws FileNotFoundException, IOException {
////        CsvReader reader = new CsvReader("c:\\NIX3.csv", ',', Charset.forName("UTF-8"));
////
////        reader.readHeaders();
//////        int i = 0;
////        List lst = new ArrayList();
////        double d;
////        Long w=123456789L;
////        while (reader.readRecord()) {
////
////            String productID = reader.get(0);
////            String productID2 = reader.get(1);
////            d = Double.valueOf(productID2).doubleValue();
////            Supplierprice csvstr = new Supplierprice(w, productID, d);
////            lst.add(csvstr);
////            //System.out.println(productID + "\t" + productID2 + "\t" + productID3);
//////            String productName = reader.get("ProductName");
//////            System.out.print(productName + "\t");
//////            String supplierID = reader.get("SupplierID");
//////            System.out.print(supplierID + "\t");
//////            String categoryID = reader.get("CategoryID");
//////            System.out.print(categoryID + "\t");
//////            String quantityPerUnit = reader.get("QuantityPerUnit");
//////            System.out.print(quantityPerUnit + "\t");
//////            String unitPrice = reader.get("UnitPrice");
//////            System.out.print(unitPrice + "\t");
//////            String unitsInStock = reader.get("UnitsInStock");
//////            System.out.print(unitsInStock + "\t");
//////            String unitsOnOrder = reader.get("UnitsOnOrder");
//////            System.out.print(unitsOnOrder + "\t");
//////            String reorderLevel = reader.get("ReorderLevel");
//////            System.out.print(reorderLevel + "\t");
//////            String discontinued = reader.get("Discontinued");
//////            System.out.println(discontinued);
//////            // perform program logic here
//////            i++;
////        }
//////        for (Iterator it = lst.iterator(); it.hasNext();) {
//////            CsvBean bean = (CsvBean) it.next();
//////            //System.out.println(bean.getPrice().replaceAll("руб", ""));
//////        }
////
////        reader.close();
////        Collections.sort(lst, new Comparator<Supplierprice>() {
////            // @Override
////
////            public int compare(Supplierprice o1, Supplierprice o2) {
////                String withoutEx1 = o1.getSupplierArticleName();
////                String withoutEx2 = o2.getSupplierArticleName();
////                return withoutEx1.compareTo(withoutEx2);
////            }
//////            public int compare(DataBean o1, DataBean o2) {
//////                throw new UnsupportedOperationException("Not supported yet.");
//////            }
////        });
////        return lst;
//    }
}

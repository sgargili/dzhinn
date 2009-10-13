/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CSV;

/**
 *
 * @author APopov
 */
import DAO.FactoryDAO4Imports;
import Pojo.PcProductTypes;
import Pojo.PcProductsToPt;
import Pojo.PcSyncProducts;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CsvElab {

    @SuppressWarnings("static-access")
    public void CsvProdToPT() throws IOException, SQLException {
        File file = new File("C://articles.csv");
        int i = 0;
        List<PcProductTypes> ptl = (List<PcProductTypes>) FactoryDAO4Imports.getPcProductTypesDAO().getAllPcProductTypes();
        System.out.println(ptl.size());
        Collections.sort(ptl, new Comparator<PcProductTypes>() {

            public int compare(PcProductTypes o1, PcProductTypes o2) {
                String withoutEx1 = o1.getPtName();
                String withoutEx2 = o2.getPtName();
                return withoutEx1.compareTo(withoutEx2);
            }
        });
        List<PcSyncProducts> pspl = (List<PcSyncProducts>) FactoryDAO4Imports.getPcSyncProductsDAO().getAllPcSyncProducts();
        System.out.println(pspl.size());

        Collections.sort(pspl, new Comparator<PcSyncProducts>() {

            public int compare(PcSyncProducts o1, PcSyncProducts o2) {
                String withoutEx1 = o1.getProductsModel();
                String withoutEx2 = o2.getProductsModel();
                return withoutEx1.compareTo(withoutEx2);
            }
        });
        PcProductsToPt ptpt;
        try {
            CsvReader reader = new CsvReader(file.getAbsolutePath(), ',', Charset.forName("UTF-8"));
            reader.readHeaders();

            while (reader.readRecord()) {
                ptpt = new PcProductsToPt();

                Iterator iterator = pspl.iterator();
                while (iterator.hasNext()) {
                    PcSyncProducts prod = (PcSyncProducts) iterator.next();
                    if (prod.getProductsModel().equals(reader.get(2).trim())) {
                        Iterator iterator2 = ptl.iterator();
                        while (iterator2.hasNext()) {
                            PcProductTypes pt = (PcProductTypes) iterator2.next();
                            if (pt.getPtName().equals(reader.get(0).trim())) {
                                ptpt.setPtId(pt.getPtId());
                                break;
                            } else {
                                //System.out.println(reader.get(2).trim() + " " + reader.get(0) + " не найдено.");
                            }
                        }
                        ptpt.setProductsId(prod.getProductsId());
                        break;
                    }
                }
//                if (ptpt.getProductsId() != 0) {
                //System.out.println(i + " " + ptpt.getProductsId() + " -> " + ptpt.getPtId());
                // FactoryDAO4Imports.getInstance().getPcProductsToPtDAO().addPcProductsToPt(ptpt);
                i++;
//                }
            }
            System.out.println(i);
            reader.close();
        } catch (Exception ioe) {
            System.out.println("Error: " + ioe);
        }




    }
}

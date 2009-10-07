/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jimport;

import DAO.FactoryDAO;
import Pojo.PcSyncProducts;
import XML.xmlElab;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import javax.xml.transform.TransformerException;
import org.xmlpull.v1.XmlPullParserException;

/**
 *
 * @author APopov
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("static-access")
    public static void main(String[] args) throws SQLException, XmlPullParserException, IOException, TransformerException {
        // TODO code application logic here
//        List<PcSyncProducts> lst = (List<PcSyncProducts>) FactoryDAO.getInstance().getPcSyncProductsDAO().getAllPcSyncProducts();
//        int i = 1;
//        for (Iterator it = lst.iterator(); it.hasNext();) {
//            PcSyncProducts str = (PcSyncProducts) it.next();
//            System.out.println(i + " ---> " + str.getProductsModel());
//            i++;
//        }
        xmlElab xml = new xmlElab();
       // xml.xmlPcSyncProducts();
        xml.xmlPcSyncProductsDescription();

    }
}

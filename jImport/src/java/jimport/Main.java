/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jimport;

import java.io.IOException;
import java.sql.SQLException;
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
        //xmlElab xml = new xmlElab();
        // xml.xmlPcSyncProducts();
        //System.out.println("First Done...");
//        //xml.xmlPcSyncProductsDescription();
//        List lst = FactoryDAO4Imports.getInstance().getPcProductsAvailableDAO().getPcProductsAvailable();
//        int i = 1;
//        for (Iterator it = lst.iterator(); it.hasNext();) {
//            PcProductsAvailable str = (PcProductsAvailable) it.next();
//            System.out.println(i++ + " -> " + str.getModel());
//        }
        // FactoryDAO4Imports.getInstance().getPcSyncProductsDescriptionDAO().truncatePcSyncProductsDescription();
       // System.out.println(FactoryDAO4Imports.getInstance().getTestHPDAO().getTestHP(8833));
    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jimport;

import XML.xmlElab;
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
        xmlElab xml = new xmlElab();
        //xml.xmlPcSyncProducts();
        xml.xmlPcSyncProductsDescription();

    }
}

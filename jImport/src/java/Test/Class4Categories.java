/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import XML.xmlElab;
import java.io.IOException;
import java.sql.SQLException;
import javax.xml.transform.TransformerException;
import org.xmlpull.v1.XmlPullParserException;

/**
 *
 * @author APopov
 */
public class Class4Categories {

    public static void main(String[] args) throws SQLException, IOException, XmlPullParserException, TransformerException {
        xmlElab xmle = new xmlElab();
        xmle.xmlPcSyncProducts();
        //xmle.xmlCategoriesExport();
        //xmle.oldXML();
       // xmle.xmlPcSyncProductsDescription();
        //System.out.println(xmle.xmlProductsToCategoriesExport());
    }
}

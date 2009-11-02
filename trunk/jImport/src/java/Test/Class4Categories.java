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
        //xmle.xmlPcSyncProducts();
        //System.out.println("PCSyncProducts - Done!");
        //xmle.xmlCategoriesExport();
        //System.out.println("CategoriesExport - Done!");
        //System.out.println(xmle.xmlProductsToCategoriesExport());
        xmle.xmlPcSyncProductsDescription();
        //System.out.println("PcSyncProductsDescription - Done!");
    }
}

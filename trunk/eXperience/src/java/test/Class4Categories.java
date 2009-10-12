/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import XML.xmlElab;
import java.io.IOException;
import java.sql.SQLException;
import org.xmlpull.v1.XmlPullParserException;

/**
 *
 * @author APopov
 */
public class Class4Categories {

    public static void main(String[] args) throws SQLException, IOException, XmlPullParserException {
        xmlElab xmle = new xmlElab();
        //xmle.xmlCategoriesExport();
        //xmle.oldXML();
        System.out.println(xmle.xmlProductsToCategoriesExport());
    }
}

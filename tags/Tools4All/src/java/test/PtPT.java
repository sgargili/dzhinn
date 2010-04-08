/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import csv.CsvElab;
import java.io.IOException;
import java.sql.SQLException;
import org.xmlpull.v1.XmlPullParserException;

/**
 *
 * @author APopov
 */
public class PtPT {

    public static void main(String[] arg) throws IOException, SQLException, XmlPullParserException {
        CsvElab csv = new CsvElab();
        //csv.realPT();
         csv.CsvProdToPT();
        //csv.CsvManToPT();
       // csv.updateMan();
    }
}

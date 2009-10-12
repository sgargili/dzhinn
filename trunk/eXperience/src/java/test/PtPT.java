/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import CSV.CsvElab;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author APopov
 */
public class PtPT {

    public static void main(String[] arg) throws IOException, SQLException {
        CsvElab csv = new CsvElab();
        csv.CsvProdToPT();
    }
}
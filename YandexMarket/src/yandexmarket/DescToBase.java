/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yandexmarket;

import CSV.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import DAO.FactoryDAO;
import Pojo.Newarticles;
import java.sql.SQLException;

/**
 *
 * @author IRozhkov
 */
public class DescToBase {

    public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {

        String kart, vend, desc, sdesc = "";
        FactoryDAO fd = FactoryDAO.getInstance();
        Newarticles searchArt;
        CsvReader rdr = new CsvReader("/home/ilyahoo/NetBeansProjects/1/InputArt.csv", ',', Charset.forName("Windows-1251"));

        while (rdr.readRecord()) {
            kart = rdr.get(0).trim();
            vend = rdr.get(1).trim();
            desc = rdr.get(2).trim();
            sdesc = rdr.get(3).trim();
            System.out.println("Добавлено: "+kart+", "+vend+", "+sdesc);

            searchArt = new Newarticles();
            searchArt.setKeyart(kart);
            searchArt.setSearchdesc(sdesc);
            searchArt.setVendor(vend);
            searchArt.setLongdescr(desc);
            fd.getnewArticlesDAO().addnArticles(searchArt);
        }
        rdr.close();

    }
}

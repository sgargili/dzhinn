/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yandexmarket;

import CSV.CsvReader;
import DAO.FactoryDAO;
import Pojo.It4articles;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;

/**
 *
 * @author APopov
 */
public class ReadIt4Articles {

    public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
        FactoryDAO fd = FactoryDAO.getInstance();
        CsvReader reader = new CsvReader("c://It4Articles.csv", ',', Charset.forName("UTF-8"));
        reader.readHeaders();
        int i = 1;
        It4articles it;
        while (reader.readRecord()) {
            System.out.println(i++);
            it = new It4articles();
            it.setIt4article(reader.get(0));
            fd.getIt4articlesDAO().addIt4articles(it);
        }
    }
}


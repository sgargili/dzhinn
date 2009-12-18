/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yandexmarket;

import DAO.FactoryDAO;
import Pojo.Articles;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author APopov
 */
public class BaseFix {

    public static void main(String[] args) throws SQLException {
        FactoryDAO fd = FactoryDAO.getInstance();
        List<Articles> articles = (List<Articles>) fd.getArticlesDAO().getAllArticles();
        int i = 1;
        for (Iterator iter = articles.iterator(); iter.hasNext();) {
            Articles art = (Articles) iter.next();
            art.setDescription(art.getDescription()//
                    .replaceAll("^\"", "")//
                    .replaceAll("\"$", "")//
                    .replaceAll("\"\"", "\"")//
                    );
            fd.getArticlesDAO().addArticles(art);
            System.out.println(i++);
        }

    }
}

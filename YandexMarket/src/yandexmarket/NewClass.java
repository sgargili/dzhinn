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
public class NewClass {

    public static void main(String[] args) throws SQLException {
//        try {
//            System.out.println(FactoryDAO.getInstance().getRivalsDataDAO().getAveragePriceByArticleId(3));
//        } catch (SQLException ex) {
//        }
//        int k = 358;
//        Double d;
//        if (k != 0 && k % 2 == 0) // если чЄтное - остаток от делени€ на 2 должен быть нулЄм
//        {
//            d = new Double(k / 10.0);
//            System.out.println(Math.round(d));
//            System.out.println("јга...");   // переменна€ определ€юща€, чЄтное число или нет. true - чЄтное, false -  нечетное
//        } else {
//            System.out.println(k % 2);
//            System.out.println("Ќеа...");   // переменна€ определ€юща€, чЄтное число или нет. true - чЄтное, false -  нечетное
////        }
//        int i = 1;
//        for (int j = 0; j < i; j++) {
//            System.out.println(j);
//            i=2;

//        }
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
            //fd.getArticlesDAO().addArticles(art);
            System.out.println(i++ + " " + art.getDescription());
        }

    }
}

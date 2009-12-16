/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yandexmarket;

import DAO.FactoryDAO;
import Pojo.Articles;
import Pojo.It4articles;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author APopov
 */
public class FirstMatching {

    public static void main(String[] args) throws SQLException {
        FactoryDAO fd = FactoryDAO.getInstance();
        List profitList = (List) fd.getIt4articlesDAO().getAllIt4articles();
        //System.out.println(profitList.size());
        It4articles profit;
        Articles key;
        List keyList = (List) fd.getArticlesDAO().getAllArticles();
        //System.out.println(keyList.size());
        Pattern pat;
        Matcher mat;
        Iterator profitIter;
        Iterator keyIter;
        int i = 0, k = 0;
        for (profitIter = profitList.iterator(); profitIter.hasNext();) {
            profit = (It4articles) profitIter.next();
            for (keyIter = keyList.iterator(); keyIter.hasNext();) {
                key = (Articles) keyIter.next();
                pat = Pattern.compile(profit.getIt4article());
                mat = pat.matcher(key.getDescription());
                if (mat.find()) {
                    profit.setKeyarticle(key.getArticle());
                    fd.getIt4articlesDAO().addIt4articles(profit);
                    System.out.println(k + " Пройдено. Найдено - > " + i++);
                    //System.out.println(profit.getIt4article() + " -> " + profit.getKeyarticle());
                    keyList.remove(key);
                    break;
                }
            }
            k++;
        }
    }
}

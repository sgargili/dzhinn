/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yandexmarket;

import DAO.FactoryDAO;
import Pojo.RivalsdataId;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.collections.FastArrayList;

/**
 *
 * @author Администратор
 */
public class masTest {

    public static void main(String[] args) throws SQLException {
        double lst = FactoryDAO.getInstance().getRivalsDataDAO().getMinimumPriceByArticleId(1);
        System.out.println("Наименьшая цена ->" + lst);
        lst = FactoryDAO.getInstance().getRivalsDataDAO().getMinimumSumPriceByArticleId(1);
        System.out.println("Наименьшая цена + доставка ->" + lst);
        RivalsdataId rId = FactoryDAO.getInstance().getRivalsDataDAO().getId4MinimumPriceByArticleId(1);
        System.out.println(rId.toString());
//        Set st = new HashSet();
//        for (int i = 0; i < 5; i++) {
//            st.add(i);
//        }
//        st.add(2);
//        st.
//        System.out.println(st.size());
//        for (Iterator it = st.iterator(); it.hasNext();) {
//            System.out.println(it.next().toString());
//        }
    }
}

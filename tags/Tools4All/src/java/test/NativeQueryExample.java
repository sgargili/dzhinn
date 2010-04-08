/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Admin4DB2
 */
import pojo.testBean;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

public class NativeQueryExample {

    public static void main(String[] args) {
        Session session = null;
        List<testBean> tbl = new ArrayList();
        testBean tb;
        try {
            SessionFactory sessionFactory =
                    new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            List insurance = session.createSQLQuery("select cd.categories_name, cat.categories_image from categories_description cd join categories cat on cat.categories_id = cd.categories_id") //  .addEntity("cd", CategoriesDescription.class)
                    .list();
            for (Iterator it = insurance.iterator(); it.hasNext();) {
                Object[] insuranceObject = (Object[]) it.next();
                System.out.println(insuranceObject[0]+""+insuranceObject[1]);
            }
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
//select cd.categories_name, cat.categories_image from categories_description cd join categories cat on cd.categories_id = cat.categories_id


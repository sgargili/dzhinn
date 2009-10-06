/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author Admin4DB2
 */
import Pojo.testBean;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

public class NativeQueryExample {

    public static void main(String[] args) {
        Session session = null;
        List<testBean> tbl = null;
        testBean tb;
        try {
            SessionFactory sessionFactory =
                    new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
//            String sql = "select stddev(ins.invested_amount) as stdErr," + " avg(ins.invested_amount) as mean " + " from insurance ins";
//            Query query = session.createSQLQuery(sql).addScalar("stdErr", Hibernate.DOUBLE).
//                    addScalar("mean", Hibernate.DOUBLE);
//            Object[] amount = (Object[]) query.uniqueResult();
//            System.out.println("mean amount: " + amount[0]);
//            System.out.println("stdErr amount: " + amount[1]);

            //   List insurance = session.createSQLQuery("select ins.categories_id from categories_description as ins")
            List insurance = session.createSQLQuery("select cd.categories_name, cat.categories_image from categories_description cd join categories cat on cat.categories_id = cd.categories_id") //  .addEntity("cd", CategoriesDescription.class)
                    //.addEntity("cat", Categories.class)
                    .list();
           // System.out.println(insurance.get(0));
            for (Iterator it = insurance.iterator(); it.hasNext();) {
                Object[] insuranceObject = (Object[]) it.next();
                System.out.println("ID: " + insuranceObject[0] + " Name: " + insuranceObject[1]);
                try{
                tb = new testBean((String) insuranceObject[0], (String) insuranceObject[1]);
                tbl.add(tb);
                } catch(NullPointerException e){
                tb = new testBean("e","r");
               // tbl.add(tb);
                }
            }
            for (Iterator it = tbl.iterator(); it.hasNext();) {
                testBean insuranceObject = (testBean) it.next();
                System.out.println("ID: " + insuranceObject.getPT() + " Name: " + insuranceObject.getLink());

            }
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
//select cd.categories_name, cat.categories_image from categories_description cd join categories cat on cd.categories_id = cat.categories_id


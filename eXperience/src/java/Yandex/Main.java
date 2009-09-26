/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Yandex;

/**
 *
 * @author Admin4DB2
 */
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) throws Exception {

        sampleWrite();
        //sampleRead();
    }

    static Session getHibernateSession() throws
            MappingException, HibernateException, Exception {
        Session session = null;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();

        return session;
    }

    static void sampleWrite() throws MappingException, HibernateException, Exception {
        XmlElab XmlList = new XmlElab();
        List nlst = XmlList.FullBeanXml();
        Transaction save = null;
        Session session = getHibernateSession();
        save = session.beginTransaction();
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        for (Iterator it = nlst.iterator(); it.hasNext();) {
            DataBean bean = (DataBean) it.next();
            double d = Double.valueOf(bean.getPrice()).doubleValue();


            Yandexprices newPerson = new Yandexprices(Integer.parseInt(bean.getId()), bean.getName(), "First Concurent", "First Delivery", "First Opinion", d, "http://www.google.ru", sqlDate);
            // newPerson.setId(3);
            session.save(newPerson);
//        newPerson = new Yandexprices(333, "Description Second", "Second Concurent", "Second Delivery", "Second Opinion", 36000.0, "http://www.google.ru/2", sqlDate);
            // newPerson.setId(4);
            //session.save(newPerson);
        }
        save.commit();
        session.close();
    }
//    static void sampleRead() throws
//            MappingException, HibernateException, Exception {
//        Session session = getHibernateSession();
//        Query getByLastName =
//                session.createQuery(
//                "from People p where lastName = :var and id = :var2");
//        getByLastName.setString("var", "Frost");
//        getByLastName.setInteger("var2", 3);
//        List result = getByLastName.list();
//        System.out.println("Number of Objects: " + result.size());
//        People frost = (People) result.get(0);
//        System.out.println(frost);
//        session.close();
//    }
}

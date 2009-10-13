/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Util.HibernateUtil4Imports;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin4DB2
 */
public class JoinTest {

    public static void main(String[] args) {
        Session session = null;
        List result = null;
        session = HibernateUtil4Imports.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createSQLQuery(
                    "select cd.categories_name, cat.categories_image" +
                    " from Categories_Description cd" +
                    " join Categories cat on cd.categories_id = cat.categories_id");
            result = getByLogin.list();
            for (Iterator it = result.iterator(); it.hasNext();) {
                Object[] row = (Object[]) it.next();
                System.out.println(row[0].toString()+" -> "+row[1].toString());
            }
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}

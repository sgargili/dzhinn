/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.TempPojoDAO;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.TempPojo;
import utilities.HibernateUtil;

/**
 *
 * @author admin
 */
public class TempPojoDAOImpl implements TempPojoDAO {

    public List getAllTempPojo() throws SQLException {
        Session session = null;
        List<TempPojo> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from TempPojo t");
            result = getByLogin.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }
}

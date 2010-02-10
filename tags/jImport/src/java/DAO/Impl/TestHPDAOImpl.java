/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.TestHPDAO;
import Pojo.TestHP;
import Util.HibernateUtil4Imports;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin4DB2
 */
public class TestHPDAOImpl implements TestHPDAO {

    public String getTestHP(int input) throws SQLException {
        Session session = null;
        List<TestHP> result = null;
        session = HibernateUtil4Imports.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.getNamedQuery("TestHP")
                    .setInteger("id", input);
            result = getByLogin.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result.get(0).getArticle();
    }
}

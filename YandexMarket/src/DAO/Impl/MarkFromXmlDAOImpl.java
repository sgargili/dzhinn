/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Impl;
import DAO.MarkFromXmlDAO;
import Pojo.MarkFromXml;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;
/**
 *
 * @author ilyahoo
 */
public class MarkFromXmlDAOImpl implements MarkFromXmlDAO{
    @Override
    public void addKeys(MarkFromXml keys) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(keys);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Collection getAllKeys() throws SQLException {
        Session session = null;
        List<MarkFromXml> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getArticles =
                    session.createQuery(
                    "from MarkFromXml a");
            result = getArticles.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }


}

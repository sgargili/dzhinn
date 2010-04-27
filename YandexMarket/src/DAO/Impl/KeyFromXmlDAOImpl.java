/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Impl;

import DAO.*;
import DAO.KeyFromXmlDAO;
import Pojo.KeyFromXml;
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
public class KeyFromXmlDAOImpl implements KeyFromXmlDAO {

    @Override
    public void addKeys(KeyFromXml keys) throws SQLException {
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
        List<KeyFromXml> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getArticles =
                    session.createQuery(
                    "from KeyFromXml a");
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.KeyWarrantyDAO;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.Keywarranty;
import utilities.HibernateUtil;

/**
 *
 * @author APopov
 */
public class KeyWarrantyDAOImpl implements KeyWarrantyDAO {

    public void addKeyWarranty(Keywarranty keywarranty) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(keywarranty);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

//    public List getKeyWarranty(int firstResult, int maxResult) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
    public List getKeyWarranty() throws SQLException {
        Session session = null;
        List<Keywarranty> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Keywarranty k");
            result = getByLogin.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public String getWarrantyByArticle(String article) throws SQLException {
        Session session = null;
        List<Keywarranty> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String out = "";
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Keywarranty k where keyarticle = :art")//
                    .setString("art", article);
            result = getByLogin.list();
            out = result.get(0).getKeywarranty();
        } catch (Exception e) {
            out = "";
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }

    public boolean isWarrantyPresent(String article) throws SQLException {
        Session session = null;
        List<Keywarranty> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        boolean out = false;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Keywarranty k where keyarticle = :art")//
                    .setString("art", article);
            result = getByLogin.list();
            out = !result.isEmpty();
        } catch (Exception e) {
            out = false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }
}

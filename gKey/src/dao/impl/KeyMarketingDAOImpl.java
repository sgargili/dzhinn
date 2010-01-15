/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.KeyMarketingDAO;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.Keymarketing;
import utilities.HibernateUtil;

/**
 *
 * @author Apopov
 */
public class KeyMarketingDAOImpl implements KeyMarketingDAO {

    public void addKeyMarketing(Keymarketing keymarketing) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(keymarketing);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List getAllKeydata(int firstResult, int maxResult) throws SQLException {
        Session session = null;
        List<Keymarketing> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Keymarketing k")//
                    .setMaxResults(maxResult)//
                    .setFirstResult(firstResult);
            result = getByLogin.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public List getAllKeydata() throws SQLException {
        Session session = null;
        List<Keymarketing> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Keymarketing k order by keyarticle");
            result = getByLogin.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public String getMarketingByArticle(String article) throws SQLException {
        Session session = null;
        List<Keymarketing> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String out = "";
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Keymarketing k where keyarticle = :art")//
                    .setString("art", article);
            result = getByLogin.list();
            out = result.get(0).getKeymarketing();
        } catch (Exception e) {
            out = "";
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }

    public boolean isMarketingPresent(String article) throws SQLException {
        Session session = null;
        List<Keymarketing> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        boolean out = false;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Keymarketing k where keyarticle = :art")//
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

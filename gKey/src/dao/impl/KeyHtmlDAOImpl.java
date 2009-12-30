/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.KeyHtmlDAO;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.Keyhtml;
import utilities.HibernateUtil;

/**
 *
 * @author APopov
 */
public class KeyHtmlDAOImpl implements KeyHtmlDAO {

    public void addKeyHtml(Keyhtml keyhtml) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(keyhtml);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List getAllKeyHtml(int firstResult, int maxResult) throws SQLException {
        Session session = null;
        List<Keyhtml> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Keyhtml k")//
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

    public List getAllKeyHtml() throws SQLException {
        Session session = null;
        List<Keyhtml> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Keyhtml k");
            result = getByLogin.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public String getHtmlByArticle(String article) throws SQLException {
        Session session = null;
        List<Keyhtml> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String out = "";
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Keyhtml k where keyarticle = :art")//
                    .setString("art", article);
            result = getByLogin.list();
            out = result.get(0).getKeyhtml();
        } catch (Exception e) {
            out = "";
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }

    public boolean isHtmlPresent(String article) throws SQLException {
        Session session = null;
        List<Keyhtml> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        boolean out = false;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Keyhtml k where keyarticle = :art")//
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

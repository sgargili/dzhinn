/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.MatchingDAO;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.Matching;
import utilities.HibernateUtil;

/**
 *
 * @author APopov
 */
public class MatchingDAOImpl implements MatchingDAO {

    public void addMatching(Matching matching) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(matching);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List getAllMatching() throws SQLException {
        Session session = null;
        List<Matching> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Matching m");
            result = getByLogin.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public int getMatchingIdByArticle(String article) throws SQLException {
        Session session = null;
        List<Matching> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        int out = 0;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Matching m where keyarticle = :art")//
                    .setString("art", article);
            result = getByLogin.list();
            out = result.get(0).getId();
        } catch (Exception e) {
            out = 0;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }

    public boolean isMatchingPresent(String article) throws SQLException {
        Session session = null;
        List<Matching> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        boolean out = false;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Matching k where keyarticle = :art")//
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

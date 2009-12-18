/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.MatchingDAO;
import Pojo.Matching;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author APopov
 */
public class MatchingDAOImpl implements MatchingDAO {

    @Override
    public void addMatching(Matching matching) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(matching);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Collection getAllMatching() throws SQLException {
        Session session = null;
        List<Matching> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getArticles =
                    session.createQuery(
                    "from Matching");
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

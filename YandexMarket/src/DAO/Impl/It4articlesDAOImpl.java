/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.It4articlesDAO;
import Pojo.It4articles;
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
public class It4articlesDAOImpl implements It4articlesDAO {

    @Override
    public void addIt4articles(It4articles it4articles) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(it4articles);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Collection getAllIt4articles() throws SQLException {
        Session session = null;
        List<It4articles> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getArticles =
                    session.createQuery(
                    "from It4articles");
            result = getArticles.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public String getIt4articleById(long id) throws SQLException {
        Session session = null;
        List<It4articles> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String out = "";
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from It4articles a where id = :art_id")//
                    .setLong("art_id", id);
            result = getByLogin.list();
            out = result.get(0).getIt4article();
        } catch (RuntimeException e) {
            out = "";
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }

    @Override
    public long getIdByIt4article(String it4article) throws SQLException {
        Session session = null;
        List<It4articles> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        long out = 0L;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from It4articles a where it4article = :it4article")//
                    .setString("it4article", it4article);
            result = getByLogin.list();
            out = result.get(0).getId();
        } catch (Exception e) {
            System.out.println(e);
            out = 5L;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }

    @Override
    public boolean isIt4articlePresent(String it4article) throws SQLException {
        Session session = null;
        List<It4articles> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        boolean out = false;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from It4articles a where it4article = :it4article")//
                    .setString("it4article", it4article);
            result = getByLogin.list();
            out = result.isEmpty() ? false : true;
        } catch (RuntimeException e) {
            out = false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }

    @Override
    public void fillIt4articles(String fileName) throws SQLException {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createSQLQuery(
                    "load data local infile '" + fileName + "' "
                    + "into table it4articles "
                    + "fields terminated by ';' "
                    + "lines terminated by '\r\n' "
                    + "(it4article, description)");
            getByLogin.executeUpdate();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}

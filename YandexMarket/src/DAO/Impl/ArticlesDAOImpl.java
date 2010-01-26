/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.ArticlesDAO;
import Pojo.Articles;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author Admin4DB2
 */
public class ArticlesDAOImpl implements ArticlesDAO {

    public void addArticles(Articles articles) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(articles);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Collection getAllArticles() throws SQLException {
        Session session = null;
        List<Articles> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getArticles =
                    session.createQuery(
                    "from Articles a");
            //getArticles.setMaxResults(5);
            //getArticles.setFirstResult(189);
            result = getArticles.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public String getArticleById(long id) throws SQLException {
        Session session = null;
        List<Articles> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String out = "";
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Articles a where id = :art_id")//
                    .setLong("art_id", id);
            result = getByLogin.list();
            out = result.get(0).getArticle();
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
    public long getIdByArticle(String article) throws SQLException {
        Session session = null;
        List<Articles> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        long out = 0L;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Articles a where article = :art")//
                    .setString("art", article);
            result = getByLogin.list();
            out = result.get(0).getId();
        } catch (Exception e) {
            out = 0L;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }

    public boolean isArticlePresent(String article) throws SQLException {
        Session session = null;
        List<Articles> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        boolean out = false;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Articles a where article = :art")//
                    .setString("art", article);
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
    public void fillArticles(String fileName) throws SQLException {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createSQLQuery(
                    "load data local infile '" + fileName + "' " + "into table articles " + "fields terminated by ',' " + "lines terminated by '\r\n' " + "(article, description)");
            getByLogin.executeUpdate();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public String getDescriptionByArticle(String article) throws SQLException {
        Session session = null;
        List<Articles> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String out = "";
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Articles a where article = :art")//
                    .setString("art", article);
            result = getByLogin.list();
            out = result.get(0).getDescription();
        } catch (RuntimeException e) {
            out = "";
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }
}

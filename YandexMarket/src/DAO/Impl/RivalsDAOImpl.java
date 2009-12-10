/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.RivalsDAO;
import Pojo.Rivals;
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
public class RivalsDAOImpl implements RivalsDAO {

    public void addRivals(Rivals rivals) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(rivals);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Collection getAllRivals() throws SQLException {
        Session session = null;
        List<Rivals> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getArticles =
                    session.createQuery(
                    "from Rivals");
            result = getArticles.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public String getRivalsById(long id) throws SQLException {
        Session session = null;
        List<Rivals> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String out = "";
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Rivals r where id = :art_id")//
                    .setLong("art_id", id);
            result = getByLogin.list();
            out = result.get(0).getName();
        } catch (RuntimeException e) {
            out = "";
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }

    public long getIdByRivals(String rival) throws SQLException {
        Session session = null;
        List<Rivals> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        long out = 0L;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Rivals r where name = :rname")//
                    .setString("rname", rival);
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

    public boolean isRivalsPresent(String rival) throws SQLException {
        Session session = null;
        List<Rivals> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        boolean out = false;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Rivals a where name = :rname")//
                    .setString("rname", rival);
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
}

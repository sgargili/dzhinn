/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.CookiesDAO;
import Pojo.Cookies;
import Util.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author APopov
 */
public class CookiesDAOImpl implements CookiesDAO {

    public void addCookies(Cookies cookies) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(cookies);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List getAllCookies() throws SQLException {
        Session session = null;
        List<Cookies> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Cookies");
            result = getByLogin.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public String getCookies(int id) throws SQLException {
        Session session = null;
        List<Cookies> result = new ArrayList();
        session = HibernateUtil.getSessionFactory().openSession();
        Cookies out = null;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Cookies c where id = :id").setInteger("id", id);
            result = getByLogin.list();
            out = result.get(0);
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out.getCookie();
    }

    public long getCookiesTime(int id) throws SQLException {
        Session session = null;
        List<Cookies> result = new ArrayList();
        session = HibernateUtil.getSessionFactory().openSession();
        Cookies out = null;
        long outLong = 0;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Cookies c where id = :id").setInteger("id", id);
            result = getByLogin.list();
            out = result.get(0);
            outLong = out.getTime();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return outLong;
    }
}

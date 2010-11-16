/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.UsersDAO;
import pojo.Users;
import util.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author APopov
 */
public class UsersDAOImpl implements UsersDAO {

    @Override
    public void addUser(Users users) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(users);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public List getAllUsers() throws SQLException {
        Session session = null;
        List<Users> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Users");
            result = getByLogin.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public Users getUserById(long id) throws SQLException {
        Session session = null;
        List<Users> result = new ArrayList();
        session = HibernateUtil.getSessionFactory().openSession();
        Users out = null;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Users u where id = :id")//
                    .setLong("id", id);
            result = getByLogin.list();
            out = result.get(0);
        } catch (RuntimeException e) {
        } catch (Exception ex) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }

    @Override
    public Users getUserByIp(String ip) throws SQLException {
        Session session = null;
        List<Users> result = new ArrayList();
        session = HibernateUtil.getSessionFactory().openSession();
        Users out = null;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Users u where ip = :ip")//
                    .setString("ip", ip);
            result = getByLogin.list();
            out = result.get(0);
        } catch (RuntimeException e) {
        } catch (Exception ex) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }

    @Override
    public boolean isUserPresentByIp(String ip) throws SQLException {
        boolean out = false;
        Session session = null;
        List<Users> result = new ArrayList();
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Users u where ip = :ip")//
                    .setString("ip", ip);
            result = getByLogin.list();
            out = result.isEmpty();
        } catch (RuntimeException e) {
        } catch (Exception ex) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return !out;
    }
}

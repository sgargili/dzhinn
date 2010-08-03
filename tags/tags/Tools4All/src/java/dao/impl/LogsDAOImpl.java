/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.LogsDAO;
import pojo.Logs;
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
public class LogsDAOImpl implements LogsDAO {

    public void addLogs(Logs logs) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(logs);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List getAllLogs() throws SQLException {
        Session session = null;
        List<Logs> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Logs");
            result = getByLogin.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public List getLogsByType(String logType) throws SQLException {
        Session session = null;
        List<Logs> result = new ArrayList();
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Logs c where log_type = :type")//
                    .setString("type", logType);
            result = getByLogin.list();

        } catch (RuntimeException e) {
        } catch (Exception ex) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.ChatLogsDAO;
import util.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.ChatLogs;

/**
 *
 * @author APopov
 */
public class ChatLogsDAOImpl implements ChatLogsDAO {

    public void addChatLogs(ChatLogs chatLogs) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(chatLogs);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List getAllChatLogs() throws SQLException {
        Session session = null;
        List<ChatLogs> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from ChatLogs");
            result = getByLogin.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public String getChatLogs(long id) throws SQLException {
        Session session = null;
        List<ChatLogs> result = new ArrayList();
        session = HibernateUtil.getSessionFactory().openSession();
        ChatLogs out = null;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from ChatLogs c where id = :id")//
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
        return out.getNick() + ": " + out.getMessage();
    }
}

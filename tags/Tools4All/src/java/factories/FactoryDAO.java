/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import dao.ChatLogsDAO;
import dao.CookiesDAO;
import dao.LogsDAO;
import dao.UsersDAO;
import dao.ValueLanguageDAO;
import dao.ValueUserDAO;
import dao.impl.ChatLogsDAOImpl;
import dao.impl.CookiesDAOImpl;
import dao.impl.LogsDAOImpl;
import dao.impl.UsersDAOImpl;
import dao.impl.ValueLanguageDAOImpl;
import dao.impl.ValueUserDAOImpl;

/**
 *
 * @author APopov
 */
public class FactoryDAO {

    private CookiesDAO cookiesDAO = null;
    private ChatLogsDAO chatLogsDAO = null;
    private LogsDAO logsDAO = null;
    private UsersDAO usersDAO = null;
    private ValueUserDAO valueUserDAO = null;
    private ValueLanguageDAO valueLanguageDAO = null;
    private static FactoryDAO instance = null;

    public CookiesDAO getCookiesDAO() {
        if (cookiesDAO == null) {
            cookiesDAO = new CookiesDAOImpl();
        }
        return cookiesDAO;
    }

    public ValueUserDAO getValueUserDAO() {
        if (valueUserDAO == null) {
            valueUserDAO = new ValueUserDAOImpl();
        }
        return valueUserDAO;
    }

    public ValueLanguageDAO getValueLanguageDAO() {
        if (valueLanguageDAO == null) {
            valueLanguageDAO = new ValueLanguageDAOImpl();
        }
        return valueLanguageDAO;
    }

    public ChatLogsDAO getChatLogsDAO() {
        if (chatLogsDAO == null) {
            chatLogsDAO = new ChatLogsDAOImpl();
        }
        return chatLogsDAO;
    }

    public LogsDAO getLogsDAO() {
        if (logsDAO == null) {
            logsDAO = new LogsDAOImpl();
        }
        return logsDAO;
    }

    public UsersDAO getUsersDAO() {
        if (usersDAO == null) {
            usersDAO = new UsersDAOImpl();
        }
        return usersDAO;
    }

    public static synchronized FactoryDAO getInstance() {
        if (instance == null) {
            instance = new FactoryDAO();
        }
        return instance;
    }
}

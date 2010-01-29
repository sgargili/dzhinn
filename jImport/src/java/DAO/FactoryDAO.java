/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Impl.ChatLogsDAOImpl;
import DAO.Impl.CookiesDAOImpl;
import DAO.Impl.LogsDAOImpl;

/**
 *
 * @author APopov
 */
public class FactoryDAO {

    private CookiesDAO cookiesDAO = null;
    private ChatLogsDAO chatLogsDAO = null;
    private LogsDAO logsDAO = null;
    private static FactoryDAO instance = null;

    public CookiesDAO getCookiesDAO() {
        if (cookiesDAO == null) {
            cookiesDAO = new CookiesDAOImpl();
        }
        return cookiesDAO;
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

    public static synchronized FactoryDAO getInstance() {
        if (instance == null) {
            instance = new FactoryDAO();
        }
        return instance;
    }
}

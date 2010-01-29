/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.List;
import Pojo.ChatLogs;

/**
 *
 * @author APopov
 */
public interface ChatLogsDAO {

    public void addChatLogs(ChatLogs chatLogs) throws SQLException;

    public List getAllChatLogs() throws SQLException;

    public String getChatLogs(long id) throws SQLException;
}

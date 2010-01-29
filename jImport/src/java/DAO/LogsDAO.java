/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Logs;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author APopov
 */
public interface LogsDAO {

    public void addLogs(Logs logs) throws SQLException;

    public List getAllLogs() throws SQLException;

    public List getLogsByType(String logType) throws SQLException;
}

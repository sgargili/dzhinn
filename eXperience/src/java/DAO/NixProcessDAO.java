/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Processes;
import java.sql.SQLException;

/**
 *
 * @author APopov
 */
public interface NixProcessDAO {

    public void updateNixProcess(Processes processes) throws SQLException;

    public boolean getNixProcessById(Long Id) throws SQLException;

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Rivals;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author Admin4DB2
 */
public interface RivalsDAO {

    public void addRivals(Rivals rivals) throws SQLException;

    public Collection getAllRivals() throws SQLException;

    public String getRivalsById(long id) throws SQLException;

    public long getIdByRivals(String rival) throws SQLException;

    public boolean isRivalsPresent(String rival) throws SQLException;
}

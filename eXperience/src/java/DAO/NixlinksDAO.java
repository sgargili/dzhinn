/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Nixlinks;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Admin4DB2
 */
public interface NixlinksDAO {

    public void addNixlink(Nixlinks nixlinks) throws SQLException;

    public List getAllNixlink(int firstresult, int maxresult) throws SQLException;

    public Long getAllNixlinkCount() throws SQLException;
}

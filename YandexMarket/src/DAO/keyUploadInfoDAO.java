/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.KeyUploadInfo;
import java.util.Collection;
import java.sql.SQLException;

/**
 *
 * @author ilyahoo
 */
public interface keyUploadInfoDAO {

    public void addKeys(KeyUploadInfo keyUI) throws SQLException;

    public Collection getAllKeys() throws SQLException;
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.KeyFromXml;
import java.util.Collection;
import java.sql.SQLException;

/**
 *
 * @author ilyahoo
 */
public interface KeyFromXmlDAO {

    public void addKeys(KeyFromXml keyfromxml)throws SQLException;

    public Collection getAllKeys()throws SQLException;
}

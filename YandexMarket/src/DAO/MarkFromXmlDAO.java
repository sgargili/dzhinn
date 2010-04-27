/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.MarkFromXml;
import java.util.Collection;
import java.sql.SQLException;

/**
 *
 * @author ilyahoo
 */
public interface MarkFromXmlDAO {

    public void addKeys(MarkFromXml markfromxml) throws SQLException;

    public Collection getAllKeys() throws SQLException;
}

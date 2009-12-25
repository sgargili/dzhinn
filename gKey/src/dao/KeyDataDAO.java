/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import pojo.Keydata;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author APopov
 */
public interface KeyDataDAO {

    public void addKeydata(Keydata keydata) throws SQLException;

    public List getAllKeydata(int firstResult, int maxResult) throws SQLException;

    public List getAllKeydata() throws SQLException;
}

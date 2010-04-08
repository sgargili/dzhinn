/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import pojo.Cookies;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author APopov
 */
public interface CookiesDAO {

    public void addCookies(Cookies cookies) throws SQLException;

    public List getAllCookies() throws SQLException;

    public String getCookies(int id) throws SQLException;

    public long getCookiesTime(int id) throws SQLException;
}

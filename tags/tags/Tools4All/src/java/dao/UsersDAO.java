/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import pojo.Users;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author APopov
 */
public interface UsersDAO {

    public void addUser(Users users) throws SQLException;

    public List getAllUsers() throws SQLException;

    public Users getUserById(long id) throws SQLException;

    public Users getUserByIp(String ip) throws SQLException;

    public boolean isUserPresentByIp(String ip) throws SQLException;
}

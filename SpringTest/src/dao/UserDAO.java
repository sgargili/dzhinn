/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojo.User;

/**
 *
 * @author APopov
 */
public interface UserDAO {

    public List<User> getAllUsers();

    public User getUserById(int id);

    public void addUser(User user);

    public void deleteUser(User user);
}

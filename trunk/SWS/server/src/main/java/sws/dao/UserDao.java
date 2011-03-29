package sws.dao;

import java.util.List;

import sws.model.User;

/**
 * Developed by: Andrey Popov
 * Date (time): 23.03.11 (13:11)
 */

public interface UserDao {
    User saveUser(User user);

    void batchSaveUser(List<User> users);

    void updateUser(User user);

    void deleteUser(User user);

    User getUserByLogin(String login);

    List<User> getAllUsers();

    List<User> getUsersByName(String name);

}

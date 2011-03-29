package sws.service;

import java.util.List;

import sws.dto.UserDto;
import sws.model.User;

/**
 * Developed by: Andrey Popov
 * Date (time): 23.03.11 (17:05)
 */

public interface UserService {
    UserDto getUserDtoByName(String name);

    void batchSaveUsers(List<User> users);
}

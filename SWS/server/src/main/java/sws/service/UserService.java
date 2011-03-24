package sws.service;

import sws.dto.UserDto;

/**
 * Developed by: Andrey Popov
 * Date (time): 23.03.11 (17:05)
 */

public interface UserService {
    UserDto getUserDtoByName(String name);
}

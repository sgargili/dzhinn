package sws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sws.dao.UserDao;
import sws.dto.UserDto;
import sws.model.User;
import sws.service.UserService;

/**
 * Developed by: Andrey Popov
 * Date (time): 23.03.11 (17:06)
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    private UserDto convertUserListToUserDto(List<User> users) {
        UserDto dto = new UserDto();
        for (User user : users) {
            dto.addObject(user);
        }
        return dto;
    }

    @Override
    @Transactional
    public UserDto getUserDtoByName(String name) {
        return convertUserListToUserDto(userDao.getUsersByName(name));
    }
}

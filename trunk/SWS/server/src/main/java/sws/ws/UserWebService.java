package sws.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.w3c.dom.Element;

import sws.dao.UserDao;
import sws.dto.UserDto;
import sws.model.User;
import sws.service.UserService;

/**
 * Developed by: Andrey Popov
 * Date (time): 23.03.11 (13:29)
 */
@Endpoint
public class UserWebService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;

    @PayloadRoot(localPart = "userRequest", namespace = "user")
    @ResponsePayload
    public User getUser(User user) {
        return userDao.getUserByLogin(user.getLogin());
    }

    @PayloadRoot(localPart = "usersByNameRequest", namespace = "user")
    @ResponsePayload
    public UserDto getUsersByName(@RequestPayload Element requestElement) {
        System.out.println(requestElement.getNamespaceURI());
        return userService.getUserDtoByName(requestElement.getFirstChild().getNodeValue());
    }
}

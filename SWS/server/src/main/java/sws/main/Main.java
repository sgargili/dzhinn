package sws.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sws.dao.UserDao;
import sws.model.User;

/**
 * Developed by: Andrey Popov
 * Date (time): 23.03.11 (11:09)
 */

public class Main {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-ws-context.xml");
    private static UserDao userDao = (UserDao) context.getBean("userDao");

    public static void main(String[] args) {
    List<User> users = new ArrayList<User>();
//        System.out.println(userDao.getAllUsers().size());
        User user;
        for (int i = 3; i < 10000; i++) {
            user = new User();
            user.setLogin("Login " + i);
            user.setName("Name " + i);
            user.setPassword("Name " + i);
            user.setSurname("Surname " + i);
            users.add(user);
        }
        userDao.batchSaveUser(users);
    }
}

package sws.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sws.dao.UserDao;

/**
 * Developed by: Andrey Popov
 * Date (time): 23.03.11 (11:09)
 */

public class Main {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-ws-context.xml");
    private static UserDao userDao = (UserDao) context.getBean("userDao");
    public static void main(String[] args) {

        System.out.println(userDao.getAllUsers().size());

    }
}

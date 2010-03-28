/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author APopov
 */
public class FactoryDAO {

    private UserDAO userDAO = null;
    private static FactoryDAO instance = null;
    private ApplicationContext factory = new ClassPathXmlApplicationContext("test.xml");

    public static synchronized FactoryDAO getInstance() {
        if (instance == null) {
            instance = new FactoryDAO();
        }
        return instance;
    }

    public UserDAO getUserDAO() {
        return (UserDAO) factory.getBean("userDAO");
    }
}

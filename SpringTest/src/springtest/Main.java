/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package springtest;

import dao.FactoryDAO;
import java.util.Iterator;
import java.util.List;
import pojo.User;

/**
 *
 * @author APopov
 */
public class Main {

    public static void main(String[] args) {

//        List lst = FactoryDAO.getInstance().getUserDAO().getAllUsers();
        User usr = FactoryDAO.getInstance().getUserDAO().getUserById(2);
//        for (Iterator it = lst.iterator(); it.hasNext();) {
//            usr = (User) it.next();
        System.out.println(usr.getId() + " " + usr.getName());
//        }
        User user = new User("Андрей!!!");
        user.setId(6);
        FactoryDAO.getInstance().getUserDAO().addUser(user);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import pojo.User;

/**
 *
 * @author APopov
 */
public class UserDAOImpl implements UserDAO {

    private HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sf) {
        this.hibernateTemplate = new HibernateTemplate(sf);
    }

    public List<User> getAllUsers() {
        return hibernateTemplate.loadAll(User.class);
    }

    public User getUserById(int id) {
        return (User) hibernateTemplate.load(User.class, id);
    }

    public void addUser(User user) {
        hibernateTemplate.saveOrUpdate(user);
    }

    public void deleteUser(User user) {
        hibernateTemplate.delete(user);
    }
}

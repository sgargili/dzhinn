package sws.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sws.dao.UserDao;
import sws.model.User;

/**
 * Developed by: Andrey Popov
 * Date (time): 23.03.11 (13:18)
 */
@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    HibernateTemplate hibernateTemplate;

    @Override
    public User saveUser(User user) {
        user.setId((Long) hibernateTemplate.save(user));
        return user;
    }

    @Override
    public void updateUser(User user) {
        hibernateTemplate.update(user);
    }

    @Override
    public void deleteUser(User user) {
        hibernateTemplate.delete(user);
    }

    @Override
    @Transactional
    public User getUserByLogin(String login) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("login", login));
        return (User) criteria.uniqueResult();
    }

    @Override
    public List<User> getAllUsers() {
        return hibernateTemplate.loadAll(User.class);
    }

    @Override
    public List<User> getUsersByName(String name) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.like("name", "%" + name + "%"));
        return criteria.list();
    }
}

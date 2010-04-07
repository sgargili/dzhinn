/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.ValueUserDAO;
import Pojo.ValueUser;
import Util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author APopov
 */
public class ValueUserDAOImpl implements ValueUserDAO {

    @Override
    public List getAllValueUsers() {
        Session session = null;
        List<ValueUser> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from ValueUser v order by v.name");
            result = getByLogin.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public ValueUser getValueUserById(long id) {
        Session session = null;
        List<ValueUser> result = new ArrayList();
        session = HibernateUtil.getSessionFactory().openSession();
        ValueUser out = null;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from ValueUser v where v.id = :id")//
                    .setLong("id", id);
            result = getByLogin.list();
            out = result.get(0);
        } catch (RuntimeException e) {
        } catch (Exception ex) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }
}

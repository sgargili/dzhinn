/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.CategoriesDAO;
import Pojo.Categories;
import Pojo.oldCat;
import Util.HibernateUtil;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author APopov
 */
public class CategoriesDAOImpl implements CategoriesDAO {

    public void addCategories(Categories categories) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(categories);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Collection getAllCategories() throws SQLException {
        Session session = null;
        List<Categories> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Categories");
            result = getByLogin.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public Collection getAllCategoriesNew() throws SQLException {
        Session session = null;
        List result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "select cd.categories_name, cat.categories_image" +
                    "from categories_description cd" +
                    "join categories cat on cd.categories_id = cat.categories_id");
            result = getByLogin.list();
            for (Iterator it = result.iterator(); it.hasNext();) {
                Object str = (Object) it.next();
                System.out.println(str.toString());
            }
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }
}

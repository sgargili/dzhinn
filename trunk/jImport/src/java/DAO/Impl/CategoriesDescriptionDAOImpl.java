/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.CategoriesDescriptionDAO;
import Pojo.CategoriesDescription;
import Util.HibernateUtil4Imports;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author APopov
 */
public class CategoriesDescriptionDAOImpl implements CategoriesDescriptionDAO {

    public void addCategoriesDescription(CategoriesDescription categoriesDescription) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil4Imports.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(categoriesDescription);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Collection getAllCategoriesDescription() throws SQLException {
        Session session = null;
        List<CategoriesDescription> result = null;
        session = HibernateUtil4Imports.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from CategoriesDescription");
            result = getByLogin.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public CategoriesDescription getAllCategoriesDescriptionById(int id) throws SQLException {
        Session session = null;
        CategoriesDescription result = null;
        try {
            session = HibernateUtil4Imports.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from CategoriesDescription c where categories_id = :cat_id").setInteger("cat_id", id);
            List resultList = query.list();
            result = (CategoriesDescription) resultList.get(0);
            session.getTransaction().commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.ProductsToCategoriesDAO;
import Pojo.ProductsToCategories;
import Util.HibernateUtil;
import java.sql.SQLException;
import org.hibernate.Session;

/**
 *
 * @author APopov
 */
public class ProductsToCategoriesDAOImpl implements ProductsToCategoriesDAO {

    public void addProductsToCategories(ProductsToCategories productsToCategories) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(productsToCategories);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}

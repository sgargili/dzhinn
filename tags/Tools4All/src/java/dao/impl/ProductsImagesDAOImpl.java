/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.ProductsImagesDAO;
import pojo.ProductsImages;
import util.HibernateUtil4Imports;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author APopov
 */
public class ProductsImagesDAOImpl implements ProductsImagesDAO {

    public void addProductsImages(ProductsImages productsImages) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil4Imports.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(productsImages);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Collection getAllProductsImages() throws SQLException {
        Session session = null;
        List<ProductsImages> result = null;
        session = HibernateUtil4Imports.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from ProductsImages");
            result = getByLogin.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public ProductsImages getProductsImagesById(int id) throws SQLException {
        Session session = null;
        List<ProductsImages> result = new ArrayList();
        session = HibernateUtil4Imports.getSessionFactory().openSession();
        ProductsImages out = null;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from ProductsImages p where pid = :id").setInteger("id", id);
            result = getByLogin.list();
            out = result.get(0);
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }

    public void deleteProductsImages(ProductsImages productsImages) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil4Imports.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(productsImages);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}

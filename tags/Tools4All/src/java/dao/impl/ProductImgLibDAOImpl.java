/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.ProductImgLibDAO;
import pojo.ProductImgLib;
import util.HibernateUtil4Imports;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author root
 */
public class ProductImgLibDAOImpl implements ProductImgLibDAO {

    public void addProductImgLib(ProductImgLib productImgLib) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil4Imports.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(productImgLib);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void deleteProductImgLib(ProductImgLib productImgLib) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil4Imports.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(productImgLib);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Collection getAllProductImgLib() throws SQLException {
        Session session = null;
        List<ProductImgLib> result = null;
        session = HibernateUtil4Imports.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from ProductImgLib");
            result = getByLogin.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public Collection getProductImgLibById(Long id) throws SQLException {
        Session session = null;
        List<ProductImgLib> result = new ArrayList();
        session = HibernateUtil4Imports.getSessionFactory().openSession();
        // ProductImgLib out = null;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from ProductImgLib p where pid = :id").setLong("id", id);
            result = getByLogin.list();
            // out = result.get(0);
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }
}

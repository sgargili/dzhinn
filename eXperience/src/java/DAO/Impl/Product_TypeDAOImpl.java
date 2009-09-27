/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.Product_TypeDAO;
import Pojo.ProductType;
import Util.HibernateUtil;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin4DB2
 */
public class Product_TypeDAOImpl implements Product_TypeDAO {

    @Override
    public void addProduct_Type(ProductType productType) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(productType);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateProduct_Type(ProductType productType) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(productType);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public ProductType getProduct_TypeById(Long ProductTypeId) throws SQLException {
        Session session = null;
        ProductType result = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from ProductType p where ProductType_Id_Id = :ProductTypeId").setLong("ProductTypeId", ProductTypeId);
            List resultList = query.list();
            result = (ProductType) resultList.get(0);
            session.getTransaction().commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public Collection getAllProduct_Types() throws SQLException {
        Session session = null;
        List<ProductType> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from ProductType p");
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
    public void deleteProduct_Type(ProductType productType) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(productType);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public boolean isProduct_Type_IdPresent(Long ProductTypeId) throws SQLException {
        Session session = null;
        List result = null;
        boolean out = false;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin;
            getByLogin = session.createQuery("from ProductType p where Product_Type_Id = :ProductTypeId");
            getByLogin.setLong("ProductTypeId", ProductTypeId);
            result = getByLogin.list();
            if (result.isEmpty()) {
                out = false;
            } else {
                out = true;
            }
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }

    @Override
    public Long getIdByProduct_Type_Id(Long ProductTypeId) throws SQLException {
        Session session = null;
        ProductType result = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from ProductType p where Product_Type_Id = :ProductTypeId").setLong("ProductTypeId", ProductTypeId);
            List resultList = query.list();
            result = (ProductType) resultList.get(0);
            session.getTransaction().commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result.getId();
    }
}

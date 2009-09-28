/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

/**
 *
 * @author APopov
 */
import DAO.SupplierDAO;
import Pojo.Supplier;
import Pojo.Supplierprice;
import Util.HibernatePriceConUtil;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin4DB2
 */
public class SupplierDAOImpl implements SupplierDAO {

    @Override
    public void addSupplier(Supplier supplier) throws SQLException {
        Session session = null;
        try {
            session = HibernatePriceConUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(supplier);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateSupplier(Supplier supplier) throws SQLException {
        Session session = null;
        try {
            session = HibernatePriceConUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(supplier);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public String getSupplierById(Long Supplier_Id) throws SQLException {
        Session session = null;
        Supplier result = null;
        String out = null;
        try {
            session = HibernatePriceConUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from Supplier s where Supplier_Id = :SupplierId ").setLong("SupplierId", Supplier_Id);
            List resultList = query.list();
            result = (Supplier) resultList.get(0);
            out = result.getSupplierName();
            session.getTransaction().commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }

    @Override
    public Collection getAllSuppliers() throws SQLException {
        Session session = null;
        List<Supplier> result = null;
        session = HibernatePriceConUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Supplier");
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
    public void deleteSupplier(Supplier supplier) throws SQLException {
        Session session = null;
        try {
            session = HibernatePriceConUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(supplier);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Long getIdBySupplier(String Supplier_Name) throws SQLException {
        Session session = null;
        Supplier result = null;
        Long out = null;
        try {
            session = HibernatePriceConUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from Supplier s where Supplier_Name = :SupplierName ").setString("SupplierName", Supplier_Name);
            List resultList = query.list();
            if (!resultList.isEmpty()) {
                result = (Supplier) resultList.get(0);
                out = result.getSupplierId();
            }
            session.getTransaction().commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }

    @Override
    public Long getSupplierIdByArticle(String Article) throws SQLException {
        Session session = null;
        Supplierprice result = null;
        try {
            session = HibernatePriceConUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from Supplierprice s where Supplier_Article_Name = :SupplierArticleName ").setString("SupplierArticleName", Article);
            List resultList = query.list();
            result = (Supplierprice) resultList.get(0);
            session.getTransaction().commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result.getSupplierId();
    }
}

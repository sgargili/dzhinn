/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.PcSyncProductsDAO;
import Pojo.PcSyncProducts;
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
public class PcSyncProductsDAOImpl implements PcSyncProductsDAO {

    public void addPcSyncProducts(PcSyncProducts pcSyncProducts) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil4Imports.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(pcSyncProducts);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updatePcSyncProducts(PcSyncProducts pcSyncProducts) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isPcSyncProductspresent(String ProductModel) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public PcSyncProducts getPcSyncProductsById(int Currency_Id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Collection getAllPcSyncProducts() throws SQLException {
        Session session = null;
        List<PcSyncProducts> result = null;
        session = HibernateUtil4Imports.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from PcSyncProducts");
            result = getByLogin.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public void deletePcSyncProducts(PcSyncProducts pcSyncProducts) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getPcSyncProductsByModel(String model) throws SQLException {
        Session session = null;
        List<PcSyncProducts> result = null;
        session = HibernateUtil4Imports.getSessionFactory().openSession();
        int out = 0;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from PcSyncProducts p where products_model = :model").setString("model", model);
            result = getByLogin.list();
            out = result.get(0).getProductsId();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }
}

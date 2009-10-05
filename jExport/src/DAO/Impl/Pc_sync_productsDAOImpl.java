/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.Pc_sync_productsDAO;
import Pojo.PcSyncProducts;
import Util.HibernateUtil;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author APopov
 */
public class Pc_sync_productsDAOImpl implements Pc_sync_productsDAO {

    public void addPcSyncProducts(PcSyncProducts pcSyncProducts) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(pcSyncProducts);
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
        session = HibernateUtil.getSessionFactory().openSession();
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
}

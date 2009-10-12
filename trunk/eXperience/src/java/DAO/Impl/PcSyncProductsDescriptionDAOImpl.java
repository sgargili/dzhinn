/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.PcSyncProductsDescriptionDAO;
import Pojo.PcSyncProductsDescription;
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
public class PcSyncProductsDescriptionDAOImpl implements PcSyncProductsDescriptionDAO {

    public void addPcSyncProductsDescription(PcSyncProductsDescription pcSyncProductsDescription) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(pcSyncProductsDescription);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Collection getPcSyncProductsDescription() throws SQLException {
        Session session = null;
        List<PcSyncProductsDescription> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from PcSyncProductsDescription");
            result = getByLogin.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }
}

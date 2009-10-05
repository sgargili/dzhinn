/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.PcSyncProductsDescriptionDAO;
import Pojo.PcSyncProductsDescription;
import Util.HibernateUtil;
import java.sql.SQLException;
import org.hibernate.Session;

/**
 *
 * @author APopov
 */
public class PcSyncProductsDescriptionImpl implements PcSyncProductsDescriptionDAO {

    public void addPcSyncProductsDescription(PcSyncProductsDescription pcSyncProductsDescription) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(pcSyncProductsDescription);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}

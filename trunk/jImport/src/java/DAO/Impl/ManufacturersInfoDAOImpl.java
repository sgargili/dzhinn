/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.ManufacturersInfoDAO;
import Pojo.ManufacturersInfo;
import Util.HibernateUtil4Imports;
import java.sql.SQLException;
import org.hibernate.Session;

/**
 *
 * @author APopov
 */
public class ManufacturersInfoDAOImpl implements ManufacturersInfoDAO {

    public void addManufacturersInfo(ManufacturersInfo manufacturersInfo) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil4Imports.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(manufacturersInfo);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.ManufacturersDAO;
import Pojo.Manufacturers;
import Util.HibernateUtil4Imports;
import java.sql.SQLException;
import org.hibernate.Session;

/**
 *
 * @author APopov
 */
public class ManufacturersDAOImpl implements ManufacturersDAO {

    public void addManufacturers(Manufacturers manufacturers) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil4Imports.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(manufacturers);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.NixlinksDAO;
import Pojo.Nixlinks;
import hUtil.HibernateUtil;
import java.sql.SQLException;
import org.hibernate.Session;

/**
 *
 * @author Admin4DB2
 */
public class NixlinksDAOImpl implements NixlinksDAO {

    public void addNixlink(Nixlinks nixlinks) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(nixlinks);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void addCurrency(Nixlinks nixlinks) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

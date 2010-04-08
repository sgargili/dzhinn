/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.PcProductsAvailableDAO;
import pojo.PcProductsAvailable;
import util.HibernateUtil4Imports;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author APopov
 */
public class PcProductsAvailableDAOImpl implements PcProductsAvailableDAO {

    public List<PcProductsAvailable> getPcProductsAvailable() throws SQLException {
        Session session = null;
        List<PcProductsAvailable> result = null;
        session = HibernateUtil4Imports.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from PcProductsAvailable");
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

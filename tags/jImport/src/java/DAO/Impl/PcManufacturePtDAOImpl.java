/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.PcManufacturePtDAO;
import Pojo.PcManufacturePt;
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
public class PcManufacturePtDAOImpl implements PcManufacturePtDAO {

    public void addPcManufacturePt(PcManufacturePt pcManufacturePt) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil4Imports.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(pcManufacturePt);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Collection getAllPcManufacturePt() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isPcManufacturePtPresent(int manId, int PtId) throws SQLException {
        boolean bool = false;
        Session session = null;
        List<PcManufacturePt> result = null;
        session = HibernateUtil4Imports.getSessionFactory().openSession();
        int out = 1;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from PcManufacturePt p where id_manufacture = :man and product_type = :pt")//
                    .setInteger("man", manId)//
                    .setInteger("pt", PtId);//
            result = getByLogin.list();
            if (!result.isEmpty()) {
                bool = true;
            }
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return bool;
    }
}

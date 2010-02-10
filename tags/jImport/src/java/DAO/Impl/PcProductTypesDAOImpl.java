/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.PcProductTypesDAO;
import Pojo.PcProductTypes;
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
public class PcProductTypesDAOImpl implements PcProductTypesDAO {

    public Collection getAllPcProductTypes() throws SQLException {
        Session session = null;
        List<PcProductTypes> result = null;
        session = HibernateUtil4Imports.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from PcProductTypes");
            result = getByLogin.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public void addPcProductsToPt(PcProductTypes pcProductTypes) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil4Imports.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(pcProductTypes);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public int getPcProductTypesByName(String name) throws SQLException {
        Session session = null;
        List<PcProductTypes> result = null;
        session = HibernateUtil4Imports.getSessionFactory().openSession();
        int out = 1;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from PcProductTypes p where pt_name = :name").setString("name", name);
            result = getByLogin.list();
            out = result.get(0).getPtId();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }
}

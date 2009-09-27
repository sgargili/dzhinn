/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.ManufacturerDAO;
import Pojo.Manufacturer;
import Util.HibernateUtil;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin4DB2
 */
public class ManufacturerDAOImpl implements ManufacturerDAO {

    public void addManufacturer(Manufacturer manufacturer) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(manufacturer);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateManufacturer(Manufacturer manufacturer) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(manufacturer);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Manufacturer getManufacturerById(Long Manufacturer_Id) throws SQLException {
        Session session = null;
        Manufacturer result = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from Manufacturer m where Manufacturer_Id = :ManufacturerId ").setLong("ManufacturerId", Manufacturer_Id);
            List resultList = query.list();
            result = (Manufacturer) resultList.get(0);
            session.getTransaction().commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public Collection getAllManufacturers() throws SQLException {
        Session session = null;
        List<Manufacturer> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Manufacturer m");
            result = getByLogin.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;

    }

    public void deleteManufacturer(Manufacturer manufacturer) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(manufacturer);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public boolean isManufacturerPresent(String ManufacturerName) throws SQLException {

        Session session = null;
        List result = null;
        boolean out = false;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin;
            getByLogin = session.createQuery("from Manufacturer m where Manufacturer_Name = :ManufacturerName");
            getByLogin.setString("ManufacturerName", ManufacturerName);
            result = getByLogin.list();
            if (result.isEmpty()) {
                out = false;
            } else {
                out = true;
            }
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }
}

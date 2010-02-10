/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.PcSyncIdsDAO;
import Pojo.PcSyncIds;
import Util.HibernateUtil4Imports;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author root
 */
public class PcSyncIdsDAOImpl implements PcSyncIdsDAO {

    public void addPcSyncIds(PcSyncIds pcSyncIds) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil4Imports.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(pcSyncIds);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public PcSyncIds getPcSyncIdsByIt4Pid(long it4Pid) throws SQLException {
        Session session = null;
        List<PcSyncIds> result = null;
        session = HibernateUtil4Imports.getSessionFactory().openSession();
        PcSyncIds out = null;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from PcSyncIds p where it4pid = :it4Pid").setLong("it4Pid", it4Pid);
            result = getByLogin.list();
            out = result.get(0);
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }

    public Collection getAllPcSyncIds() throws SQLException {
        Session session = null;
        List<PcSyncIds> result = null;
        session = HibernateUtil4Imports.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from PcSyncIds");
            result = getByLogin.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public long getShopPidByIt4Pid(long it4Pid) throws SQLException {
        Session session = null;
        List<PcSyncIds> result = null;
        session = HibernateUtil4Imports.getSessionFactory().openSession();
        long out = 0;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from PcSyncIds p where it4pid = :it4Pid").setLong("it4Pid", it4Pid);
            result = getByLogin.list();
            out = result.get(0).getShoppid();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }

    public long getIt4PidByShopPid(long shopPid) throws SQLException {
        Session session = null;
        List<PcSyncIds> result = null;
        session = HibernateUtil4Imports.getSessionFactory().openSession();
        long out = 0;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from PcSyncIds p where shoppid = :shopPid").setLong("shopPid", shopPid);
            result = getByLogin.list();
            out = result.get(0).getIt4pid();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }
}

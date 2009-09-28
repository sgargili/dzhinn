/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.NixProcessDAO;
import Pojo.Processes;
import Util.HibernateNixUtil;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author APopov
 */
public class NixProcessDAOImpl implements NixProcessDAO {

    @Override
    public void updateNixProcess(Processes processes) throws SQLException {
        Session session = null;
        try {
            session = HibernateNixUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(processes);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public boolean getNixProcessById(Long Id) throws SQLException {
        Session session = null;
        Processes result = null;

        try {
            session = HibernateNixUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from Processes p where Id = :Id ").setLong("Id", Id);
            List resultList = query.list();
            result = (Processes) resultList.get(0);
            session.getTransaction().commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result.getProcessStatus();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.NixlinksDAO;
import Pojo.Nixlinks;
import Util.HibernateNixUtil;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin4DB2
 */
public class NixlinksDAOImpl implements NixlinksDAO {

    public void addNixlink(Nixlinks nixlinks) throws SQLException {
        Session session = null;
        try {
            session = HibernateNixUtil.getSessionFactory().openSession();
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

    public List getAllNixlink(int firstresult, int maxresult) throws SQLException {
        Session session = null;
        List<Nixlinks> result = null;
        session = HibernateNixUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Nixlinks n").setMaxResults(maxresult).setFirstResult(firstresult);
            result = getByLogin.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public Long getAllNixlinkCount() throws SQLException {
        Session session = null;
        Long count=0L;
        session = HibernateNixUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin = session.createQuery("select count(*)from Nixlinks");
            count = (Long)getByLogin.list().get(0);
//            for (Iterator it = getByLogin.iterate(); it.hasNext();) {
//                it.next();
//                count++;
//            }
        } catch (RuntimeException e) {
            System.out.println(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return count;
    }
}

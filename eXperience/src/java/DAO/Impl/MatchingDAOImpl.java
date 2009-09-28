/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.MatchingDAO;
import Pojo.Matching;
import Util.HibernatePriceConUtil;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author APopov
 */
public class MatchingDAOImpl implements MatchingDAO {

    @Override
    public void addMatching(Matching matching) throws SQLException {
        Session session = null;
        try {
            session = HibernatePriceConUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(matching);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateMatching(Matching matching) throws SQLException {
        Session session = null;
        try {
            session = HibernatePriceConUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(matching);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Matching getMatchingById(Long Supplier_Id) throws SQLException {
        Session session = null;
        Matching result = null;
        try {
            session = HibernatePriceConUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from Matching m where Supplier_Id = :SupplierId ").setLong("SupplierId", Supplier_Id);
            List resultList = query.list();
            result = (Matching) resultList.get(0);
            session.getTransaction().commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public Collection getAllMatching() throws SQLException {
        Session session = null;
        List<Matching> result = null;
        session = HibernatePriceConUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Matching s");
            result = getByLogin.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public void deleteMatching(Matching matching) throws SQLException {
        Session session = null;
        try {
            session = HibernatePriceConUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(matching);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public String getDescriptionBySupplierArticleName(String SupplierArticleName) throws SQLException {
        Session session = null;
        String result = null;
        Matching mtch = null;
        try {
            session = HibernatePriceConUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from Matching m where Supplier_Article_Name = :SupplierArticleName ").setString("SupplierArticleName", SupplierArticleName);
            List resultList = query.list();
            if (!resultList.isEmpty()) {
                mtch = (Matching) resultList.get(0);
                result = mtch.getSupplierArticleName();
            } else {
                mtch = null;
                result = "Нету описания...";

            }
            session.getTransaction().commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public boolean isMatchingPresent(String Article, Long SupplierId) throws SQLException {
        Session session = null;
        List result = null;
        boolean out = false;
        session = HibernatePriceConUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin;
            getByLogin = session.createQuery("from Matching m where Supplier_Article_Name = :SupplierArticleName and Supplier_Id = :SupplierId");
            getByLogin.setString("SupplierArticleName", Article);
            getByLogin.setLong("SupplierId", SupplierId);
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

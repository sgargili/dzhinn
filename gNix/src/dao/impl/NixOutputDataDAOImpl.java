/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.NixOutputDataDAO;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.NixOutputData;
import util.HibernateUtil;

/**
 *
 * @author APopov
 */
public class NixOutputDataDAOImpl implements NixOutputDataDAO {

    public void addNixOutputData(NixOutputData nixOutputData) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(nixOutputData);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void addNixOutputData(List nixOutputDataList) {
        Session session = null;
        try {
            for (Iterator it = nixOutputDataList.iterator(); it.hasNext();) {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.saveOrUpdate((NixOutputData) it.next());
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List getAllNixOutputData() {
        Session session = null;
        List<NixOutputData> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query AllNixOutputDataQuery =
                    session.createQuery(
                    "from NixOutputData n");

            result = AllNixOutputDataQuery.list();

        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public List getAllNixOutputData(int firstResult, int maxResult) {
        Session session = null;
        List<NixOutputData> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query AllNixOutputDataQuery =
                    session.createQuery(
                    "from NixOutputData n");
            AllNixOutputDataQuery.setFirstResult(firstResult);
            AllNixOutputDataQuery.setMaxResults(maxResult);

            result = AllNixOutputDataQuery.list();

        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public boolean isNixOutputDataArticlePresent(String article) {
        Session session = null;
        List<NixOutputData> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        boolean out = false;
        try {
            session.beginTransaction();
            Query NixOutputDataQuery =
                    session.createQuery(
                    "from NixOutputData n where article = :art");
            NixOutputDataQuery.setString("art", article);

            result = NixOutputDataQuery.list();

            out = !result.isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }

    public List getNixOutputDataByProductType(String productType) {
        Session session = null;
        List<NixOutputData> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query CriteriaNixOutputDataQuery =
                    session.createQuery(
                    "from NixOutputData n where productType = :pt");
            CriteriaNixOutputDataQuery.setString("pt", productType);

            result = CriteriaNixOutputDataQuery.list();

        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public List getNixOutputDataByArticle(String article) {
        Session session = null;
        List<NixOutputData> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query CriteriaNixOutputDataQuery =
                    session.createQuery(
                    "from NixOutputData n where article = :art");
            CriteriaNixOutputDataQuery.setString("art", article);

            result = CriteriaNixOutputDataQuery.list();

        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }
}

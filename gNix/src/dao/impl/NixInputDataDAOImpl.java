/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.NixInputDataDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.NixInputData;
import util.HibernateUtil;

/**
 *
 * @author APopov
 */
public class NixInputDataDAOImpl implements NixInputDataDAO {

    public void addNixInputData(NixInputData nixInputData) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(nixInputData);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List getAllNixInputData() {
        Session session = null;
        List<NixInputData> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getAllNixInputDataQuery =
                    session.createQuery(
                    "from NixInputData n");
            result = getAllNixInputDataQuery.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public List getNixInputDataByProductType(String productType) {
        Session session = null;
        List<NixInputData> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query CriteriaNixInputDataQuery =
                    session.createQuery(
                    "from NixInputData n where productType = :pt");
            CriteriaNixInputDataQuery.setString("pt", productType);

            result = CriteriaNixInputDataQuery.list();

        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public List getAllNixInputData(int firstResult, int maxResult) {
        Session session = null;
        List<NixInputData> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query AllNixOutputDataQuery =
                    session.createQuery(
                    "from NixInputData n");
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
}

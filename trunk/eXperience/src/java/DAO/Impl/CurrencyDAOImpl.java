/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.CurrencyDAO;
import Pojo.Currency;
import Util.HibernateUtil;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author APopov
 */
public class CurrencyDAOImpl implements CurrencyDAO {

    @Override
    public void addCurrency(Currency currency) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateCurrency(Currency currency) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isCurrencyPresent(String ManufacturerName) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Currency getCurrencyById(int Currency_Id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getCurrencyNameById(int Currency_Id) throws SQLException {
        Session session = null;
        Currency result = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from Currency c where Currency_Id = :CurrencyId").setInteger("CurrencyId", Currency_Id);
            List resultList = query.list();
            result = (Currency) resultList.get(0);
            session.getTransaction().commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result.getCurrencyName();
    }

    @Override
    public int getCurrencyIdByName(String CurrencyName) throws SQLException {
        Session session = null;
        Currency result = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from Currency c where Currency_Name = :CurrencyName").setString("CurrencyName", CurrencyName);
            List resultList = query.list();
            result = (Currency) resultList.get(0);
            session.getTransaction().commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result.getCurrencyId();
    }

    @Override
    public Double getCurrencyRateById(int Currency_Id) throws SQLException {
        Session session = null;
        Currency result = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from Currency c where Currency_Id = :CurrencyId").setInteger("CurrencyId", Currency_Id);
            List resultList = query.list();
            result = (Currency) resultList.get(0);
            session.getTransaction().commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result.getCurrencyRate();
    }

    @Override
    public Collection getAllCurrencys() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteCurrency(Currency currency) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.Impl;

import dao.BankDAO;
import java.util.List;
import org.hibernate.Session;
import pojo.Bank;
import util.HibernateUtil;

/**
 *
 * @author APopov
 */
public class BankDAOImpl implements BankDAO {

    public void addBank(Bank bank) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(bank);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
    }

    public List getAllBanks() {
        List out = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            out = session.createCriteria(Bank.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
        return out;
    }

    public Bank getBankById(int id) {
        System.out.println(id);
        List out = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            out = session.createCriteria(Bank.class, id + "").list();
            System.out.println(out.size());
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
        return (Bank) out.get(1);
    }
}

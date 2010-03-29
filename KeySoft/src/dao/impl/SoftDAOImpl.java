/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.SoftDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import pojo.Soft;
import util.HibernateUtil;

/**
 *
 * @author APopov
 */
public class SoftDAOImpl implements SoftDAO {

    private HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sf) {
        this.hibernateTemplate = new HibernateTemplate(sf);
    }

    public void addSoft(Soft soft) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(soft);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
    }

    public List getAllSofts() {
        List out = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            out = session.createCriteria(Soft.class).list();
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

    public List getAllNonEmptySofts() {
        List out = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query getByLogin = session.createQuery("from Soft s where fullName != ''");
            out = getByLogin.list();
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

    public Soft getSoftById(int id) {
        List out = null;
        Session session = null;
        Soft soft = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query getByLogin = session.createQuery(
                    "from Soft s where id = :id")//
                    .setInteger("id", id);
            out = getByLogin.list();
            soft = (Soft) out.get(0);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
        return soft;
    }
}

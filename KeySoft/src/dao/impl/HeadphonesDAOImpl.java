/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.HeadphonesDAO;
import java.util.List;
import org.hibernate.Session;
import pojo.Headphones;
import util.HibernateUtil;

/**
 *
 * @author IRozhkov
 */
public class HeadphonesDAOImpl implements HeadphonesDAO {

    public void addHeadphones(Headphones headphones) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(headphones);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
    }

    public List getAllHeadphones() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Headphones getHeadphonesById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

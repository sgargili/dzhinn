/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Impl;

import DAO.newArticlesDAO;
import Pojo.Newarticles;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author IRozhkov
 */
public class newArticlesDAOImpl implements newArticlesDAO {

    @Override
     public void addnArticles(Newarticles articles) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(articles);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

     @Override
    public Collection getAllArticles() throws SQLException {
        Session session = null;
        List<Newarticles> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getArticles =
                    session.createQuery(
                    "from Newarticles a");
            result = getArticles.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

}

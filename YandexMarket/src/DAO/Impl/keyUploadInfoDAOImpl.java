/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Impl;

import DAO.keyUploadInfoDAO;
import Pojo.KeyUploadInfo;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author ilyahoo
 */
public class keyUploadInfoDAOImpl implements keyUploadInfoDAO {
@Override
    public void addKeys(KeyUploadInfo keys) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(keys);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Collection getAllKeys() throws SQLException {
        Session session = null;
        List<KeyUploadInfo> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getArticles =
                    session.createQuery(
                    "from KeyUploadInfo a");
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

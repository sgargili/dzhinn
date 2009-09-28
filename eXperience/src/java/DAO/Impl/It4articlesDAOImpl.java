/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.It4articlesDAO;
import Pojo.It4articles;
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
public class It4articlesDAOImpl implements It4articlesDAO {

    @Override
    public void addIt4articles(It4articles it4articles) throws SQLException {
        Session session = null;
        try {
            session = HibernatePriceConUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(it4articles);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateIt4articles(It4articles it4articles) throws SQLException {
        Session session = null;
        try {
            session = HibernatePriceConUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(it4articles);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public It4articles getIt4articlesById(Long Article_Id) throws SQLException {
        Session session = null;
        It4articles result = null;
        try {
            session = HibernatePriceConUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from It4articles i where It4Profit_Article_Classcat = :it4profitArticleClasscat").setLong("it4profitArticleClasscat", Article_Id);
            List resultList = query.list();
            result = (It4articles) resultList.get(0);
            session.getTransaction().commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public String getDescriptionByIt4articleName(String It4articleName) throws SQLException {
        Session session = null;
        String result = null;
        It4articles mtch = null;
        try {
            session = HibernatePriceConUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from It4articles i where It4Profit_Article_Name = :It4profitArticleName ").setString("It4profitArticleName", It4articleName);
            List resultList = query.list();
            if (!resultList.isEmpty()) {
                mtch = (It4articles) resultList.get(0);
                result = mtch.getIt4prifitArticleDescription();
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
    public Collection getAllIt4articles() throws SQLException {
        Session session = null;
        List<It4articles> result = null;
        session = HibernatePriceConUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from It4articles s");
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
    public boolean isIt4articlePresent(String Article) throws SQLException {
        Session session = null;
        List result = null;
        boolean out = false;
        session = HibernatePriceConUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin;
            getByLogin = session.createQuery("from It4articles i where It4Profit_Article_Name = :It4ProfitArticleName");
            getByLogin.setString("It4ProfitArticleName", Article);
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

    @Override
    public void deleteMatching(It4articles it4articles) throws SQLException {
        Session session = null;
        try {
            session = HibernatePriceConUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(it4articles);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}

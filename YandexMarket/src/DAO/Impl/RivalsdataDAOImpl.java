/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.RivalsdataDAO;
import Pojo.Rivalsdata;
import Pojo.RivalsdataId;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author Admin4DB2
 */
public class RivalsdataDAOImpl implements RivalsdataDAO {

    private static double format(double num, int col) {
        NumberFormat aFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        aFormat.setMaximumFractionDigits(col);
        return Double.parseDouble(aFormat.format(num));
    }

    public void addRivalsdata(Rivalsdata rivalsdata) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(rivalsdata);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Collection getAllRivalsdata() throws SQLException {
        Session session = null;
        List<Rivalsdata> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getArticles =
                    session.createQuery(
                    "from Rivalsdata");
            result = getArticles.list();
        } catch (RuntimeException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public Rivalsdata getRivalsdataByArticleId(long id) throws SQLException {
        Session session = null;
        List<Rivalsdata> result = new ArrayList<Rivalsdata>();
        session = HibernateUtil.getSessionFactory().openSession();
        Rivalsdata out;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Rivalsdata r where article_id = :art_id")//
                    .setLong("art_id", id);
            result = getByLogin.list();
            out = result.get(0);
        } catch (RuntimeException e) {
            out = null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return out;
    }

    public double getAveragePriceByArticleId(long articleId) throws SQLException {
        Session session = null;
        List<Rivalsdata> result = new ArrayList<Rivalsdata>();
        session = HibernateUtil.getSessionFactory().openSession();
        Rivalsdata out;
        double aPrice = 0;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Rivalsdata r where article_id = :art_id")//
                    .setLong("art_id", articleId);
            result = getByLogin.list();
            for (Iterator iter = result.iterator(); iter.hasNext();) {
                out = (Rivalsdata) iter.next();
                aPrice += out.getRivalPrice();
                // System.out.println(out.getRivalPrice());
            }
            // out = result.get(0);
        } catch (Exception e) {
            aPrice = 0.0;
        } finally {
            // System.out.println("Сумма - "+aPrice);
            aPrice = aPrice / result.size();
            // System.out.println("Количество - "+result.size());

            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return aPrice;
    }

    @Override
    public Collection getAllRivalsDataByArticleId(long id) throws SQLException {
        Session session = null;
        List<Rivalsdata> result = new ArrayList<Rivalsdata>();
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Rivalsdata r where article_id = :art_id")//
                    .setLong("art_id", id);
            result = getByLogin.list();

        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public double getAveragePriceByArticleId(long articleId, int size) throws SQLException {
        Session session = null;
        List<Rivalsdata> result = new ArrayList<Rivalsdata>();
        session = HibernateUtil.getSessionFactory().openSession();
        Rivalsdata out;
        double aPrice = 0;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Rivalsdata r where article_id = :art_id")//
                    .setLong("art_id", articleId);
            result = getByLogin.list();
            for (Iterator iter = result.iterator(); iter.hasNext();) {
                out = (Rivalsdata) iter.next();
                aPrice += out.getRivalPrice();
                // System.out.println(out.getRivalPrice());
            }
            // out = result.get(0);
        } catch (Exception e) {
            aPrice = 0.0;
        } finally {
            // System.out.println("Сумма - "+aPrice);
            aPrice = aPrice / result.size();
            // System.out.println("Количество - "+result.size());

            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return format(aPrice, size);
    }

    @Override
    public double getMinimumPriceByArticleId(long articleId) throws SQLException {
        Session session = null;
        List<Rivalsdata> result = new ArrayList<Rivalsdata>();
        Set set = new TreeSet();
        session = HibernateUtil.getSessionFactory().openSession();
        Rivalsdata out;
        double aPrice = 0;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Rivalsdata r where article_id = :art_id")//
                    .setLong("art_id", articleId);
            result = getByLogin.list();
            for (Iterator iter = result.iterator(); iter.hasNext();) {
                out = (Rivalsdata) iter.next();
                set.add(out.getRivalPrice());
            }

            Iterator iter = set.iterator();
            aPrice = (Double) iter.next();
        } catch (Exception e) {
            aPrice = 0.0;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return aPrice;
    }

    @Override
    public double getMinimumSumPriceByArticleId(long articleId) throws SQLException {
        Session session = null;
        List<Rivalsdata> result = new ArrayList<Rivalsdata>();
        Set set = new TreeSet();
        session = HibernateUtil.getSessionFactory().openSession();
        Rivalsdata out;
        double aPrice = 0;
        String delPrice;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Rivalsdata r where article_id = :art_id")//
                    .setLong("art_id", articleId);
            result = getByLogin.list();
            for (Iterator iter = result.iterator(); iter.hasNext();) {
                out = (Rivalsdata) iter.next();
                delPrice = out.getRivalDelivery().replaceAll("[^0-9]", "");
                delPrice = delPrice.equals("") ? "0" : delPrice;
                set.add(out.getRivalPrice() + Double.parseDouble(delPrice));
            }

            Iterator iter = set.iterator();
            aPrice = (Double) iter.next();
        } catch (Exception e) {
            System.out.println(e);
            aPrice = 0.0;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return aPrice;
    }

    @Override
    public RivalsdataId getId4MinimumPriceByArticleId(long articleId) throws SQLException {
        Session session = null;
        List<Rivalsdata> result = new ArrayList<Rivalsdata>();
        Set set = new TreeSet();
        session = HibernateUtil.getSessionFactory().openSession();
        Rivalsdata out;
        RivalsdataId id = null;
        double aPrice = 0;
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Rivalsdata r where article_id = :art_id")//
                    .setLong("art_id", articleId);
            result = getByLogin.list();
            for (Iterator iter = result.iterator(); iter.hasNext();) {
                out = (Rivalsdata) iter.next();
                set.add(out.getRivalPrice());
            }
            Iterator iter = set.iterator();
            aPrice = (Double) iter.next();
            for (Iterator iterId = result.iterator(); iterId.hasNext();) {
                out = (Rivalsdata) iterId.next();
                if (out.getRivalPrice() == aPrice) {
                    id = out.getId();
                    break;
                }
            }
        } catch (Exception e) {
            id = new RivalsdataId();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return id;
    }

    @Override
    public RivalsdataId getId4MinimumSumPriceByArticleId(long articleId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

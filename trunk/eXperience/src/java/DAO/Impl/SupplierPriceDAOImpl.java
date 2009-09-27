/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.SupplierPriceDAO;
import Pojo.Supplierprice;
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
public class SupplierPriceDAOImpl implements SupplierPriceDAO {

    @Override
    public void addSupplierprice(Supplierprice supplierprice) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(supplierprice);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateSupplierprice(Supplierprice supplierprice) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(supplierprice);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Supplierprice getSupplierpriceById(Long Supplierprice_Id) throws SQLException {
        Session session = null;
        Supplierprice result = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from Supplier s where Supplier_Id = :SupplierId ").setLong("SupplierId", Supplierprice_Id);
            List resultList = query.list();
            result = (Supplierprice) resultList.get(0);
            session.getTransaction().commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public Collection getAllSupplierprice() throws SQLException {
        Session session = null;
        List<Supplierprice> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin =
                    session.createQuery(
                    "from Supplierprice");
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
    public void deleteSupplierprice(Supplierprice supplierprice) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(supplierprice);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Collection getAllSupplierpriceById(Long Supplierprice_Id, String Article) throws SQLException {
        Session session = null;
        List result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin;
            if (Article.equals("") || Article.equals(null)) {
                if (Supplierprice_Id == 7) {
                    getByLogin = session.createQuery("from Supplierprice s");
                } else {
                    getByLogin = session.createQuery("from Supplierprice s where Supplier_Id = :SupplierId ");
                    getByLogin.setLong("SupplierId", Supplierprice_Id);
                }
            } else {
                if (Supplierprice_Id == 7) {
                    getByLogin = session.createQuery("from Supplierprice s where Supplier_Article_Name like :SupplierArticleName");
                    getByLogin.setString("SupplierArticleName", "%" + Article + "%");
                } else {
                    getByLogin = session.createQuery("from Supplierprice s where Supplier_Id = :SupplierId and Supplier_Article_Name like :SupplierArticleName");
                    getByLogin.setLong("SupplierId", Supplierprice_Id);
                    getByLogin.setString("SupplierArticleName", "%" + Article + "%");
                }
            }
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
    public boolean isSupplierArticlePresentbySupplier(String Article, Long SupplierId) throws SQLException {
        Session session = null;
        List result = null;
        boolean out = false;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin;
            getByLogin = session.createQuery("from Supplierprice s where Supplier_Article_Name = :SupplierArticleName and Supplier_Id = :SupplierId");
            getByLogin.setString("SupplierArticleName", Article);
            getByLogin.setLong("SupplierId", SupplierId);
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
    public Collection getSupplierpriceByArticleBySupplier(String Article, Long Supplier_Id) throws SQLException {
        Session session = null;
        List result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query getByLogin;
            if (Article.equals("") || Article.equals(null)) {
                if (Supplier_Id == 7) {
                    getByLogin = session.createQuery("from Supplierprice s");
                } else {
                    getByLogin = session.createQuery("from Supplierprice s where Supplier_Id = :SupplierId ");
                    getByLogin.setLong("SupplierId", Supplier_Id);
                }
            } else {
                if (Supplier_Id == 7) {
                    getByLogin = session.createQuery("from Supplierprice s where Supplier_Article_Name like :SupplierArticleName");
                    getByLogin.setString("SupplierArticleName", "%" + Article + "%");
                } else {
                    getByLogin = session.createQuery("from Supplierprice s where Supplier_Id = :SupplierId and Supplier_Article_Name like :SupplierArticleName");
                    getByLogin.setLong("SupplierId", Supplier_Id);
                    getByLogin.setString("SupplierArticleName", "%" + Article + "%");
                }
            }
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
    public Long getIdBySupplierByArticle(Long Supplier_Id, String Article) {
        Session session = null;
        Supplierprice result = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Query query = session.createQuery("from Supplierprice s where Supplier_Article_Name = :SupplierArticleName and Supplier_Id = :SupplierId");
            query.setString("SupplierArticleName", Article);
            query.setLong("SupplierId", Supplier_Id);
            List resultList = query.list();
            result = (Supplierprice) resultList.get(0);
            session.getTransaction().commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result.getId();
    }
}

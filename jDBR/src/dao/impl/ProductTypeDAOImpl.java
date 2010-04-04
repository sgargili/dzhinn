/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.ProductTypeDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.ProductType;
import util.HibernateUtil;

/**
 *
 * @author Apopov
 */
public class ProductTypeDAOImpl implements ProductTypeDAO {

    public ProductType getProductTypeById(int id) {
        Session session = null;
        ProductType pt = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
//            Query query = session.createQuery("from ProductType p where productTypeId = :productTypeId ").setInteger("productTypeId", id);
//            List resultList = query.list();
//            pt = (ProductType) resultList.get(0);
            pt = (ProductType) session.load(ProductType.class, id);
            pt.getGroupes().size();
            pt.getGroupes().get(0).getAttributes().size();
            //pt = (ProductType) session.load(ProductType.class, id);
            session.getTransaction().commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return pt;
    }
}

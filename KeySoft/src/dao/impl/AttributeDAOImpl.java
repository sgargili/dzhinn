/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.AttributeDAO;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.Attribute;
import pojo.ProductType;
import pojo.Value;
import util.HibernateUtil;

/**
 *
 * @author APopov
 */
public class AttributeDAOImpl implements AttributeDAO {

    public void addAttribute(Attribute attribute) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(attribute);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
    }

    public List<Attribute> getAllAttributes() {
        List<Attribute> out = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            out = session.createCriteria(Attribute.class).list();
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

    public Set<ProductType> getAllProductTypesByAttribute(Attribute attribute) {
        List<Attribute> outTemp = null;
        Set<ProductType> out = null;
        Session session = null;
        Attribute attr;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //from Keyhtml k where keyarticle = :art")//
            Query getByLogin = session.createQuery("from Attribute a left join fetch a.productTypes where a.attributeId = :atrId");
            getByLogin.setInteger("atrId", attribute.getAttributeId());
            outTemp = getByLogin.list();
            attr =(Attribute) outTemp.get(0);
            System.out.println(attr.getAttributeId());
            System.out.println(attr.getAttributeName());
            out = attr.getProductTypes();
//            Iterator it = outTemp.iterator();
//            //int i = 1;
//            while (it.hasNext()) {
//                out.add((ProductType) it.next());
//            }
            //out = session.createCriteria(ProductType.class, attribute.getAttributeId() + "").list();
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

    public Set<Value> getAllValuesByAttribute(Attribute attribute) {
        Set<Value> out = null;
//        Session session = null;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            out = session.createCriteria(Value.class, attribute.getAttributeId() + "").list();
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            System.out.println(e);
//        } finally {
//            if (session != null && session.isOpen()) {
//
//                session.close();
//            }
//        }
        return out;
    }

    public Attribute getAttributeById(int id) {
        List<Attribute> out = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query getByLogin = session.createQuery("from Attribute a where attributeId = :atrId");
            getByLogin.setInteger("atrId", id);
            out = getByLogin.list();

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
        return out.get(0);
    }
}

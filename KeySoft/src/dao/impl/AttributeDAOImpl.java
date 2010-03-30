/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.AttributeDAO;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import pojo.Attribute;
import pojo.ProductType;
import pojo.Value;

/**
 *
 * @author APopov
 */
public class AttributeDAOImpl implements AttributeDAO {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setSessionFactory(SessionFactory sf) {
        this.hibernateTemplate = new HibernateTemplate(sf);
    }

    public void addAttribute(Attribute attribute) {
        getHibernateTemplate().save(attribute);
        getHibernateTemplate().flush();
    }

    public void updateAttributeDependence(Attribute attribute) {
        Attribute newAttribute;
        try {
            newAttribute = getAttributeById(attribute.getAttributeId());
        } catch (Exception ex) {
            System.out.println("Нечего обновлять... Нету такого аттрибута с Id: " + attribute.getAttributeId());
            return;
        }
        newAttribute.getValues().addAll(attribute.getValues());
        newAttribute.getProductTypes().addAll(attribute.getProductTypes());
        getHibernateTemplate().merge(newAttribute);
        getHibernateTemplate().flush();
    }

    public void updateAttributeNameOnly(Attribute attribute) {
        try {
            Attribute newAttribute;
            newAttribute = getAttributeById(attribute.getAttributeId());
            newAttribute.setAttributeName(attribute.getAttributeName());
            getHibernateTemplate().update(newAttribute);
        } catch (Exception ex) {
            System.out.println("Нечего обновлять... Нету такого аттрибута с Id: " + attribute.getAttributeId());
        }
        getHibernateTemplate().flush();
    }

    public void addOrUpdateAttributeNameOnly(Attribute attribute) {
        try {
            Attribute newAttribute;
            newAttribute = getAttributeById(attribute.getAttributeId());
            newAttribute.setAttributeName(attribute.getAttributeName());
            getHibernateTemplate().update(newAttribute);
        } catch (Exception ex) {
            getHibernateTemplate().save(attribute);
        }
        getHibernateTemplate().flush();
    }

    public void deleteAttribute(Attribute attribute) {
        getHibernateTemplate().delete(attribute);
    }

    public List<Attribute> getAllAttributesOnly() {
        return (List<Attribute>) getHibernateTemplate().loadAll(Attribute.class);
    }

    public List<Attribute> getAllAttributesHavingDependence() {
        String query = "from Attribute a "
                + "join fetch a.productTypes "
                + "join fetch a.values";
        return getHibernateTemplate().find(query);
    }

    public List<Attribute> getAttributesByProductTypes() {
        String query = "from Attribute a "
                + "join fetch a.productTypes";
        return getHibernateTemplate().find(query);
    }

    public List<Attribute> getAttributesByProductType(ProductType productType) {
        String query = "from Attribute a "
                + "join fetch a.productTypes as productType "
                + "where productType = :productType";
        return getHibernateTemplate().findByNamedParam(query, "productType", productType);
    }

    public List<Attribute> getAttributesByValues() {
        String query = "from Attribute a "
                + "join fetch a.values";
        return getHibernateTemplate().find(query);
    }

    public List<Attribute> getAttributesByValue(Value value) {
        String query = "from Attribute a "
                + "join fetch a.values as value "
                + "where value = :value";
        return getHibernateTemplate().findByNamedParam(query, "value", value);
    }

    public Attribute getAttributeById(int id) {
        return (Attribute) getHibernateTemplate().load(Attribute.class, id);
    }
//    public Set<ProductType> getAllProductTypesByAttribute(Attribute attribute) {
//        List<Attribute> outTemp = null;
//        Set<ProductType> out = null;
//        Session session = null;
//        Attribute attr;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            //from Keyhtml k where keyarticle = :art")//
//            Query getByLogin = session.createQuery("from Attribute a left join fetch a.productTypes where a.attributeId = :atrId");
//            getByLogin.setInteger("atrId", attribute.getAttributeId());
//            outTemp = getByLogin.list();
//            attr = (Attribute) outTemp.get(0);
//            System.out.println(attr.getAttributeId());
//            System.out.println(attr.getAttributeName());
//            out = attr.getProductTypes();
////            Iterator it = outTemp.iterator();
////            //int i = 1;
////            while (it.hasNext()) {
////                out.add((ProductType) it.next());
////            }
//            //out = session.createCriteria(ProductType.class, attribute.getAttributeId() + "").list();
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            System.out.println(e);
//        } finally {
//            if (session != null && session.isOpen()) {
//
//                session.close();
//            }
//        }
//        return out;
//    }
}

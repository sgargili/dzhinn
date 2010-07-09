/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.AttributeDAO;
import java.util.Iterator;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import pojo.Attribute;
import pojo.Groupe;
import pojo.ProductType;

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

    public boolean isAttributePresent(Attribute attribute) {
        try {
            attribute = (Attribute) getHibernateTemplate().load(Attribute.class, attribute.getAttributeId());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public Attribute getAttributeByName(String name) {
        String query = "from Attribute a where attributeName = :value";
        try {
            return (Attribute) getHibernateTemplate().findByNamedParam(query, "value", name).get(0);
        } catch (Exception ex) {
            return null;
        }

    }

    public void addAttribute(Attribute attribute) {
        getHibernateTemplate().saveOrUpdate(attribute);
    }

    @Override
    public List<Attribute> getAllAttributesOnly() {
        return (List<Attribute>) getHibernateTemplate().loadAll(Attribute.class);
    }

    @Override
    public List<Attribute> getAttributesOnlyByProductType(ProductType productType) {
        String query = "from Attribute a " +//
                "join fetch a.productTypes as productType " + //
                "where productType = :productType " + //
                "order by a.attributeName";
        return getHibernateTemplate().findByNamedParam(query, "productType", productType);
    }

    public Attribute getAttributeById(int id) {
//        Attribute atr = (Attribute) getHibernateTemplate().load(Attribute.class, id);
//        try {
//            atr.getAttributeAlternative().equals("");
//            atr.getAttributeAlternativeNames().isEmpty();
//        } catch (NullPointerException ex) {
//            atr.setAttributeAlternative("");
//             atr.setAttributeAlternativeNames(null);
//        }
//        return atr;
        Attribute atr;
        String query = "from Attribute a where attributeId = :value";
        try {
            atr = (Attribute) getHibernateTemplate().findByNamedParam(query, "value", id).get(0);
            atr.getAttributeAlternativeNames().isEmpty();
            return atr;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Attribute> getAttributesOnlyByProductTypeId(int id) {
        ProductType productType = new ProductType();
        productType.setProductTypeId(id);
        String query = "from Attribute a " +//
                "join fetch a.productTypes as productType " + //
                "where productType = :productType " + //
                "order by a.attributeName";
        List<Attribute> outList = getHibernateTemplate().findByNamedParam(query, "productType", productType);
        productType = null;
        return outList;
    }

    public void updateAttributeAltNameOnly(Attribute attribute) {
        try {
            Attribute newAttribute;
            newAttribute = getAttributeById(attribute.getAttributeId());
            newAttribute.setAttributeAlternative(attribute.getAttributeAlternative());
            getHibernateTemplate().update(newAttribute);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Нечего обновлять... Нету такого аттрибута с Id: " + attribute.getAttributeId());
        }
    }

    public void deleteAttribute(Attribute attribute) {
        //attribute.s
        getHibernateTemplate().delete(attribute);
    }

    public boolean isAttributePresent(String attributeName) {
        String query = "from Attribute a where attributeName = :value";
        try {
            return !getHibernateTemplate().findByNamedParam(query, "value", attributeName).isEmpty();
        } catch (Exception ex) {
            return false;
        }
    }

    public void addOrUpdateAttributeNameOnly(Attribute attribute) {
        try {
            Attribute newAttribute;
            newAttribute = getAttributeByName(attribute.getAttributeName());
            newAttribute.setAttributeAlternative(attribute.getAttributeAlternative());
            getHibernateTemplate().update(newAttribute);
        } catch (Exception ex) {
            // ex.printStackTrace();
            getHibernateTemplate().save(attribute);
        }
    }

    public List<Attribute> getAttributesOnlyByTemplate(String template) {
        template = "%" + template + "%";
        String query = "from Attribute a where attributeName like :value";
        System.out.println(template);
        try {
            return getHibernateTemplate().findByNamedParam(query, "value", template);
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Attribute> getAllAttributesWithAltNames() {
        String query = "from Attribute as a " +
                "join fetch a.attributeAlternativeNames";
        return getHibernateTemplate().find(query);
    }

    public List<Attribute> getAttributesWithAltNamesByProductType(ProductType productType) {
        String query = "from Attribute a " +//
                "join fetch a.productTypes as productType " + //
                "where productType = :productType " + //
                "order by a.attributeName";
        List<Attribute> atrList = getHibernateTemplate().findByNamedParam(query, "productType", productType);
        Iterator it = atrList.iterator();
        Attribute atr;
        while (it.hasNext()) {
            atr = (Attribute) it.next();
            atr.getAttributeAlternativeNames().isEmpty();
        }
        return atrList;
    }

    public List<Attribute> getAttributesOnlyByGroupe(Groupe groupe) {
        String query = "from Attribute a " +//
                "join fetch a.groupes as groupe " + //
                "where groupe = :groupe " + //
                "order by a.attributeName";
        return getHibernateTemplate().findByNamedParam(query, "groupe", groupe);
    }

    public List<Attribute> getAttributesOnlyByGroupeId(int id) {
        Groupe groupe = new Groupe();
        groupe.setGroupeId(id);
        String query = "from Attribute a " +//
                "join fetch a.groupes as groupe " + //
                "where groupe = :groupe " + //
                "order by a.attributeName";
        List<Attribute> outList = getHibernateTemplate().findByNamedParam(query, "groupe", groupe);
        groupe = null;
        return outList;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.AttributeDAO;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import Pojo.Attribute;
import Pojo.ProductType;

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
    public List<Attribute> getAttributesOnlyByProductTypeId(ProductType productType) {
        String query = "from Attribute a " +//
                "join fetch a.productTypes as productType " + //
                "where productType = :productType " + //
                "order by a.attributeName";
        return getHibernateTemplate().findByNamedParam(query, "productType", productType);
    }
}

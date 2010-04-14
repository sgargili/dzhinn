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
        Attribute atr = (Attribute) getHibernateTemplate().load(Attribute.class, id);
        try {
            atr.getAttributeAlternative().equals("");
        } catch (NullPointerException ex) {
            atr.setAttributeAlternative("");
        }
        return atr;
    }

    public List<Attribute> getAttributesOnlyByProductTypeId(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
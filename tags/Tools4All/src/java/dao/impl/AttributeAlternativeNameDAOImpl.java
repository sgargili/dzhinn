/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.AttributeAlternativeNameDAO;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import pojo.Attribute;
import pojo.AttributeAlternativeName;

/**
 *
 * @author APopov
 */
public class AttributeAlternativeNameDAOImpl implements AttributeAlternativeNameDAO {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setSessionFactory(SessionFactory sf) {
        this.hibernateTemplate = new HibernateTemplate(sf);
    }

    public void addAttributeAlternativeName(AttributeAlternativeName attributeAlternativeName) {
        if (!isAttributeAlternativeNamePresent(attributeAlternativeName.getAttributeAlernativeNameValue())) {
            getHibernateTemplate().save(attributeAlternativeName);
        }
    }

    public boolean isAttributeAlternativeNamePresent(AttributeAlternativeName attributeAlternativeName) {
        try {
            attributeAlternativeName = (AttributeAlternativeName) getHibernateTemplate().load(AttributeAlternativeName.class, attributeAlternativeName.getAttributeAlernativeNameId());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean isAttributeAlternativeNamePresent(String attributeAlternativeNameValue) {
        String query = "from AttributeAlternativeName a where attributeAlernativeNameValue = :value";
        try {
            return !getHibernateTemplate().findByNamedParam(query, "value", attributeAlternativeNameValue).isEmpty();
        } catch (Exception ex) {
            return false;
        }
    }

    public void deleteAttributeAlternativeName(AttributeAlternativeName attributeAlternativeName) {
        getHibernateTemplate().delete(attributeAlternativeName);
    }

    public void deleteAttributeAlternativeNameByAttribute(final Attribute attribute) {
//        String query = "delete from AttributeAlternativeName alt where alt.attribute = :attribute";
//        getHibernateTemplate().bulkUpdate(query, "attribute", attribute);
        final String request = "delete from AttributeAlternativeName alt where alt.attribute = :attribute";
        getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(request);
                query.setParameter("attribute", attribute);
                return query.executeUpdate();
            }
        });
    }
}
//            return getHibernateTemplate().findByNamedParam(query, "value", template);


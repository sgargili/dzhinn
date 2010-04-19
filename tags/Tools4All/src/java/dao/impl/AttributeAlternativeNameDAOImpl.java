/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.AttributeAlternativeNameDAO;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
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
        getHibernateTemplate().saveOrUpdate(attributeAlternativeName);
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
}

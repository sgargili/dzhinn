/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.AttributeAlternativeNameDAO;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import pojo.Attribute;
import pojo.AttributeAlternativeName;
import pojo.Groupe;

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
//        if (!isAttributeAlternativeNamePresent(attributeAlternativeName.getAttributeAlernativeNameValue())) {
        getHibernateTemplate().save(attributeAlternativeName);
//        }
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

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(request);
                query.setParameter("attribute", attribute);
                return query.executeUpdate();
            }
        });
    }

    @Override
    public boolean isAttributeAlternativeNamePresentByAttributeId(AttributeAlternativeName attributeAlternativeName) {
        String query = "from AttributeAlternativeName a where attributeAlernativeNameValue = :value and attribute = :value2 and groupe = :value3";
        String[] paramNames = new String[3];
        paramNames[0] = "value";
        paramNames[1] = "value2";
        paramNames[2] = "value3";
        Object[] objs = new Object[3];
        objs[0] = attributeAlternativeName.getAttributeAlernativeNameValue();
        objs[1] = attributeAlternativeName.getAttribute();
        objs[2] = attributeAlternativeName.getGroupe();
        try {
            return !getHibernateTemplate().findByNamedParam(query, paramNames, objs).isEmpty();
        } catch (Exception ex) {
            System.out.println("|||||||||||" + ex.getMessage());
            return false;
        }
    }

    @Override
    public AttributeAlternativeName getAttributeAlternativeNameById(int id) {
        AttributeAlternativeName atr;
        String query = "from AttributeAlternativeName a where attributeAlernativeNameId = :value";
        try {
            atr = (AttributeAlternativeName) getHibernateTemplate().findByNamedParam(query, "value", id).get(0);
            return atr;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public int getAttributeAlternativeIdByNameByAttributeIdByNativeSQL(final String altName, final int atrId) {
        List result = null;
        final String request =
                "select distinct "
                + "    aan.attribute_alernative_name_id "
                + "from  "
                + "    attribute_alternative_name as aan "
                + "where "
                + "    aan.attribute_alernative_name_value = :name "
                + "and "
                + "    aan.attribute_id = :id";
        result = (List) getHibernateTemplate().execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                SQLQuery query = session.createSQLQuery(request);
                query.setString("name", altName);
                query.setInteger("id", atrId);
                return query.list();
            }
        });
        return ((Integer) result.get(0));
    }

    @Override
    public List getAttributeAlternativeNameByAttributeByGroupe(int attributeId, int groupeId) {
        List result = null;
        final Attribute atr = new Attribute();
        final Groupe gp = new Groupe();
        atr.setAttributeId(attributeId);
        gp.setGroupeId(groupeId);
        final String request =
                "from AttributeAlternativeName a where a.attribute = :attribute and a.groupe = :groupe";
        result = (List) getHibernateTemplate().execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(request);
                query.setParameter("attribute", atr);
                query.setParameter("groupe", gp);
                return query.list();
            }
        });
        return result;
    }

    @Override
    public void updateRegexpElabType(final int atrId) {
        final String request =
                "update "
                + "    attribute_alternative_name  "
                + "set  "
                + "    regexp_elab_type = !regexp_elab_type  "
                + "where  "
                + "    attribute_alernative_name_id = :atrId";
        getHibernateTemplate().execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                SQLQuery query = session.createSQLQuery(request);
                query.setInteger("atrId", atrId);
                return query.executeUpdate();
            }
        });
    }

    @Override
    public AttributeAlternativeName getAttributeAlternativeNameByAttributeByGroupeByName(int attributeId, int groupeId, final String altName) {
        List result = null;
        final Attribute atr = new Attribute();
        final Groupe gp = new Groupe();
        atr.setAttributeId(attributeId);
        gp.setGroupeId(groupeId);
        final String request =
                "from AttributeAlternativeName a where a.attribute = :attribute and a.groupe = :groupe and a.attributeAlernativeNameValue = :altName";
        result = (List) getHibernateTemplate().execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(request);
                query.setParameter("attribute", atr);
                query.setParameter("groupe", gp);
                query.setString("altName", altName);
                return query.list();
            }
        });
        if (result.isEmpty()) {
            return null;
        } else {
            return (AttributeAlternativeName) result.get(0);
        }
    }
}
//            return getHibernateTemplate().findByNamedParam(query, "value", template);


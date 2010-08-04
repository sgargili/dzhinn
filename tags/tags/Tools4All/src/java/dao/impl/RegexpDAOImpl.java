/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.RegexpDAO;
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
import pojo.Regexp;

/**
 *
 * @author APOPOV
 */
public class RegexpDAOImpl implements RegexpDAO {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setSessionFactory(SessionFactory sf) {
        this.hibernateTemplate = new HibernateTemplate(sf);
    }

    public void addRegexp(Regexp regexp) {
        getHibernateTemplate().saveOrUpdate(regexp);
    }

    public void deleteRegexp(Regexp regexp) {
        getHibernateTemplate().delete(regexp);
    }

    public void deleteRegexpByAttribute(final Attribute attribute) {
        final String request = "delete from Regexp reg where reg.attribute = :attribute";
        getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(request);
                query.setParameter("attribute", attribute);
                return query.executeUpdate();
            }
        });
    }

    public boolean isRegexpPresent(Regexp regexp) {
        try {
            regexp = (Regexp) getHibernateTemplate().load(Regexp.class, regexp.getRegexpId());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean isRegexpPresent(String regexpValue) {
        String query = "from Regexp reg where reg.regexpPattern = :value";
        try {
            return !getHibernateTemplate().findByNamedParam(query, "value", regexpValue).isEmpty();
        } catch (Exception ex) {
            return false;
        }
    }

    public List<Regexp> getRegexpsByAttribute(Attribute attribute) {
        String query = "from Regexp reg " +//
                "join fetch reg.attribute as attribute " + //
                "where attribute = :attribute ";  //
//                "order by a.attributeName";
        return getHibernateTemplate().findByNamedParam(query, "attribute", attribute);
    }

    public Regexp getRegexpById(int regexpId) {
        return (Regexp) getHibernateTemplate().get(Regexp.class, regexpId);
    }

    public List getRegexpsByAttributeByGroupeByNativeSQL(final int groupeId, final int attributeId) {
        List result = null;
        final String request =
                "select "
                + "    reg.regexp_id, "
                + "    reg.regexp_type, "
                + "    reg.regexp_pattern, "
                + "    reg.regexp_replacement, "
                + "    reg.use_attribute "
                + "from  "
                + "    `regexp` as reg "
                + "where "
                + "    reg.attribute_id = :attributeId "
                + "    and reg.groupe_id = :groupeId";

        result = (List) getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                SQLQuery query = session.createSQLQuery(request);
                query.setInteger("attributeId", attributeId);
                query.setInteger("groupeId", groupeId);
                return query.list();
            }
        });
        return result;
    }

    public boolean isRegexpPresent(final int groupeId, final int attributeId) {
        List result = null;
        final String request =
                "select "
                + "    reg.regexp_id, "
                + "    reg.regexp_type, "
                + "    reg.regexp_pattern, "
                + "    reg.regexp_replacement "
                + "from  "
                + "    `regexp` as reg "
                + "where "
                + "    reg.attribute_id = :attributeId "
                + "    and reg.groupe_id = :groupeId";

        result = (List) getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                SQLQuery query = session.createSQLQuery(request);
                query.setInteger("attributeId", attributeId);
                query.setInteger("groupeId", groupeId);
                return query.list();
            }
        });
        if (result.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List getRegexpsByAttAltIdByNativeSQL(final int attrAltId) {
        List result = null;
        final String request =
                "   select "
                + "    reg.regexp_id, "
                + "    reg.regexp_type, "
                + "    reg.regexp_pattern, "
                + "    reg.regexp_replacement, "
                + "    reg.data_usage, "
                + "    reg.regexp_last, "
                + "    com.composite_value, "
                + "    reg.weight "
                + "from "
                + "    `regexp` as reg "
                + "inner join "
                + "    attribute_alternative_name as aan "
                + "on "
                + "    aan.attribute_alernative_name_id = reg.attribute_alernative_name_id "
                + "inner join "
                + "    attribute as atr "
                + "on "
                + "    atr.attribute_id = aan.attribute_id "
                + "inner join "
                + "    groupe as grp "
                + "on "
                + "    grp.groupe_id = aan.groupe_id "
                + "inner join "
                + "    composite as com "
                + "on "
                + "    com.groupe_id = grp.groupe_id "
                + "and "
                + "    com.attribute_id = atr.attribute_id "
                + "where "
                + "    reg.attribute_alernative_name_id = :value "
                + "order by "
                + "   reg.weight";

        result = (List) getHibernateTemplate().execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                SQLQuery query = session.createSQLQuery(request);
                query.setInteger("value", attrAltId);
                return query.list();
            }
        });
        return result;
    }

    @Override
    public void updateRegexpWeight(final int atrAltId, final int regId, final int weight, final int regexpLast) {
        if (regexpLast == 0) {
            final String request =
                    "update "
                    + "    `regexp` as reg "
                    + "set "
                    + "    reg.weight = :weight, "
                    + "    reg.regexp_last = :last "
                    + "where "
                    + "    reg.regexp_id = :regId"
                    + "    and reg.attribute_alernative_name_id = :atrAltId";
            getHibernateTemplate().execute(new HibernateCallback() {

                @Override
                public Object doInHibernate(Session session) throws HibernateException {
                    SQLQuery query = session.createSQLQuery(request);
                    query.setInteger("weight", weight);
                    query.setBoolean("last", false);
                    query.setInteger("regId", regId);
                    query.setInteger("atrAltId", atrAltId);
                    return query.executeUpdate();
                }
            });
        } else if (regexpLast == 1) {

            final String request =
                    "update "
                    + "    `regexp` as reg "
                    + "set "
                    + "    reg.weight = :weight, "
                    + "    reg.regexp_last = :last "
                    + "where "
                    + "    reg.regexp_id = :regId"
                    + "    and reg.attribute_alernative_name_id = :atrAltId";
            getHibernateTemplate().execute(new HibernateCallback() {

                @Override
                public Object doInHibernate(Session session) throws HibernateException {
                    SQLQuery query = session.createSQLQuery(request);
                    query.setInteger("weight", weight);
                    query.setBoolean("last", true);
                    query.setInteger("regId", regId);
                    query.setInteger("atrAltId", atrAltId);
                    return query.executeUpdate();
                }
            });
        } else {
            final String request =
                    "update "
                    + "    `regexp` as reg "
                    + "set "
                    + "    reg.weight = :weight, "
                    + "    reg.regexp_last = null "
                    + "where "
                    + "    reg.regexp_id = :regId"
                    + "    and reg.attribute_alernative_name_id = :atrAltId";
            getHibernateTemplate().execute(new HibernateCallback() {

                @Override
                public Object doInHibernate(Session session) throws HibernateException {
                    SQLQuery query = session.createSQLQuery(request);
                    query.setInteger("weight", weight);
                    query.setInteger("regId", regId);
                    query.setInteger("atrAltId", atrAltId);
                    return query.executeUpdate();
                }
            });
        }
    }

    @Override
    public void deleteRegexpByAttributeAltId(int atrAltId) {
        final AttributeAlternativeName alt = new AttributeAlternativeName();
        alt.setAttributeAlernativeNameId(atrAltId);
        final String request = "delete from Regexp reg where reg.attributeAlternativeName = :attributeAlt";
        getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(request);
                query.setParameter("attributeAlt", alt);
                return query.executeUpdate();
            }
        });
    }
}

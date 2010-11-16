/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.OutputDataDAO;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import pojo.OutputData;

/**
 *
 * @author APopov
 */
public class OutputDataDAOImpl implements OutputDataDAO {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setSessionFactory(SessionFactory sf) {
        this.hibernateTemplate = new HibernateTemplate(sf);
    }

    public void addOutputData(OutputData outputData) {
        getHibernateTemplate().save(outputData);
    }

    public void deleteOutputData(OutputData outputData) {
        getHibernateTemplate().delete(outputData);
    }

    public List<OutputData> getAllOutputData() {
        return (List<OutputData>) getHibernateTemplate().loadAll(OutputData.class);
    }

    public OutputData getOutputDataById(int id) {
        OutputData outputData;
        String query = "from OutputData od where outputDataId = :value";
        try {
            outputData = (OutputData) getHibernateTemplate().findByNamedParam(query, "value", id).get(0);
            return outputData;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<OutputData> getOutputDataBySessionId(long sessionId) {
        List<OutputData> outputDataList;
        String query = "from OutputData od where sessionId = :value";
        try {
            outputDataList = getHibernateTemplate().findByNamedParam(query, "value", sessionId);
            return outputDataList;
        } catch (Exception ex) {
            return null;
        }
    }

    public boolean isOutputDataPresent(OutputData outputData) {
        String query = "from OutputData od where outputDataId = :value";
        try {
            return !getHibernateTemplate().findByNamedParam(query, "value", outputData.getOutputDataId()).isEmpty();
        } catch (Exception ex) {
            return false;
        }
    }

    public List<OutputData> getOutputDataByArticle(String article) {
        List<OutputData> outputDataList;
        String query = "from OutputData od where article = :value";
        try {
            outputDataList = getHibernateTemplate().findByNamedParam(query, "value", article);
            return outputDataList;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<OutputData> getOutputDataByAttribute(String attributeValue) {
        List<OutputData> outputDataList;
        String query = "from OutputData od where od.attribute = :value";
        try {
            outputDataList = getHibernateTemplate().findByNamedParam(query, "value", attributeValue);
            return outputDataList;
        } catch (Exception ex) {
            return null;
        }
    }

    public void deleteOutputDataBySessionId(final long sessionId) {
        final String request = "delete from OutputData od where od.sessionId = :sessionId";
        getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(request);
                query.setParameter("sessionId", sessionId);
                return query.executeUpdate();
            }
        });
    }

    public List getOutputDataByGroupeByAttributeByNativeSQL(final String groupeName, final String attributeName) {
        List result = null;
        final String request =
                "select * "
                //                + "    `odwww`.`output_data_id`, "
                //                + "    `odwww`.`value` "
                + "from "
                + "    output_data";
//                + "where "
//                + "    od.groupe = :groupe "
//                + "and "
//                + "    od.attribute = :attribute";
        result = (List) getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                SQLQuery query = session.createSQLQuery(request);
//                query.setParameter("groupe", groupeName);
//                query.setParameter("attribute", attributeName);
                return query.list();
            }
        });
        return result;
    }

    public List<OutputData> getOutputDataByGroupeByAttribute(final String groupeValue, final String attributeValue, final int limit) {
        List<OutputData> result;
//        String[] paramNames = new String[3];
//        paramNames[0] = "groupeValue";
//        paramNames[1] = "attributeValue";
//        paramNames[2] = "limit";
//        String[] values = new String[3];
//        values[0] = groupeValue;
//        values[1] = attributeValue;
//        values[2] = limit + "";
//        System.out.println(groupeValue + "|||" + attributeValue);
//        String query = "from OutputData od where od.groupe = :groupeValue and od.attribute = :attributeValue limit :limit";
//        try {
//            outputDataList = getHibernateTemplate().findByNamedParam(query, paramNames, values);
//            return outputDataList;
//        } catch (Exception ex) {
//            return null;
//        }
        final String request = "from OutputData od where od.groupe = :groupeValue and od.attribute = :attributeValue";
        result = (List<OutputData>) getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(request);
                query.setParameter("groupeValue", groupeValue);
                query.setParameter("attributeValue", attributeValue);
                query.setMaxResults(limit);
                return query.list();
            }
        });
        return result;
    }

    public List getSessiosnIdByArticleByNativeSQL(final String article) {
        List result = null;
        final String request =
                "select distinct "
                + "    od.session_id, "
                + "    od.article "
                + "from "
                + "    output_data as od "
                + "where "
                + "      od.article like :article";
        result = (List) getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                SQLQuery query = session.createSQLQuery(request);
                query.setParameter("article", article);
//                query.setParameter("attribute", attributeName);
                return query.list();
            }
        });
        return result;
    }

    @Override
    public List getSessiosnIdByArticleWOArticleByNativeSQL(final String article) {
        List result = null;
        final String request =
                "select distinct "
                + "    od.session_id "
                + "from "
                + "    output_data as od "
                + "where "
                + "      od.article like :article";
        result = (List) getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                SQLQuery query = session.createSQLQuery(request);
                query.setParameter("article", article);
//                query.setParameter("attribute", attributeName);
                return query.list();
            }
        });
        return result;
    }

    @Override
    public List getSessiosnIdByArticleWithPTByNativeSQL(final String article) {
        List result = null;
        final String request =
                "select distinct "
                + "    od.session_id, "
                + "    od.product_type "
                + "from "
                + "    output_data as od "
                + "where "
                + "      od.article like :article";
        result = (List) getHibernateTemplate().execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                SQLQuery query = session.createSQLQuery(request);
                query.setParameter("article", article);
//                query.setParameter("attribute", attributeName);
                return query.list();
            }
        });
        return result;
    }

    public void deleteAllOutputDataAndInputDataByNativeSQL() {
        final String request =
                "delete from output_data";
        getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                SQLQuery query = session.createSQLQuery(request);
                return query.executeUpdate();
            }
        });
        final String request2 =
                "delete from input_data";
        getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                SQLQuery query = session.createSQLQuery(request2);
                return query.executeUpdate();
            }
        });
    }

    @Override
    public List<OutputData> getOutputDataByGroupeByAttribute(final String groupeValue, final String attributeValue, final long sessionId, final int limit) {
        List<OutputData> result;
        final String request = "from OutputData od where od.groupe = :groupeValue and od.attribute = :attributeValue and od.sessionId = :sessionId";
        result = (List<OutputData>) getHibernateTemplate().execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(request);
                query.setParameter("groupeValue", groupeValue);
                query.setParameter("attributeValue", attributeValue);
                query.setParameter("sessionId", sessionId);
                query.setMaxResults(limit);
                return query.list();
            }
        });
        return result;
    }

    @Override
    public List<OutputData> getOutputDataByAttrAltName(final String attributeAltName, final int limit) {
        List<OutputData> result;
        final String request = "from OutputData od where od.oldAttribute = :value";
        result = (List<OutputData>) getHibernateTemplate().execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(request);
                query.setString("value", attributeAltName);
                query.setMaxResults(limit);
                return query.list();
            }
        });
        return result;
    }

    @Override
    public List getPTBySessionIdByNativeSQL(final BigInteger sessionId) {
        List result = null;
        final String request =
                "select distinct "
                + "    od.product_type "
                + "from "
                + "    output_data as od "
                + "where "
                + "      od.session_id = :value";
        result = (List) getHibernateTemplate().execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                SQLQuery query = session.createSQLQuery(request);
                query.setBigInteger("value", sessionId);
//                query.setParameter("attribute", attributeName);
                return query.list();
            }
        });
        return result;
    }

    @Override
    public int getCountArticlesBySessionIdByNativeSQL(final BigInteger sessionId) {
        List result = null;
        final String request =
                "select count(distinct od.article)"
                + "from "
                + "    output_data as od "
                + "where "
                + "      od.session_id = :value";
        result = (List) getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                SQLQuery query = session.createSQLQuery(request);
                query.setBigInteger("value", sessionId);
//                query.setParameter("attribute", attributeName);
                return query.list();
            }
        });
        if (!result.isEmpty()) {
            return ((BigInteger) result.get(0)).intValue();
        } else {
            return 0;
        }

    }
}

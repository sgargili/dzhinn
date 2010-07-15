/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.OutputDataDAO;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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
        getHibernateTemplate().saveOrUpdate(outputData);
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
}

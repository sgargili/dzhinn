/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.InputDataDao;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.InputData;
import pojo.Shop;

/**
 *
 * @author PAV
 */
public class InputDataDaoImpl implements InputDataDao {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setSessionFactory(SessionFactory sf) {
        this.hibernateTemplate = new HibernateTemplate(sf);
    }

    @Override
    public void addInputData(InputData inputData) {
        getHibernateTemplate().save(inputData);
    }

    @Override
    public Integer addInputData(InputData inputData, boolean returnId) {
        if (returnId) {
            inputData = (InputData) getHibernateTemplate().save(inputData);
            return inputData.getId();
        } else {
            return null;
        }
    }

    @Override
    public void updateInputData(InputData inputData) {
        getHibernateTemplate().update(inputData);
    }

    @Override
    public void deleteInputData(InputData inputData) {
        getHibernateTemplate().delete(inputData);
    }

    @Override
    public void deleteInputData(int id) {
        InputData inputData = new InputData();
        inputData.setId(id);
        getHibernateTemplate().delete(inputData);
    }

    @Override
    public List<InputData> getAllInputData() {
        return getHibernateTemplate().loadAll(InputData.class);
    }

    @Override
    public List<InputData> getAllInputData(final int limit) {
        List result = null;
        final String request = "from InputData inputData";
        result = (List) getHibernateTemplate().execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(request);
                query.setMaxResults(limit);
                return query.list();
            }
        });
        return result;
    }

    @Override
    public List<InputData> getAllInputData(final int first, final int limit) {
        List result = null;
        final String request = "from InputData inputData";
        result = (List) getHibernateTemplate().execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(request);
                query.setFirstResult(first);
                query.setMaxResults(limit);
                return query.list();
            }
        });
        return result;
    }

    @Override
    public List<InputData> getAllInputDataByShop(final Shop shop) {
        List result = null;
        final String request = "from InputData inputData where inputData.shop = :shop";
        result = (List) getHibernateTemplate().execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(request);
                query.setParameter("shop", shop);
                return query.list();
            }
        });
        return result;
    }

    @Override
    public List<InputData> getAllInputDataByShop(final Shop shop, final int limit) {
        List result = null;
        final String request = "from InputData inputData where inputData.shop = :shop";
        result = (List) getHibernateTemplate().execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(request);
                query.setParameter("shop", shop);
                query.setMaxResults(limit);
                return query.list();
            }
        });
        return result;
    }

    @Override
    public List<InputData> getAllInputDataByShop(final Shop shop, final int first, final int limit) {
        List result = null;
        final String request = "from InputData inputData where inputData.shop = :shop";
        result = (List) getHibernateTemplate().execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(request);
                query.setParameter("shop", shop);
                query.setMaxResults(limit);
                query.setFirstResult(first);
                return query.list();
            }
        });
        return result;
    }
}

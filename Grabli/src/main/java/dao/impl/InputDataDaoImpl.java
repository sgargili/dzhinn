package dao.impl;

import dao.InputDataDao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pojo.InputData;
import pojo.Shop;

/**
 * @author PAV
 */
@Repository
@Service("inputDataDao")
public class InputDataDaoImpl implements InputDataDao {

    private HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }


    @Override
    public void addInputData(InputData inputData) {
        hibernateTemplate.save(inputData);
    }

    @Override
    public Integer addInputData(InputData inputData, boolean returnId) {
        if (returnId) {
            inputData = (InputData) hibernateTemplate.save(inputData);
            return inputData.getId();
        } else {
            return null;
        }
    }

    @Override
    public void updateInputData(InputData inputData) {
        hibernateTemplate.update(inputData);
    }

    @Override
    public void deleteInputData(InputData inputData) {
        hibernateTemplate.delete(inputData);
    }

    @Override
    public void deleteInputData(int id) {
        InputData inputData = new InputData();
        inputData.setId(id);
        hibernateTemplate.delete(inputData);
    }

    @Override
    public List<InputData> getAllInputData() {
        return hibernateTemplate.loadAll(InputData.class);
    }

    @Override
    public List<InputData> getAllInputData(final int limit) {
        List result = null;
        final String request = "from InputData inputData";
        result = (List) hibernateTemplate.execute(new HibernateCallback() {

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
        result = (List) hibernateTemplate.execute(new HibernateCallback() {

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
        result = (List) hibernateTemplate.execute(new HibernateCallback() {

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
        result = (List) hibernateTemplate.execute(new HibernateCallback() {

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
        result = (List) hibernateTemplate.execute(new HibernateCallback() {

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

    @Override
    public List<String> getAllArticlesByShop(final int shopId) {
        List<String> result = null;
        final String request = "select distinct input.article from input_data input where input.shop_id = :shopId";
        result = (List<String>) hibernateTemplate.execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createSQLQuery(request);
                query.setParameter("shopId", shopId);
                return query.list();
            }
        });
        return result;
    }
}

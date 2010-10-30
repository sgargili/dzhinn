package ira.dao.impl;

import ira.dao.DataDao;
import ira.entity.Data;
import org.hibernate.*;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: PAV
 * Date: 26.10.2010
 * Time: 22:55:29
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Service("dataDao")
public class DataDaoImpl implements DataDao {
    private HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public void saveData(Data data) {
        hibernateTemplate.save(data);
    }

    public void saveOrUpdate(Data data) {
        hibernateTemplate.saveOrUpdate(data);
    }

    public void deleteData(Long id) {
        Data data = new Data(id);
        hibernateTemplate.delete(data);
    }

    public void updateData(Data data) {
        hibernateTemplate.update(data);
    }

    public Data getDataById(Long id) {
        return hibernateTemplate.get(Data.class, id);

    }

    public List<Data> getAllData() {
        return hibernateTemplate.loadAll(Data.class);
    }

    public List<Data> getAllData(int start) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Data.class);
        criteria.setFirstResult(start);
        return (List<Data>) criteria.list();
    }

    public List<Data> getAllData(int start, int limit) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Data.class);
        criteria.setFirstResult(start);
        criteria.setMaxResults(limit);
        return (List<Data>) criteria.list();
    }

    public List<Data> getDataByArticle(String article) {
        return (List<Data>) hibernateTemplate.findByNamedParam("from Data data where data.article = :article", "article", article);
    }

    public List<Data> getDataByAttribute(String attribute) {
        return (List<Data>) hibernateTemplate.findByNamedParam("from Data data where data.attribute = :attribute", "attribute", attribute);
    }

    public List<String> getArticles() {
        List result = null;
        final String request =
                "select distinct data.article from data data order by data.article";

        result = (List) hibernateTemplate.execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                SQLQuery query = session.createSQLQuery(request);
                return query.list();
            }
        });
        return result;
    }
}

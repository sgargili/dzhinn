package ira.dao.impl;

import ira.dao.DataDao;
import ira.entity.Data;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
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
        return (Data) hibernateTemplate.get(Data.class, id);

    }

    public List<Data> getAllData() {
        return (List<Data>) hibernateTemplate.find("from Data");
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
}

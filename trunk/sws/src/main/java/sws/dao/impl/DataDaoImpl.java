package sws.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import sws.dao.DataDao;
import sws.model.Data;

import java.util.List;

/**
 * User: Andrey Popov
 * Date: 14.12.10
 * Time: 16:27
 */
@Repository
@Service("dataDao")
public class DataDaoImpl implements DataDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public Data addData(Data data) {
        data.setId((Long) hibernateTemplate.save(data));
        return data;
    }

    public List<Data> getDataByArticle(String article) {
        return (List<Data>) hibernateTemplate.findByNamedParam("from Data data where data.article = :article", "article", article);
    }

    public List<Data> getDataByAttribute(String attribute) {
        return (List<Data>) hibernateTemplate.findByNamedParam("from Data data where data.attribute like :attribute", "attribute", attribute);
    }
}

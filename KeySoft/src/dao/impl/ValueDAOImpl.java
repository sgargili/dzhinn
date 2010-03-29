/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.ValueDAO;
import java.util.Iterator;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import pojo.Value;

/**
 *
 * @author APopov
 */
public class ValueDAOImpl implements ValueDAO {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setSessionFactory(SessionFactory sf) {
        this.hibernateTemplate = new HibernateTemplate(sf);
    }

    public void addValue(Value value) {
        hibernateTemplate.save(value);
    }

    public void updateValue(Value value) {
        hibernateTemplate.update(value);
    }

    public void addOrUpdateValue(Value value) {
        hibernateTemplate.saveOrUpdate(value);
    }

    public void deleteValue(Value value) {
        hibernateTemplate.delete(value);
    }

    public List<Value> getAllValues() {
        SessionFactory sf = getHibernateTemplate().getSessionFactory();
        
        List<Value> outValues = (List<Value>) hibernateTemplate.loadAll(Value.class);
        //System.out.println(outValues.get(5).getProductTypes());
        Value val;
        Iterator<Value> it = outValues.iterator();
        while (it.hasNext()) {
            val = it.next();
//            val.getAttributes();
//            val.getProductTypes();
            System.out.println(val.getAttributes());
            System.out.println(val.getProductTypes());
        }
        //String query = "from Value v left join fetch v.productTypes join fetch v.attributes";

        //getHibernateTemplate().findByNamedParam(query, "name", '%' + str + '%');

        //hibernateTemplate.find(query);

        return outValues;
    }

    public List<Value> getValuesByProductTypes() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Value> getValuesByAttributes() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Value getValueById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Value> getAllValuesOnly() {
        return (List<Value>) hibernateTemplate.loadAll(Value.class);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.ValueDAO;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import pojo.Attribute;
import pojo.ProductType;
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
        getHibernateTemplate().save(value);
        getHibernateTemplate().flush();
    }

    public void updateValueDependence(Value value) {
        Value newValue;
        try {
            newValue = getValueById(value.getValueId());
        } catch (Exception ex) {
            System.out.println("Нечего обновлять... Нету такого аттрибута с Id: " + value.getValueId());
            return;
        }
        newValue.getAttributes().addAll(value.getAttributes());
        newValue.getProductTypes().addAll(value.getProductTypes());
        getHibernateTemplate().merge(newValue);
        getHibernateTemplate().flush();
    }

    public void updateValueNameOnly(Value value) {
        try {
            Value newValue;
            newValue = getValueById(value.getValueId());
            newValue.setValueName(value.getValueName());
            getHibernateTemplate().update(newValue);
        } catch (Exception ex) {
            System.out.println("Нечего обновлять... Нету такого аттрибута с Id: " + value.getValueId());
        }
        getHibernateTemplate().flush();
    }

    public void addOrUpdateValueNameOnly(Value value) {
        try {
            Value newValue;
            newValue = getValueById(value.getValueId());
            newValue.setValueName(value.getValueName());
            getHibernateTemplate().update(newValue);
        } catch (Exception ex) {
            getHibernateTemplate().save(value);
        }
        getHibernateTemplate().flush();
    }

    public void deleteValue(Value value) {
        getHibernateTemplate().delete(value);
    }

    public List<Value> getAllValuesOnly() {
        return (List<Value>) getHibernateTemplate().loadAll(Value.class);
    }

    public List<Value> getAllValuesHavingDependence() {
        String query = "from Value v "
                + "join fetch v.productTypes "
                + "join fetch v.attributes";
        return getHibernateTemplate().find(query);
    }

    public List<Value> getValuesByProductTypes() {
        String query = "from Value v "
                + "join fetch v.productTypes";
        return getHibernateTemplate().find(query);
    }

    public List<Value> getValuesByProductType(ProductType productType) {
        String query = "from Value v "
                + "join fetch v.productTypes as productType "
                + "where productType = :productType";
        return getHibernateTemplate().findByNamedParam(query, "productType", productType);
    }

    public List<Value> getValuesByAttributes() {
        String query = "from Value v "
                + "join fetch v.attributes";
        return getHibernateTemplate().find(query);
    }

    public List<Value> getValuesByAttribute(Attribute attribute) {
        String query = "from Value v "
                + "join fetch v.attributes as attribute "
                + "where attribute = :attribute";
        return getHibernateTemplate().findByNamedParam(query, "attribute", attribute);
    }

    public Value getValueById(int id) {
        return (Value) getHibernateTemplate().load(Value.class, id);
    }
}

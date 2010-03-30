/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.ProductTypeDAO;
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
public class ProductTypeDAOImpl implements ProductTypeDAO {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setSessionFactory(SessionFactory sf) {
        this.hibernateTemplate = new HibernateTemplate(sf);
    }

    public void addProductType(ProductType productType) {
        getHibernateTemplate().save(productType);
    }

    public void updatProductType(ProductType productType) {
        getHibernateTemplate().update(productType);
    }

    public void addOrUpdateProductType(ProductType productType) {
        getHibernateTemplate().saveOrUpdate(productType);
    }

    public void deleteProductType(ProductType productType) {
        getHibernateTemplate().delete(productType);
    }

    public List<ProductType> getAllProductTypesOnly() {
        return (List<ProductType>) getHibernateTemplate().loadAll(ProductType.class);
    }

    public List<ProductType> getAllProductTypesHavingDependence() {
        String query = "from ProductType p " +
                "join fetch p.values " +
                "join fetch p.attributes";
        return getHibernateTemplate().find(query);
    }

    public List<ProductType> getProductTypesByAttributes() {
        String query = "from ProductType p " +
                "join fetch p.attributes";
        return getHibernateTemplate().find(query);
    }

    public List<ProductType> getProductTypesByAttribute(Attribute attribute) {
        String query = "from ProductType p " +
                "join fetch p.attributes as attribute " +
                "where attribute = :attribute";
        return getHibernateTemplate().findByNamedParam(query, "attribute", attribute);
    }

    public List<ProductType> getProductTypesByValues() {
        String query = "from ProductType p " +
                "join fetch p.values";
        return getHibernateTemplate().find(query);
    }

    public List<ProductType> getProductTypesByValue(Value value) {
        String query = "from ProductType p " +
                "join fetch p.values as value " +
                "where value = :value";
        return getHibernateTemplate().findByNamedParam(query, "value", value);
    }

    public ProductType getProductTypeById(int id) {
        return (ProductType) getHibernateTemplate().load(ProductType.class, id);
    }
}

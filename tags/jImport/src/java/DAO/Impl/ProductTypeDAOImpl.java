/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import DAO.ProductTypeDAO;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import Pojo.Attribute;
import Pojo.ProductType;

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
        getHibernateTemplate().persist(productType);
    }

    public void updateProductTypeNameOnly(ProductType productType) {
        try {
            ProductType newProductType;
            newProductType = getProductTypeById(productType.getProductTypeId());
            newProductType.setProductTypeName(productType.getProductTypeName());
            getHibernateTemplate().update(newProductType);
        } catch (Exception ex) {
            System.out.println("Нечего обновлять... Нету такого аттрибута с Id: " + productType.getProductTypeId());
        }
    }

    public void addOrUpdateProductTypeNameOnly(ProductType productType) {
        getHibernateTemplate().saveOrUpdate(productType);
//        try {
//            ProductType newProductType;
//            newProductType = getProductTypeById(productType.getProductTypeId());
//            newProductType.setProductTypeName(productType.getProductTypeName());
//            getHibernateTemplate().update(newProductType);
//        } catch (Exception ex) {
//            getHibernateTemplate().save(productType);
//        }
//        getHibernateTemplate().flush();
    }

    public void deleteProductType(ProductType productType) {
        getHibernateTemplate().delete(productType);
    }

    public List<ProductType> getAllProductTypesOnly() {
        return (List<ProductType>) getHibernateTemplate().loadAll(ProductType.class);
    }

    public List<ProductType> getProductTypesByAttributes() {
        String query = "from ProductType p " + "join fetch p.attributes";
        return getHibernateTemplate().find(query);
    }

    public List<ProductType> getProductTypesByAttribute(Attribute attribute) {
        String query = "from ProductType p " + "join fetch p.attributes as attribute " + "where attribute = :attribute";
        return getHibernateTemplate().findByNamedParam(query, "attribute", attribute);
    }

    @Override
    public ProductType getProductTypeById(int id) {
        ProductType pt;
        pt = (ProductType) getHibernateTemplate().load(ProductType.class, id);
        //pt.getAttributes().isEmpty();
        return pt;
    }

    public ProductType getProductTypeByIdWithAttributes(int id) {
        ProductType pt;
        pt = (ProductType) getHibernateTemplate().load(ProductType.class, id);
        pt.getAttributes().isEmpty();
        return pt;
    }

    public void updatProductTypeWithAttributes(ProductType productType) {
        ProductType newProductType;
        try {
            newProductType = getProductTypeById(productType.getProductTypeId());
        } catch (Exception ex) {
            System.out.println("Нечего обновлять... Нету такого аттрибута с Id: " + productType.getProductTypeId());
            return;
        }
        newProductType.getAttributes().addAll(productType.getAttributes());
        getHibernateTemplate().merge(newProductType);
        getHibernateTemplate().flush();
        getHibernateTemplate().update(productType);
    }

    @Override
    public boolean isProductTypePresent(String productTypeName) {
        String query = "from ProductType p where productTypeName = :value";
        try {
            return !getHibernateTemplate().findByNamedParam(query, "value", productTypeName).isEmpty();
        } catch (Exception ex) {
            return false;
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.ProductTypeDAO;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import pojo.Attribute;
import pojo.ProductType;

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
        getHibernateTemplate().saveOrUpdate(productType);
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
        // getHibernateTemplate().saveOrUpdate(productType);
        try {
            ProductType newProductType;
            newProductType = getProductTypeByName(productType.getProductTypeName());
            newProductType.setProductTypeAlternative(productType.getProductTypeAlternative());
            getHibernateTemplate().update(newProductType);
        } catch (Exception ex) {
            // ex.printStackTrace();
            getHibernateTemplate().save(productType);
        }
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
        try {
            pt.getProductTypeAlternative().equals("");
        } catch (NullPointerException ex) {
            pt.setProductTypeAlternative("");
        }
        //pt.getAttributes().isEmpty();
        return pt;
    }

    public ProductType getProductTypeByIdWithAttributes(int id) {
        ProductType pt;
        pt = (ProductType) getHibernateTemplate().load(ProductType.class, id);
        pt.getAttributes().isEmpty();
        return pt;
    }

    public ProductType getProductTypeByIdWithGroupes(int id) {
        ProductType pt;
        pt = (ProductType) getHibernateTemplate().load(ProductType.class, id);
        pt.getGroupes().isEmpty();
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

    public void updateProductTypeAltNameOnly(ProductType productType) {
        try {
            ProductType newProductType;
            newProductType = getProductTypeById(productType.getProductTypeId());
            newProductType.setProductTypeAlternative(productType.getProductTypeAlternative());
            getHibernateTemplate().update(newProductType);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Нечего обновлять... Нету такого аттрибута с Id: " + productType.getProductTypeId());
        }
    }

    public ProductType getProductTypeByName(String productTypeName) {
        String query = "from ProductType p where productTypeName = :value";
        try {
            return (ProductType) getHibernateTemplate().findByNamedParam(query, "value", productTypeName).get(0);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<ProductType> getProductTypeOnlyByTemplate(String template) {
        template = "%" + template + "%";
        String query = "from ProductType p where productTypeName like :value";
        System.out.println(template);
        try {
            return getHibernateTemplate().findByNamedParam(query, "value", template);
        } catch (Exception ex) {
            return null;
        }
    }

    public List getProductTypeWithGroupesByNativeSQL() {
        List result = null;
        final String request =
                "select "
                + "    pt.product_type_name, "
                + "    groupe.groupe_name "
                + "from  "
                + "    product_type as pt "
                + "inner join "
                + "    groupe as groupe "
                + "inner join "
                + "    pt2groupe as p2g "
                + "on "
                + "    pt.product_type_id = p2g.product_type_id "
                + "    and "
                + "    groupe.groupe_id = p2g.groupe_id "
                + "order by "
                + "    pt.product_type_name";

        result = (List) getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                SQLQuery query = session.createSQLQuery(request);
                return query.list();
            }
        });
        return result;
    }

    public List getProductTypeWithGroupesWithAttributesByNativeSQL() {
        List result = null;
        final String request =
                "select "
                + "    pt.product_type_name, "
                + "    groupe.groupe_name, "
                + "    attribute.attribute_name "
                + "from  "
                + "    product_type as pt "
                + "inner join "
                + "    groupe as groupe "
                + "inner join "
                + "    attribute as attribute "
                + "inner join "
                + "    pt2groupe as p2g "
                + "on "
                + "    pt.product_type_id = p2g.product_type_id "
                + "    and "
                + "    groupe.groupe_id = p2g.groupe_id "
                + "inner join "
                + "    groupe2atr as g2a "
                + "on "
                + "    groupe.groupe_id = g2a.groupe_id "
                + "    and "
                + "    attribute.attribute_id = g2a.attribute_id "
                + "order by "
                + "    pt.product_type_name";

        result = (List) getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                SQLQuery query = session.createSQLQuery(request);
                return query.list();
            }
        });
        return result;
    }
}

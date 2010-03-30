/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojo.Attribute;
import pojo.ProductType;
import pojo.Value;

/**
 *
 * @author APopov
 */
public interface ProductTypeDAO {

    public void addProductType(ProductType productType);

    public void updatProductType(ProductType productType);

    public void addOrUpdateProductType(ProductType productType);

    public void deleteProductType(ProductType productType);

    public List<ProductType> getAllProductTypesOnly();

    public List<ProductType> getAllProductTypesHavingDependence();

    public List<ProductType> getProductTypesByAttributes();

    public List<ProductType> getProductTypesByAttribute(Attribute attribute);

    public List<ProductType> getProductTypesByValues();

    public List<ProductType> getProductTypesByValue(Value value);

    public ProductType getProductTypeById(int id);
}

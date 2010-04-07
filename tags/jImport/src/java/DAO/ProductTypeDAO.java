/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import Pojo.Attribute;
import Pojo.ProductType;

/**
 *
 * @author APopov
 */
public interface ProductTypeDAO {

    public void addProductType(ProductType productType);

    public void updatProductTypeWithAttributes(ProductType productType);

    public void updateProductTypeNameOnly(ProductType productType);

    public void addOrUpdateProductTypeNameOnly(ProductType productType);

    public void deleteProductType(ProductType productType);

    public boolean isProductTypePresent(String productTypeName);

    public List<ProductType> getAllProductTypesOnly();

    public List<ProductType> getProductTypesByAttributes();

    public List<ProductType> getProductTypesByAttribute(Attribute attribute);

    public ProductType getProductTypeById(int id);

    public ProductType getProductTypeByIdWithAttributes(int id);
}

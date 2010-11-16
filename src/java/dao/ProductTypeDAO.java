/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojo.Attribute;
import pojo.ProductType;

/**
 *
 * @author APopov
 */
public interface ProductTypeDAO {

    public void addProductType(ProductType productType);

    public void updatProductTypeWithAttributes(ProductType productType);

    public void updateProductTypeNameOnly(ProductType productType);

    public void updateProductTypeAltNameOnly(ProductType productType);

    public void addOrUpdateProductTypeNameOnly(ProductType productType);

    public void deleteProductType(ProductType productType);

    public boolean isProductTypePresent(String productTypeName);

    public List<ProductType> getAllProductTypesOnly();

    public List<ProductType> getProductTypesByAttributes();

    public List<ProductType> getProductTypesByAttribute(Attribute attribute);

    public List<ProductType> getProductTypeOnlyByTemplate(String template);

    public List getProductTypeWithGroupesByNativeSQL();

    public List getProductTypeWithGroupesWithAttributesByNativeSQL();

    public List getProductTypeWithGroupesWithAttributesByIdByNativeSQL(final int productTypeId);

    public List getProductTypeWithGroupesWithAttributesWithCompositWithRegexpByIdByNativeSQL(final int productTypeId);

    public List getProductTypeWithGroupesWithAttributesWithCompositWithRegexpByIdByGroupeByAttributeByNativeSQL(final int productTypeId, final int groupeId, final int attributeId);

    public ProductType getProductTypeById(int id);

    public ProductType getProductTypeByName(String productTypeName);

    public ProductType getProductTypeByIdWithAttributes(int id);

    public ProductType getProductTypeByIdWithGroupes(int id);
}

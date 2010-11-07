/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Attribute;
import Pojo.ProductType;
import java.util.List;

/**
 *
 * @author APopov
 */
public interface AttributeDAO {

    public void addAttribute(Attribute attribute);

    public List<Attribute> getAllAttributesOnly();

    public List<Attribute> getAttributesOnlyByProductTypeId(ProductType productType);

    public Attribute getAttributeByName(String name);

    public boolean isAttributePresent(Attribute attribute);
}
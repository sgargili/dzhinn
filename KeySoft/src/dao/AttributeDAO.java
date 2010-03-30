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
public interface AttributeDAO {

    public void addAttribute(Attribute attribute);

    public void updateAttributeDependence(Attribute attribute);

    public void updateAttributeNameOnly(Attribute attribute);

    public void addOrUpdateAttributeNameOnly(Attribute attribute);

    public void deleteAttribute(Attribute attribute);

    public List<Attribute> getAllAttributesOnly();

    public List<Attribute> getAllAttributesHavingDependence();

    public List<Attribute> getAttributesByProductTypes();

    public List<Attribute> getAttributesByProductType(ProductType productType);

    public List<Attribute> getAttributesByValues();

    public List<Attribute> getAttributesByValue(Value value);

    public Attribute getAttributeById(int id);
}

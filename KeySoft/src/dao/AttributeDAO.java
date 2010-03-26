/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.util.Set;
import pojo.Attribute;
import pojo.ProductType;
import pojo.Value;

/**
 *
 * @author APopov
 */
public interface AttributeDAO {

    public void addAttribute(Attribute attribute);

    public Attribute getAttributeById(int id);

    public List<Attribute> getAllAttributes();

    public Set<ProductType> getAllProductTypesByAttribute(Attribute attribute);

    public Set<Value> getAllValuesByAttribute(Attribute attribute);
}

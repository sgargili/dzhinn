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
public interface ValueDAO {

    public void addValue(Value value);

    public void updateValueDependence(Value value);

    public void updateValueNameOnly(Value value);

    public void addOrUpdateValueNameOnly(Value value);

    public void deleteValue(Value value);

    public List<Value> getAllValuesOnly();

    public List<Value> getAllValuesHavingDependence();

    public List<Value> getValuesByProductTypes();

    public List<Value> getValuesByProductType(ProductType productType);

    public List<Value> getValuesByAttributes();

    public List<Value> getValuesByAttribute(Attribute attribute);

    public Value getValueById(int id);
}

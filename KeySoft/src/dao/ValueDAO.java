/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojo.Value;

/**
 *
 * @author APopov
 */
public interface ValueDAO {

    public void addValue(Value value);

    public void updateValue(Value value);

    public void addOrUpdateValue(Value value);

    public void deleteValue(Value value);

    public List<Value> getAllValuesOnly();

    public List<Value> getAllValues();

    public List<Value> getValuesByProductTypes();

    public List<Value> getValuesByAttributes();

    public Value getValueById(int id);
}

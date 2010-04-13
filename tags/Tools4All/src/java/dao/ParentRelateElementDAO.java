/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojo.ParentRelateElement;

/**
 *
 * @author APopov
 */
public interface ParentRelateElementDAO {

    public void addParentRelateElement(ParentRelateElement prElement);

    public void updateParentRelateElement(ParentRelateElement prElement);

    public void deleteParentRelateElement(ParentRelateElement prElement);

    public List<ParentRelateElement> getAllParentRelateElements();

    public List<ParentRelateElement> getAllParentRelateElementsByType(Byte type);

    public List<ParentRelateElement> getAllParentRelateElementsByType(String type);
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import pojo.AttributeAlternativeName;

/**
 *
 * @author APopov
 */
public interface AttributeAlternativeNameDAO {

    public void addAttributeAlternativeName(AttributeAlternativeName attributeAlternativeName);

    public boolean isAttributeAlternativeNamePresent(AttributeAlternativeName attributeAlternativeName);

    public boolean isAttributeAlternativeNamePresent(String attributeAlternativeNameValue);
}

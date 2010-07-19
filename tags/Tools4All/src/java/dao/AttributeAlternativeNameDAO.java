/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import pojo.Attribute;
import pojo.AttributeAlternativeName;

/**
 *
 * @author APopov
 */
public interface AttributeAlternativeNameDAO {

    public void addAttributeAlternativeName(AttributeAlternativeName attributeAlternativeName);

    public void deleteAttributeAlternativeName(AttributeAlternativeName attributeAlternativeName);

    public void deleteAttributeAlternativeNameByAttribute(Attribute attribute);

    public boolean isAttributeAlternativeNamePresent(AttributeAlternativeName attributeAlternativeName);

    public boolean isAttributeAlternativeNamePresentByAttributeId(AttributeAlternativeName attributeAlternativeName);

    public boolean isAttributeAlternativeNamePresent(String attributeAlternativeNameValue);
}

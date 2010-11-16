/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojo.Attribute;
import pojo.AttributeAlternativeName;

/**
 *
 * @author APopov
 */
public interface AttributeAlternativeNameDAO {

    public void addAttributeAlternativeName(AttributeAlternativeName attributeAlternativeName);

    public List getAttributeAlternativeNameByAttributeByGroupe(int attributeId, int groupeId);

    public AttributeAlternativeName getAttributeAlternativeNameByAttributeByGroupeByName(int attributeId, int groupeId, String altName);

    public void updateRegexpElabType(int atrId);

    public AttributeAlternativeName getAttributeAlternativeNameById(int id);

    public int getAttributeAlternativeIdByNameByAttributeIdByNativeSQL(String altName, int atrId);

    public void deleteAttributeAlternativeName(AttributeAlternativeName attributeAlternativeName);

    public void deleteAttributeAlternativeNameByAttribute(Attribute attribute);

    public boolean isAttributeAlternativeNamePresent(AttributeAlternativeName attributeAlternativeName);

    public boolean isAttributeAlternativeNamePresentByAttributeId(AttributeAlternativeName attributeAlternativeName);

    public boolean isAttributeAlternativeNamePresent(String attributeAlternativeNameValue);
}

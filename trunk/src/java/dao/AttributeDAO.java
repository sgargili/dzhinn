/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import pojo.Attribute;
import pojo.ProductType;
import java.util.List;
import pojo.Groupe;

/**
 *
 * @author APopov
 */
public interface AttributeDAO {

    public void addAttribute(Attribute attribute);

    public void addComposite(int atrId, int groupeId);

    public void updateCompositeOnly(int atrId, int groupeId);

    public void updateCompositeRegexpElabType(int atrId, int groupeId);
    

    public void deleteComposite(int atrId, int groupeId);

    public boolean isCompositePresent(int atrId, int groupeId);

    public void addOrUpdateAttributeNameOnly(Attribute attribute);

    public void updateAttributeAltNameOnly(Attribute attribute);

    public void deleteAttribute(Attribute attribute);

    public List<Attribute> getAllAttributesOnly();

    public List<Attribute> getAllAttributesWithAltNames();

    public List<Attribute> getAllAttributesWithRegexps();

    public List<Attribute> getAttributesOnlyByProductType(ProductType productType);

    public List<Attribute> getAttributesOnlyByGroupe(Groupe groupe);

    public List<Attribute> getAttributesWithAltNamesByProductType(ProductType productType);

    public List<Attribute> getAttributesOnlyByProductTypeId(int id);

    public List<Attribute> getAttributesOnlyByProductTypeIdByNativeSQL(int id);

    public List<Attribute> getAttributesOnlyByGroupeId(int id);

    public List getAttributesWithCompositByGroupeIdByNatveSQL(int id);

    public List<Attribute> getAttributesOnlyByTemplate(String template);

    public Attribute getAttributeById(int id);

    public Attribute getAttributeByName(String name);

    public boolean isAttributePresent(Attribute attribute);

    public boolean isAttributePresent(String attributeName);
}

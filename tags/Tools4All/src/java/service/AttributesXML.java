/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.thoughtworks.xstream.XStream;
import factories.FactoryDAO4Grabli;
import java.util.ArrayList;
import java.util.List;
import pojo.Attribute;
import pojo.Groupe;
import pojo.ProductType;

/**
 *
 * @author APopov
 */
public class AttributesXML {

    FactoryDAO4Grabli fd = FactoryDAO4Grabli.getInstance();
    XStream xstream = new XStream();
    List attributeList = new ArrayList();
    long id;
    String xml;

    private void initXstream() {
        xstream.alias("Attributes", List.class);
        xstream.alias("Attribute", Attribute.class);
        xstream.aliasField("Id", Attribute.class, "attributeId");
        xstream.aliasField("Name", Attribute.class, "attributeName");
        xstream.aliasField("AltName", Attribute.class, "attributeAlternative");
        xstream.omitField(Attribute.class, "values");
        xstream.omitField(Attribute.class, "attributeAlternativeNames");
        xstream.omitField(Attribute.class, "productTypes");
         xstream.omitField(Attribute.class, "groupes");

    }

    public String getAllAttributes() {
        attributeList = fd.getAttributeDAO().getAllAttributesOnly();
        initXstream();
        xml = xstream.toXML(attributeList);
        return xml;
    }

    public String getAttributesByPtId(int ptId) {
        attributeList = fd.getAttributeDAO().getAttributesOnlyByProductTypeId(ptId);
        initXstream();
        xml = xstream.toXML(attributeList);
        return xml;
    }

    public String getAttributesByPtName(String ptName) {
        ProductType pt = fd.getProductTypeDAO().getProductTypeByName(ptName);
        attributeList = fd.getAttributeDAO().getAttributesOnlyByProductTypeId(pt.getProductTypeId());
        initXstream();
        xml = xstream.toXML(attributeList);
        return xml;
    }

    public String getAttributesByGroupeId(int groupeId) {
        attributeList = fd.getAttributeDAO().getAttributesOnlyByGroupeId(groupeId);
        initXstream();
        xml = xstream.toXML(attributeList);
        return xml;
    }

    public String getAttributesByGroupeName(String groupeName) {
        Groupe groupe = fd.getGroupeDAO().getGroupeByName(groupeName);
        attributeList = fd.getAttributeDAO().getAttributesOnlyByGroupeId(groupe.getGroupeId());
        initXstream();
        xml = xstream.toXML(attributeList);
        return xml;
    }
}

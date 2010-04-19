/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.thoughtworks.xstream.XStream;
import convertors.XmlConvertor4AtrAlt;
import factories.FactoryDAO4Grabli;
import pojo.Attribute;

/**
 *
 * @author APopov
 */
public class NewClass4 {

    public static void main(String[] arg) {
        Attribute atr = FactoryDAO4Grabli.getInstance().getAttributeDAO().getAttributeById(266);
        System.out.println(atr.getAttributeAlternativeNames().size());
        XStream xstream = new XStream();
        xstream.alias("Attribute", Attribute.class);
        // xstream.alias("Name", String.class);
        //xstream.addImplicitCollection(AttributeAlternativeName.class, "attributeAltName");
        //xstream.aliasField("Id", AttributeAlternativeName.class, "attributeId");
        xstream.registerConverter(new XmlConvertor4AtrAlt());
        String xml;
        try {
                xml = xstream.toXML(atr);


                System.out.println(xml);

        } catch (Exception ex) {

            System.out.println(ex);
        }
    }
}

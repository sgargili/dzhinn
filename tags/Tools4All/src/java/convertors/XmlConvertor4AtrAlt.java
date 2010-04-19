/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package convertors;

import pojo.Attribute;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import java.util.Iterator;
import pojo.AttributeAlternativeName;

/**
 *
 * @author APopov
 */
public class XmlConvertor4AtrAlt implements Converter {

    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
        Attribute atr = (Attribute) o;
        AttributeAlternativeName atrAlt;
        Iterator it = atr.getAttributeAlternativeNames().iterator();

        while (it.hasNext()) {
            atrAlt = (AttributeAlternativeName) it.next();
            writer.startNode("AltName");
            try {
                writer.startNode("Id");
                if (atrAlt.getAttributeAlernativeNameId() == null) {
                    writer.setValue("");
                } else {
                    writer.setValue(atrAlt.getAttributeAlernativeNameId() + "");
                }
                writer.endNode();

                writer.startNode("Name");
                if (atrAlt.getAttributeAlernativeNameValue() == null) {
                    writer.setValue("");
                } else {
                    writer.setValue(atrAlt.getAttributeAlernativeNameValue());
                }
                writer.endNode();

            } catch (Exception ex) {
            }
            writer.endNode();
        }

    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext uc) {
        Attribute atr = new Attribute();
        reader.moveDown();
        atr.setAttributeName(reader.getValue());
        reader.moveUp();
        return atr;
    }

    public boolean canConvert(Class clazz) {
        return clazz.equals(Attribute.class);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package convertors;

import Pojo.Attribute;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import Pojo.ProductType;

/**
 *
 * @author Apopov
 */
public class XmlConvertor4Attributes implements Converter {

    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
        Attribute atr = (Attribute) o;
        try {
            writer.startNode("Id");
            if (atr.getAttributeId() == null) {
                writer.setValue("");
            } else {
                writer.setValue(atr.getAttributeId() + "");
            }
            writer.endNode();

            writer.startNode("Name");
            if (atr.getAttributeName() == null) {
                writer.setValue("");
            } else {
                writer.setValue(atr.getAttributeName());
            }
            writer.endNode();
            writer.startNode("altName");
            if (atr.getAttributeAlternative() == null) {
                writer.setValue("");
            } else {
                writer.setValue(atr.getAttributeAlternative());
            }
            writer.endNode();

        } catch (Exception ex) {
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
        return clazz.equals(ProductType.class);
    }
}

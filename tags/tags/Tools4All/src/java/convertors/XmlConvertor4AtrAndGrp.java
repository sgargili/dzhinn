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
import java.util.List;

/**
 *
 * @author popov
 */
public class XmlConvertor4AtrAndGrp implements Converter {

    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
        List atrs = (List) o;
        Iterator it = atrs.iterator();
        Object[] obj;
        while (it.hasNext()) {
            obj = (Object[]) it.next();
            writer.startNode("Attribute");
            try {
                writer.startNode("Id");
                if (obj[0] == null) {
                    writer.setValue("");
                } else {
                    writer.setValue(obj[0] + "");
                }
                writer.endNode();

                writer.startNode("Name");
                if (obj[1] == null) {
                    writer.setValue("");
                } else {
                    writer.setValue(obj[1] + "");
                }
                writer.endNode();

                writer.startNode("Groupe");
                if (obj[2] == null) {
                    writer.setValue("");
                } else {
                    writer.setValue(obj[2] + "");
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
        return true;
    }
}

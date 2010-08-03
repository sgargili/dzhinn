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
import pojo.AttributeAlternativeName;

/**
 *
 * @author APOPOV
 */
public class XmlConvertor4Art2Composite implements Converter {

    @Override
    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
        List atrs = (List) o;
        Iterator it = atrs.iterator();
        Object[] obj;
        while (it.hasNext()) {
            obj = (Object[]) it.next();
            writer.startNode("Attribute");
            try {
                writer.startNode("Id");
                writer.setValue(obj[0] + "");
                writer.endNode();

                writer.startNode("Name");
                try {
                    if ((Boolean) obj[2]) {
                        writer.setValue(obj[1] + "<b><font color=\"#ff6600\"> : Composite</font></b>");
                    } else {
                        writer.setValue(obj[1] + "");
                    }
                } catch (Exception ex) {
                    writer.setValue(obj[1] + "");
                }
                writer.endNode();
            } catch (Exception ex) {
            }
            writer.endNode();
        }

    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext uc) {
        Attribute atr = new Attribute();
        reader.moveDown();
        atr.setAttributeName(reader.getValue());
        reader.moveUp();
        return atr;
    }

    @Override
    public boolean canConvert(Class clazz) {
        return true;
    }
}

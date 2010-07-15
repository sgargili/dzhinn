/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package convertors;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import java.util.Iterator;
import java.util.List;
import pojo.Attribute;
import pojo.Regexp;

/**
 *
 * @author APOPOV
 */
public class XmlConvertor4Regexp implements Converter {

    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
//        Attribute atr = (Attribute) o;
//        List<Regexp> regs = atr.getRegexps();
        List out = (List) o;
        Object[] reg;
        Iterator it = out.iterator();
        while (it.hasNext()) {
            reg = (Object[]) it.next();
            writer.startNode("Regexp");
            try {
                writer.startNode("Id");
                writer.setValue((String) reg[0]);
                writer.endNode();

                writer.startNode("Name");
                writer.setValue("Type: <b>"
                        + (String) reg[1]
                        + "</b> Pattern: <b>"
                        + (String) reg[2]
                        + "</b> Replacement: <b>"
                        + (String) reg[3]
                        + "</b>");
                writer.endNode();

            } catch (Exception ex) {
            }
            writer.endNode();
        }
    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext uc) {
        Regexp reg = new Regexp();
        reader.moveDown();
        reg.setRegexpPattern(reader.getValue());
        reader.moveUp();
        return reg;
    }

    public boolean canConvert(Class type) {
        return type.equals(Attribute.class);
    }
}

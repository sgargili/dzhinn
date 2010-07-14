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
        Attribute atr = (Attribute) o;
        List<Regexp> regs = atr.getRegexps();
        Regexp reg;
        Iterator it = regs.iterator();
        while (it.hasNext()) {
            reg = (Regexp) it.next();
            writer.startNode("Regexp");
            try {
                writer.startNode("Id");
                writer.setValue(reg.getRegexpId().toString());
                writer.endNode();

                writer.startNode("Name");
                writer.setValue("Type: <b>"
                        + reg.getRegexpType()
                        + "</b> Pattern: <b>"
                        + reg.getRegexpPattern()
                        + "</b> Replacement: <b>"
                        + reg.getRegexpReplacement()
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

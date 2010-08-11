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
import pojo.Groupe;

/**
 *
 * @author APOPOV
 */
public class XmlConvertor4Groupes implements Converter {

    @Override
    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
        List groupes = (List) o;
        Groupe groupe;
        Iterator it = groupes.iterator();

        while (it.hasNext()) {
            groupe = (Groupe) it.next();
            writer.startNode("Groupe");
            try {
                writer.startNode("Id");
                if (groupe.getGroupeId() == null) {
                    writer.setValue("");
                } else {
                    writer.setValue(groupe.getGroupeId() + "");
                }
                writer.endNode();

                writer.startNode("Name");
                if (groupe.getGroupeName() == null) {
                    writer.setValue("");
                } else {
                    if (groupe.getGroupeComment() != null && !groupe.getGroupeComment().equals("")) {
                        writer.setValue(groupe.getGroupeName() + " (" + groupe.getGroupeComment() + ")");
                    } else {
                        writer.setValue(groupe.getGroupeName());
                    }
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

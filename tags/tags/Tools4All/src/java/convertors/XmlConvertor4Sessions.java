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
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author APOPOV
 */
public class XmlConvertor4Sessions implements Converter {

    @Override
    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
        List<String[]> out = (List<String[]>) o;
        String[] str;
        Iterator it = out.iterator();

        while (it.hasNext()) {
            str = (String[]) it.next();
            try {
                writer.startNode("Session");

                writer.startNode("SessionId");
                if (str[0] == null) {
                    writer.setValue("");
                } else {
                    writer.setValue((String) str[0]);
                }
                writer.endNode();

                writer.startNode("PT");
                if (str[1] == null) {
                    writer.setValue("");
                } else {
                    writer.setValue((String) str[1]);
                }
                writer.endNode();

                 writer.startNode("ArtCount");
                if (str[2] == null) {
                    writer.setValue("");
                } else {
                    writer.setValue((String) str[2]);
                }
                writer.endNode();

                writer.endNode();

            } catch (Exception ex) {
            }
        }
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext uc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean canConvert(Class type) {
        return true;
    }
}

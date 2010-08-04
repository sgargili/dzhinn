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
import pojo.OutputData;

/**
 *
 * @author APOPOV
 */
public class XmlConvertor4OutputData implements Converter {

    @Override
    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
        List<OutputData> out = (List<OutputData>) o;
        Iterator<OutputData> iter = out.iterator();
        OutputData od;
        while (iter.hasNext()) {
            od = iter.next();
            try {
                writer.startNode("Article");

                writer.startNode("Id");
                if (od.getOutputDataId() == null) {
                    writer.setValue("");
                } else {
                    writer.setValue(od.getOutputDataId() + "");
                }
                writer.endNode();

                writer.startNode("Sid");
                if (od.getSessionId() == null) {
                    writer.setValue("");
                } else {
                    writer.setValue(od.getSessionId() + "");
                }
                writer.endNode();

                writer.startNode("Name");
                if (od.getArticle() == null) {
                    writer.setValue("");
                } else {
                    writer.setValue(od.getArticle());
                }
                writer.endNode();

                writer.startNode("PT");
                if (od.getProductType() == null) {
                    writer.setValue("");
                } else {
                    writer.setValue(od.getProductType());
                }
                writer.endNode();

                writer.startNode("Groupe");
                if (od.getGroupe() == null) {
                    writer.setValue("");
                } else {
                    writer.setValue(od.getGroupe());
                }
                writer.endNode();

                writer.startNode("Attribute");
                if (od.getAttribute() == null) {
                    writer.setValue("");
                } else {
                    writer.setValue(od.getAttribute());
                }
                writer.endNode();

                writer.startNode("composite");
                if (od.getComposite() == null || od.getComposite() == 0) {
                    writer.setValue("");
                } else {
                    writer.setValue(od.getComposite() + "");
                }
                writer.endNode();

                writer.startNode("Value");
                if (od.getValue() == null) {
                    writer.setValue("");
                } else {
                    writer.setValue(od.getValue());
                }
                writer.endNode();

                writer.startNode("Unit");
                if (od.getUnit() == null) {
                    writer.setValue("");
                } else {
                    writer.setValue(od.getUnit());
                }
                writer.endNode();

                writer.startNode("Available");
                if (od.getAvailable() == null) {
                    writer.setValue("");
                } else {
                    writer.setValue(od.getAvailable() + "");
                }
                writer.endNode();

                writer.startNode("oldAttribute");
                if (od.getOldAttribute() == null) {
                    writer.setValue("");
                } else {
                    writer.setValue(od.getOldAttribute());
                }
                writer.endNode();

                 writer.startNode("weight");
                if (od.getWeight() == null) {
                    writer.setValue("");
                } else {
                    writer.setValue(od.getWeight()+"");
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

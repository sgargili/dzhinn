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
import Pojo.ProductType;

/**
 *
 * @author Apopov
 */
public class XmlConvertor4PT implements Converter {

    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
        ProductType pt = (ProductType) o;
        try {

            writer.startNode("Id");
            if (pt.getProductTypeId() == null) {
                writer.setValue("");
            } else {
                writer.setValue(pt.getProductTypeId() + "");
            }
            writer.endNode();

            writer.startNode("Name");
            if (pt.getProductTypeName() == null) {
                writer.setValue("");
            } else {
                writer.setValue(pt.getProductTypeName());
            }
            writer.endNode();
            writer.startNode("altName");
            if (pt.getProductTypeAlternative() == null) {
                writer.setValue("");
            } else {
                writer.setValue(pt.getProductTypeAlternative());
            }
            writer.endNode();

        } catch (Exception ex) {
        }
    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext uc) {
        ProductType pt = new ProductType();
        reader.moveDown();
        pt.setProductTypeName(reader.getValue());
        reader.moveUp();
        return pt;
    }

    public boolean canConvert(Class clazz) {
        return clazz.equals(ProductType.class);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package marketing;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import pojo.Soft;

/**
 *
 * @author Apopov
 */
public class xmlConvertor implements Converter {

    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
        Soft soft = (Soft) o;
        try {
            writer.addAttribute("id", soft.getKeyArticle() + "");
            writer.setValue(soft.getDescriptions()//
                    .replaceAll("\n", "")//
                    //.replaceAll("", null)
                    );
        } catch (Exception ex) {
            soft.getKeyArticle();
        }
    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext uc) {
        Soft soft = new Soft();
        reader.moveDown();
        soft.setKeyArticle(Integer.parseInt(reader.getValue()));
        reader.moveUp();
        return soft;
    }

    public boolean canConvert(Class clazz) {
        return clazz.equals(Soft.class);
    }
}

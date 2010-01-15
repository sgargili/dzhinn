/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gkey;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import pojo.Keymarketing;

/**
 *
 * @author Apopov
 */
public class xmlConvertor implements Converter {

    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
        Keymarketing km = (Keymarketing) o;
        try {
            writer.addAttribute("id", km.getKeyarticle());
            writer.setValue(km.getKeymarketing());
        } catch (Exception ex) {
            km.getKeyarticle();
        }
    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext uc) {
        Keymarketing km = new Keymarketing();
        reader.moveDown();
        km.setKeyarticle(reader.getValue());
        reader.moveUp();
        return km;
    }

    public boolean canConvert(Class clazz) {
        return clazz.equals(Keymarketing.class);
    }
}

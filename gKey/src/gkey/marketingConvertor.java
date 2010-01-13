/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gkey;

import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import pojo.Keymarketing;

/**
 *
 * @author Apopov
 */
public class marketingConvertor extends AbstractSingleValueConverter {

    @Override
    public boolean canConvert(Class type) {
        return type.equals(Keymarketing.class);
    }

    @Override
    public Object fromString(String string) {
        Keymarketing km = new Keymarketing();
        km.setKeymarketing(string);
        return km;
    }
}

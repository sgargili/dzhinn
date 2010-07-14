/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.thoughtworks.xstream.XStream;
import convertors.XmlConvertor4Regexp;
import factories.FactoryDAO4Grabli;
import java.util.ArrayList;
import java.util.List;
import pojo.Attribute;

/**
 *
 * @author APOPOV
 */
public class RegExpXML {

    FactoryDAO4Grabli fd = FactoryDAO4Grabli.getInstance();
    XStream xstream = new XStream();
    List regexpList = new ArrayList();
    long id;
    String xml;

    private void initXstream() {
        xstream.alias("Regexps", Attribute.class);

    }

    public String getAllRegexps() {
//        regexpList = fd.getRegexpDAO().getAllAttributesOnly();
//        initXstream();
//        xml = xstream.toXML(regexpList);
        return xml;
    }

    public String getRegexpsByAttributeId(int atrId) {
        Attribute atr = fd.getAttributeDAO().getAttributeById(atrId);
        //regexpList = fd.getRegexpDAO().getRegexpsByAttribute(atr);
        initXstream();
        xstream.registerConverter(new XmlConvertor4Regexp());
        xml = xstream.toXML(atr);
        return xml;
    }

    public String[] split(String regexpPattern, String regexpValue) {
        String[] outValues = regexpValue.split(regexpPattern);
        return outValues;
    }

    public String replace(String regexpPattern, String regexpValue, String replacement) {
        String outValue = regexpValue.replace(regexpPattern, replacement);
        return outValue;
    }

    public String replaceAll(String regexpPattern, String regexpValue, String replacement) {
        //System.out.println(regexpPattern + " ||| " + regexpValue + " ||| " + replacement);
        String outValue = regexpValue.replaceFirst(regexpPattern, replacement);
        outValue += "";
        return outValue;
    }
}

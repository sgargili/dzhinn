/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.thoughtworks.xstream.XStream;
import convertors.XmlConvertor4Regexp;
import factories.FactoryDAO4Grabli;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pojo.Attribute;
import pojo.Regexp;

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
        xstream.alias("Regexps", List.class);
        xstream.alias("Regexp", Regexp.class);
        xstream.aliasField("Id", Regexp.class, "regexpId");
        xstream.aliasField("Name", Regexp.class, "regexpPattern");
        xstream.omitField(Regexp.class, "attribute");
        xstream.omitField(Regexp.class, "regexpType");
        xstream.omitField(Regexp.class, "groupeId");

    }

    public String getAllRegexps() {
//        regexpList = fd.getRegexpDAO().getAllAttributesOnly();
//        initXstream();
//        xml = xstream.toXML(regexpList);
        return xml;
    }

//    public String getRegexpsByAttributeId(int atrId) {
//        Attribute atr = fd.getAttributeDAO().getAttributeById(atrId);
//        //regexpList = fd.getRegexpDAO().getRegexpsByAttribute(atr);
//        initXstream();
//        xstream.registerConverter(new XmlConvertor4Regexp());
//        xml = xstream.toXML(atr);
//        return xml;
//    }
    public String getRegexpsByAttributeIdByGroupeId(int atrId, int groupeId) {
//        Attribute atr = fd.getAttributeDAO().getAttributeById(atrId);
        //regexpList = fd.getRegexpDAO().getRegexpsByAttribute(atr);

        initXstream();
        List out = fd.getRegexpDAO().getRegexpsByAttributeByGroupeByNativeSQL(groupeId, atrId);
        List<Regexp> regexps = new ArrayList();
        Iterator it = out.iterator();
        Regexp reg;
        Object[] objs;
        while (it.hasNext()) {
            objs = (Object[]) it.next();
            reg = new Regexp();
            reg.setRegexpId((Integer) objs[0]);
//            reg.setRegexpType((String) objs[1]);
            reg.setRegexpPattern("Type: <b>"
                    + (String) objs[1]
                    + "</b> Pattern: <b>"
                    + (String) objs[2]
                    + "</b> Replacement: <b>"
                    + (String) objs[3]
                    + "</b> Use Attribute: <b>"
                    + (((Byte) objs[4]).toString().equals("1") ? "true" : "false")
                    + "</b>");
//            reg.setRegexpReplacement((String) objs[3]);
            regexps.add(reg);

        }
//        xstream.registerConverter(new XmlConvertor4Regexp());
        xml = xstream.toXML(regexps);
        return xml;
    }

    public String getRegexpsByAttrAltId(int attrAltId) {
//        Attribute atr = fd.getAttributeDAO().getAttributeById(atrId);
        //regexpList = fd.getRegexpDAO().getRegexpsByAttribute(atr);
        String tempValue = "";
        initXstream();
        List out = fd.getRegexpDAO().getRegexpsByAttAltIdByNativeSQL(attrAltId);
        List<Regexp> regexps = new ArrayList();
        Iterator it = out.iterator();
        Regexp reg;
        Object[] objs;
        while (it.hasNext()) {
            objs = (Object[]) it.next();
            reg = new Regexp();
            reg.setRegexpId((Integer) objs[0]);
//            reg.setRegexpType((String) objs[1]);
            tempValue = "Type: <b>"
                    + (String) objs[1]
                    + "</b> Pattern: <b>"
                    + (String) objs[2]
                    + "</b> Replacement: <b>"
                    + (String) objs[3]
                    + "</b> Used Data: <b>";
            if (((Byte) objs[4]).toString().equals("0")) {
                tempValue += "Value";
            } else if (((Byte) objs[4]).toString().equals("1")) {
                tempValue += "Attribute";
            } else {
                tempValue += "Attribute+Value";
            }
            tempValue+="</b>";
            reg.setRegexpPattern(tempValue);
//                    + (((Byte) objs[4]).toString().equals("1") ? "true" : "false")
//                    + "</b>");
//            reg.setRegexpReplacement((String) objs[3]);
            regexps.add(reg);

        }
//        xstream.registerConverter(new XmlConvertor4Regexp());
        xml = xstream.toXML(regexps);
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

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pojo.OutputData;
import pojo.Regexp;

/**
 *
 * @author APOPOV
 */
public class XmlConvertor4RegexpAfter implements Converter {

    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
        Object[] input = (Object[]) o;
        List outDatas = (List) input[0];
        List regexps = (List) input[1];
        Object[] objects = (Object[]) regexps.get(0);
        Regexp reg = new Regexp();
        String tempValue;
        String tempDigitString;
        String[] mass4Regexp;
//        int tempInt;
        double tempDigit = 1d;
        if (!regexps.isEmpty()) {
            reg.setRegexpType((String) objects[1]);
            reg.setRegexpPattern((String) objects[2]);
            reg.setRegexpReplacement((String) objects[3]);
        }
        int i = 0;
        OutputData outData;
//        Attribute atr = (Attribute) input[1];
//        Regexp reg;
//        Pattern pat;
//        Matcher match;
        Iterator it = outDatas.iterator();
        while (it.hasNext()) {
            outData = (OutputData) it.next();
            writer.startNode("Article");
            try {

                writer.startNode("Id");
                writer.setValue(i++ + "");
                writer.endNode();

                writer.startNode("ValueBefore");
                try {
                    writer.setValue(outData.getOldValue());
                } catch (Exception ex) {
                    writer.setValue("");
                }
                writer.endNode();

                writer.startNode("ValueAfter");
                if (reg.getRegexpType().equals("ReplaceFirst")) {
                    try {
                        if (reg.getRegexpReplacement().contains("^^^^")) {
                            reg.setRegexpReplacement(reg.getRegexpReplacement().replaceFirst("^^^^", ""));
                            tempValue = outData.getOldValue().replaceFirst(reg.getRegexpPattern(), reg.getRegexpReplacement());
                            tempDigitString = tempValue.replaceFirst(".*?[{](.*?)[}].*", "$1");
                            mass4Regexp = tempDigitString.split("[*]");
                            for (int j = 0; j < mass4Regexp.length; j++) {
                                tempDigit *= Double.parseDouble(mass4Regexp[j]);
                            }
                            writer.setValue(tempValue.replaceFirst(".*?[}](.*)", tempDigit + "$1"));
                        } else {
                            writer.setValue(outData.getOldValue().replaceFirst(reg.getRegexpPattern(), reg.getRegexpReplacement()));
                        }
                    } catch (Exception ex) {
//                        writer.setValue(outData.getValue().replaceFirst(reg.getRegexpPattern(), reg.getRegexpReplacement()));
                        writer.setValue("Regexp Error: -> " + ex.getMessage());
                    }

                } else if (reg.getRegexpType().equals("ReplaceAll")) {
                    try {
                        writer.setValue(outData.getOldValue().replaceAll(reg.getRegexpPattern(), reg.getRegexpReplacement()));
                    } catch (Exception ex) {
                        writer.setValue("Regexp Error: -> " + ex.getMessage());
                    }
                } else {
                    String[] mass = outData.getOldValue().split(reg.getRegexpPattern());
                    StringBuilder tmp = new StringBuilder();
                    for (int j = 0; j < mass.length; j++) {
                        if (j != mass.length - 1) {
                            tmp.append(mass[j] + "<br/>");
                        } else {
                            tmp.append(mass[j]);
                        }
                    }
                    writer.setValue(tmp.toString());
                }
                writer.endNode();

            } catch (Exception ex) {
            }
            writer.endNode();
            tempDigit = 1d;
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
        return type.equals(Object[].class);
    }
}

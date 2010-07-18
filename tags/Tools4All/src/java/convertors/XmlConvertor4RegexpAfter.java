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
import pojo.Attribute;
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
        int tempInt;
        if (!regexps.isEmpty()) {
            reg.setRegexpType((String) objects[1]);
            reg.setRegexpPattern((String) objects[2]);
            reg.setRegexpReplacement((String) objects[3]);
            reg.setCoefficient((Integer) objects[4]);
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
                writer.setValue(outData.getValue());
                writer.endNode();

                writer.startNode("ValueAfter");
                if (reg.getRegexpType().equals("ReplaceFirst")) {
                    try {
                        if (reg.getCoefficient() > 1) {
                            tempValue = outData.getValue().replaceFirst(reg.getRegexpPattern(), reg.getRegexpReplacement());
                            tempInt = Integer.parseInt(tempValue) * (reg.getCoefficient());
                            writer.setValue(tempInt+"");
                        } else {
                            writer.setValue(outData.getValue().replaceFirst(reg.getRegexpPattern(), reg.getRegexpReplacement()));
                        }
                    } catch (Exception ex) {
//                        writer.setValue(outData.getValue().replaceFirst(reg.getRegexpPattern(), reg.getRegexpReplacement()));
                        writer.setValue("Regexp Error: -> " + ex.getMessage());
                    }
                    
                } else if (reg.getRegexpType().equals("ReplaceAll")) {
                    try {
                        if (reg.getCoefficient() > 1) {
                            tempValue = outData.getValue().replaceAll(reg.getRegexpPattern(), reg.getRegexpReplacement());
                            tempInt = Integer.parseInt(tempValue) * (reg.getCoefficient());
                            writer.setValue(tempInt+"");
                        } else {
                            writer.setValue(outData.getValue().replaceAll(reg.getRegexpPattern(), reg.getRegexpReplacement()));
                        }
                    } catch (Exception ex) {
                        writer.setValue(outData.getValue().replaceAll(reg.getRegexpPattern(), reg.getRegexpReplacement()));
                    }
                } else {
                    String[] mass = outData.getValue().split(reg.getRegexpPattern());
                    StringBuffer tmp = new StringBuffer();
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

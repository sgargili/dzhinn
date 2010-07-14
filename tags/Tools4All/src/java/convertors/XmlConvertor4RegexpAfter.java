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
        List<OutputData> outDatas = (List<OutputData>) input[0];
        OutputData outData;
        Attribute atr = (Attribute) input[1];
        Regexp reg;
        Pattern pat;
        Matcher match;
        Iterator it = outDatas.iterator();
        while (it.hasNext()) {
            outData = (OutputData) it.next();
            writer.startNode("Article");
            try {

                writer.startNode("Id");
                writer.setValue(outData.getOutputDataId().toString());
                writer.endNode();

                writer.startNode("ValueBefore");
                writer.setValue(outData.getValue());
                writer.endNode();

                writer.startNode("ValueAfter");
//                pat = Pattern.compile(atr.getRegexps().get(0).getRegexpPattern());
//                match = pat.matcher(outData.getValue());
//                while (match.find()) {
//                    writer.setValue(match.replaceFirst(atr.getRegexps().get(0).getRegexpReplacement()));
//                }
                writer.setValue(outData.getValue().replaceFirst(atr.getRegexps().get(0).getRegexpPattern(), atr.getRegexps().get(0).getRegexpReplacement()));
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

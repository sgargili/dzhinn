/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.thoughtworks.xstream.XStream;
import convertors.XmlConvertor4RegexpAfter;
import factories.FactoryDAO4Grabli;
import java.util.ArrayList;
import java.util.List;
import pojo.OutputData;

/**
 *
 * @author APopov
 */
public class OutputDataXML {

    FactoryDAO4Grabli fd = FactoryDAO4Grabli.getInstance();
    XStream xstream = new XStream();
    List outputDataList = new ArrayList();
    long id;
    String xml;

    private void initXstream() {
        xstream.alias("Articles", List.class);
        xstream.alias("Articles", Object[].class);
        xstream.alias("Article", OutputData.class);
        xstream.aliasField("Id", OutputData.class, "outputDataId");
        xstream.aliasField("Sid", OutputData.class, "sessionId");
        xstream.aliasField("Name", OutputData.class, "article");
        xstream.aliasField("PT", OutputData.class, "productType");
        xstream.aliasField("Groupe", OutputData.class, "groupe");
        xstream.aliasField("Attribute", OutputData.class, "attribute");
        xstream.aliasField("Value", OutputData.class, "value");
        xstream.aliasField("Unit", OutputData.class, "unit");
        xstream.aliasField("Available", OutputData.class, "available");

    }

    public String getAllOutputData() {
        outputDataList = fd.getOutputDataDAO().getAllOutputData();
        initXstream();
        xml = xstream.toXML(outputDataList);
        return xml;
    }

    public String getOutputDataBySessionId(long id) {
        List<OutputData> odList = fd.getOutputDataDAO().getOutputDataBySessionId(id);
        initXstream();
        xml = xstream.toXML(odList);
        return xml;
    }
//

    public String getOutputDataByArticle(String article) {
        List<OutputData> odList = fd.getOutputDataDAO().getOutputDataByArticle(article);
        initXstream();
        xml = xstream.toXML(odList);
        return xml;
    }

    public String getOutputDataByAttributeBefore(String attribute) {
        List<OutputData> odList = fd.getOutputDataDAO().getOutputDataByAttribute(attribute);
        initXstream();
        xml = xstream.toXML(odList);
        return xml;
    }

    public String getOutputDataByAttributeAfter(String groupeId, String groupeName, String attributeId, String attributeName, String regexpLimit) {
        //System.out.println(attributeId + " ||| " + attribute);
//        System.out.println(groupeId + "|||" + groupeName + "|||" + attributeId + "|||" + attributeName);
        int limit;
        try {
            limit = Integer.parseInt(regexpLimit);
        } catch (NumberFormatException ex) {
            limit = 20;
        }
        List odList = fd.getOutputDataDAO().getOutputDataByGroupeByAttribute(groupeName, attributeName, limit);
        List regList = fd.getRegexpDAO().getRegexpsByAttributeByGroupeByNativeSQL(Integer.parseInt(groupeId), Integer.parseInt(attributeId));
        Object[] objs = new Object[2];
        objs[0] = odList;
        objs[1] = regList;
        initXstream();
        xstream.registerConverter(new XmlConvertor4RegexpAfter());
        xml = xstream.toXML(objs);
        return xml;
    }
}

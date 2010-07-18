/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.thoughtworks.xstream.XStream;
import convertors.XmlConvertor4Regexp;
import factories.FactoryDAO4Grabli;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pojo.Attribute;
import pojo.Regexp;

/**
 *
 * @author APOPOV
 */
public class SessionsXML {

    FactoryDAO4Grabli fd = FactoryDAO4Grabli.getInstance();
    XStream xstream = new XStream();
    long id;
    String xml;

    private void initXstream() {
        xstream.alias("Sessions", List.class);
        xstream.alias("Session", Object[].class);
        xstream.alias("SessionId", BigInteger.class);
        xstream.alias("Article", String.class);
        xstream.aliasField("Id", Regexp.class, "regexpId");
        xstream.aliasField("Name", Regexp.class, "regexpPattern");
        xstream.omitField(Regexp.class, "attribute");
        xstream.omitField(Regexp.class, "regexpType");
        xstream.omitField(Regexp.class, "groupeId");

    }

    public String getSessionsXML(String article) {
        if (article.equals("") || article == null) {
            article = "%";
        } else {
            article = "%" + article + "%";
        }
        List sessionList = fd.getOutputDataDAO().getSessiosnIdByArticleByNativeSQL(article);
//        List out = new ArrayList();
//        Object[] objs = new Long[2];
//        Object obj;
//        long longValue;
//        int i = 0;
//        Iterator it = sessionList.iterator();
//        while(it.hasNext()){
//        obj =  it.next();
//        objs[0] = i++;
//        objs[1] = obj.toString();
//        out.add(objs);
//        }
        initXstream();
        xml = xstream.toXML(sessionList);
        return xml;
    }
}

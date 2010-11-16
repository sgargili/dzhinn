/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.thoughtworks.xstream.XStream;
import convertors.XmlConvertor4Regexp;
import convertors.XmlConvertor4Sessions;
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
        String[] mass = new String[3];
        BigInteger session;
        List<String[]> out = new ArrayList();
        List sessionList = fd.getOutputDataDAO().getSessiosnIdByArticleWOArticleByNativeSQL(article);
        List ptList;
        int aCount;
        String tempPt = "";
        Iterator it = sessionList.iterator();
        Iterator iter;
        boolean first = true;
        while (it.hasNext()) {
            session = (BigInteger) it.next();
            ptList = fd.getOutputDataDAO().getPTBySessionIdByNativeSQL(session);
            iter = ptList.iterator();
            first = true;
            while (iter.hasNext()) {
                if (first) {
                    tempPt = (String) iter.next();
                    first = false;
                } else {
                    tempPt = ", " + (String) iter.next();
                }
            }
            aCount = fd.getOutputDataDAO().getCountArticlesBySessionIdByNativeSQL(session);
            mass = new String[3];
            mass[0] = session + "";
            mass[1] = tempPt;
            mass[2] = aCount + "";
            out.add(mass);
            tempPt = "";
            aCount = 0;
        }
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
        xstream.registerConverter(new XmlConvertor4Sessions());
        xml = xstream.toXML(out);
        return xml;
    }
}

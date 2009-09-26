/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Yandex;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 *
 * @author Admin4DB2
 */
public class XmlElab {

    public List FullBeanXml() throws XmlPullParserException, IOException {
        List lst = new ArrayList();
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        xpp.setInput(new FileReader("c:\\test.xml"));
        boolean bool = false;
        String Price = null, Id = null;
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if ((eventType == XmlPullParser.START_TAG) && xpp.getName().equals("offer") && xpp.getAttributeValue(1).equals("true")) {
                Id = xpp.getAttributeValue(0);
                bool = true;
                //   xpp.nextTag();
            }
            if ((eventType == XmlPullParser.START_TAG) && xpp.getName().equals("price") && bool) {
                Price = xpp.nextText();
            }
            if ((eventType == XmlPullParser.START_TAG) && xpp.getName().equals("name") && bool) {
                lst.add(new DataBean(Id, xpp.nextText(), Price));
            }
            // xpp.nextTag();
            if ((eventType == XmlPullParser.END_TAG) && xpp.getName().equals("offer") && bool) {
                //lst.add(new DataBean(Id, Price, xpp.nextText()));
                bool = false;
            }

//                lst.add(new DataBean(xpp.getAttributeValue(0), xpp., xpp.getAttributeValue(0)));
//                    System.out.println("Всего атрибутов у тега article= " + xpp.getAttributeCount());
//                    System.out.println("id = " + xpp.getAttributeValue(0));
//                    System.out.println("classcat_id = " + xpp.getAttributeValue(1));
//                    System.out.println("code = " + xpp.getAttributeValue(2));
//                    System.out.println("full_name = " + xpp.getAttributeValue(4));

            eventType = xpp.next();
        }
        Collections.sort(lst, new Comparator<DataBean>() {
           // @Override
            public int compare(DataBean o1, DataBean o2) {
                String withoutEx1 = o1.getId();
                String withoutEx2 = o2.getId();
                return withoutEx1.compareTo(withoutEx2);
            }

//            public int compare(DataBean o1, DataBean o2) {
//                throw new UnsupportedOperationException("Not supported yet.");
//            }
        });
        return lst;
    }
}

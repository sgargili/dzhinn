/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Pojo.Manufacturer;
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
        xpp.setInput(new FileReader("c:\\manufacturers.xml"));
        // boolean bool = false;
        // String Price = null, Id = null;
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            Manufacturer db = new Manufacturer();
            if ((eventType == XmlPullParser.START_TAG) && xpp.getName().equals("node")) {
                db.setManufacturerId(Long.parseLong(xpp.getAttributeValue(0)));
                db.setManufacturerName(xpp.getAttributeValue(1));
                lst.add(db);
            }

            eventType = xpp.next();
        }
        Collections.sort(lst, new Comparator<Manufacturer>() {

            public int compare(Manufacturer o1, Manufacturer o2) {
                String withoutEx1 = o1.getManufacturerName();
                String withoutEx2 = o2.getManufacturerName();
                return withoutEx1.compareTo(withoutEx2);
            }
//            public int compare(DataBean o1, DataBean o2) {
//                throw new UnsupportedOperationException("Not supported yet.");
//            }
        });
        return lst;
    }
}

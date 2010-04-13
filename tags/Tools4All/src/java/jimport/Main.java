/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jimport;

import factories.FactoryHTTPData2XmlParser;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/**
 *
 * @author APopov
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws XmlPullParserException, IOException {
        XmlPullParser xpp = FactoryHTTPData2XmlParser.getInstance().getHttpData2Xpp().getXpp("http://www.ya.ru");
        boolean bool = false;
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG
                    && xpp.getName().equals("title")) {
                bool = true;
            }

            if (eventType == XmlPullParser.TEXT && bool) {
                System.out.println(xpp.getText());
            }
            if (eventType == XmlPullParser.END_TAG && bool) {
                bool = false;
            }

            eventType = xpp.next();
        }

    }
}

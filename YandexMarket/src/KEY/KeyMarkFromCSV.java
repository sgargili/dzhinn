/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KEY;

import DAO.FactoryDAO;
import Pojo.KeyFromXml;
import Pojo.MarkFromXml;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.ccil.cowan.tagsoup.Parser;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.xml.sax.ContentHandler;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 *
 * @author ilyahoo
 */
public class KeyMarkFromCSV {

    private static String theOutputEncoding = "UTF-8";

    public static void main(String[] args) throws SQLException, XmlPullParserException {
        FactoryDAO fd = FactoryDAO.getInstance();
        List<KeyFromXml> ks = (List<KeyFromXml>) fd.getKeysDAO().getAllKeys();
        String dst = "/home/ilyahoo/NetBeansProjects/Temp/new.xhtml";
        OutputStream os = null;
        XMLReader r;
        Writer w = null;
        ContentHandler h;
        File fl;
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        File xml = new File(dst);
        MarkFromXml km;

        String mark = "";
        boolean mrkBool = false,
                mrkBool2 = false,
                mrValBool = false;

        for (Iterator i = ks.iterator(); i.hasNext();) {
            KeyFromXml key = (KeyFromXml) i.next();

            fl = new File("/home/ilyahoo/NetBeansProjects/KeyUpload/XMLs/" + key.getKeyart() + ".xml");
            System.out.println("*******************************************");

            try {
                os = new FileOutputStream(dst);
                r = new Parser();
                w = new OutputStreamWriter(os, theOutputEncoding);
                h = new XMLWriter(w);

                r.setContentHandler(h);
                r.parse(fl.toURI().toString());
                xml = new File(dst);
                xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), "UTF-8"));

                int eventType = xpp.getEventType();
                km = new MarkFromXml();
                //km.setId(key.getId());
                km.setKeyart(key.getKeyart());
                System.out.println(key.getId() + ") <" + key.getKeyart() + ">");

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    //cardBool = false;

                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("param_name")) {
                        mrkBool = true;
                    }
                    if (eventType == XmlPullParser.TEXT && mrkBool && xpp.getText().equals("Рассказ")) {
                        mrkBool = false;
                        mrkBool2 = true;
                    }
                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("param_value") && mrkBool2) {
                        mrkBool2 = false;
                        mrValBool = true;
                    }
                    if (eventType == XmlPullParser.TEXT && mrValBool) {
                        mrValBool = false;
                        mark = xpp.getText().trim();
                        System.out.println(mark);
                    }

                    eventType = xpp.next();
                }

                km.setMarketing(mark);

                fd.getMKeysDAO().addKeys(km);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}

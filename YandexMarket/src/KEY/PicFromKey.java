/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KEY;

import DAO.FactoryDAO;
import HttpClient.http;
import Pojo.KeyFromXml;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.ccil.cowan.tagsoup.Parser;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 *
 * @author ilyahoo
 */
public class PicFromKey {

    private static String theOutputEncoding = "WINDOWS-1251";

    public static void main(String[] args) throws SQLException, XmlPullParserException, UnsupportedEncodingException, IOException, SAXException {
        String keyArt, picURL;
        String dst = "/home/ilyahoo/NetBeansProjects/Temp/new.xhtml";
        OutputStream os = null, os1 = null;
        XMLReader r, r1;
        Writer w = null, w1 = null;
        ContentHandler h, h1;
        http ht = new http(), ht1 = new http();
        File fl;
        byte[] fl1;
        File temp, temp1;
        String url;
        boolean begBool = false,
                imgBool = false;

        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        File xml = new File(dst);

        FactoryDAO fd = FactoryDAO.getInstance();
        List<KeyFromXml> keys = (List<KeyFromXml>) fd.getKeysDAO().getAllKeys();

        for (Iterator iter = keys.iterator(); iter.hasNext();) {
            picURL = "no";
            //KeyFromXml ks1 = (KeyFromXml) iter.next();
            KeyFromXml ks = (KeyFromXml) iter.next();
            keyArt = ks.getKeyart();
            System.out.println("***************************************");
            System.out.print(ks.getId() + ") <" + keyArt + "> ");

            url = "http://shop.key.ru/shop/goods/" + keyArt + "/";

            fl = ht.DownloadContentAsFile(url, false);
            temp = new File("/home/ilyahoo/NetBeansProjects/KeyPic/temp/" + ks.getKeyart() + ".xhtml");
            FileUtils.writeStringToFile(temp, FileUtils.readFileToString(fl, theOutputEncoding), theOutputEncoding);

            try {
                os = new FileOutputStream(dst);
                r = new Parser();
                w = new OutputStreamWriter(os, theOutputEncoding);
                h = new XMLWriter(w);

                r.setContentHandler(h);
                r.parse(temp.toURI().toString());
                xml = new File(dst);
                xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), theOutputEncoding));

                int eventType = xpp.getEventType();

                while (eventType != XmlPullParser.END_DOCUMENT) {

                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div") && xpp.getAttributeCount() == 1 && xpp.getAttributeValue(0).equals("section_title")) {
                        begBool = true;
                    }

                    if (eventType == XmlPullParser.TEXT && xpp.getText().trim().equals("Описание товара") && begBool) {
                        begBool = false;
                        imgBool = true;
                    }

                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("img") && imgBool) {
                        imgBool = false;
                        picURL = "http://shop.key.ru" + xpp.getAttributeValue(0);
                        System.out.println("ssylka: " + picURL);
                    }
                    eventType = xpp.next();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            try {
                if (!picURL.equals("no")) {
                    fl1 = ht1.DownloadContentAsBinFile(picURL, false);
                    System.out.println("Dannye skachalis...");
                    if (picURL.contains(".gif")) {
                        temp1 = new File("/home/ilyahoo/NetBeansProjects/KeyPic/Pics/KEY_" + keyArt + ".gif");
                        FileUtils.writeByteArrayToFile(temp1, fl1);
                    }
                    if (picURL.contains(".jpg") || picURL.contains(".jpeg")) {
                        temp1 = new File("/home/ilyahoo/NetBeansProjects/KeyPic/Pics/KEY_" + keyArt + ".jpg");
                        FileUtils.writeByteArrayToFile(temp1, fl1);
                    }

                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}

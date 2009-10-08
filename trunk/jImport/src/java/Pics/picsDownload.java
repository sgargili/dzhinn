/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pics;

import FTP.FTPClient;
import HttpClient.http;
import Pojo.PicsBean;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 *
 * @author APopov
 */
public class picsDownload {

    public static void main(String[] arg) throws IOException, XmlPullParserException {
        List<PicsBean> pbl = new ArrayList();
        PicsBean pb;
        String artBuffer = "";
        http ht = new http();
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        //xpp.setInput(new InputStreamReader(FileUtils.openInputStream(new File("C:/test.xml")), "UTF-8"));
        xpp.setInput(new InputStreamReader(FileUtils.openInputStream(ht.DownloadContentAsFile("http://213.53.57.20/ShopIX/exportFullXML.jsp?shopId=74")), "UTF-8"));
        int eventType = xpp.getEventType();
        int sIndex = 0, mIndex = 0, bIndex = 0;
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("itemImage")) {
                if (!artBuffer.equals(xpp.getAttributeValue(0))) {
                    sIndex = 0;
                    mIndex = 0;
                    bIndex = 0;
                }
                pb = new PicsBean();
                pb.setId(Integer.parseInt(artBuffer = xpp.getAttributeValue(0)));
                pb.setSource(xpp.getAttributeValue(4));
                if (Integer.parseInt(xpp.getAttributeValue(1)) <= 75) {
                    pb.setType("small");
                    pb.setIndex(sIndex);
                    sIndex++;
                } else if (Integer.parseInt(xpp.getAttributeValue(1)) > 75 && Integer.parseInt(xpp.getAttributeValue(1)) < 362) {
                    pb.setType("medium");
                    pb.setIndex(mIndex);
                    mIndex++;
                } else {
                    pb.setType("big");
                    pb.setIndex(bIndex);
                    bIndex++;
                }
                pbl.add(pb);
            }
            eventType = xpp.next();
        }
        File fl;
        URL url;
        FTPClient ftp = new FTPClient();
        ftp.connect("u196802.ftp.masterhost.ru", 21, "u196802", "heolody2ess9y");
        ftp.cwd("/stoneaxe.ru/www/imgLib");
        ftp.bin();
        for (Iterator it = pbl.iterator(); it.hasNext();) {
            PicsBean temp = (PicsBean) it.next();
            fl = new File("C:/pics/" + temp.getId() + "_" + temp.getType() + "_" + temp.getIndex() + ".jpg");
            url = new URL(temp.getSource());
            FileUtils.copyURLToFile(url, fl);
            ftp.stor(FileUtils.openInputStream(fl), fl.getName());
            System.out.println(temp.getId() + " -> " + temp.getSource() + " -> " + temp.getType() + "(" + temp.getIndex() + ")");
            fl.delete();
        }
        ftp.disconnect();
    }
}

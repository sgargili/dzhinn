/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gkey;

import tor.IpChange;
import dao.FactoryDAO;
import http.Http;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.apache.commons.io.FileUtils;
import org.ccil.cowan.tagsoup.Parser;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.xml.sax.ContentHandler;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import pojo.Keydata;
import pojo.Keymarketing;
import pojo.Keyprice;
import pojo.Keywarranty;
import pojo.Matching;

/**
 *
 * @author Apopov
 */
public class MyRunnable implements Runnable {

    final static String FULL_NAME1 = "margin-top: 10px; font: bold 18px Helvetica,arial;";
    final static String FULL_NAME2 = "white-space: nowrap;height:20px;vertical-align:middle;";
    final static String WARRANTY = "margin-top: 15px;";
    final static String MANUFACTURER = "width: 100px; height: 40px; border: 1px solid #aaa;";
    final static String PRICE = "color: brown; font: normal 18px Helvetica,arial;";
    final static String MARKETING = "text-align:justify;";
    final static String PIC = "border: solid 1px #aaa; float: left; margin-right: 10px; ";
    final static String DESCRIPTION = "table2";
    final static String TD_HEAD = "head_row21";
    final static String TD_BODY_ATR = "row223";
    final static String TD_BODY_VALUE = "row121";
    static int bayan = 0;

    public String getName() {
        return Thread.currentThread().getName();
    }

    public void run() {
        if (getName().equals("1")) {
            for (int i = 1500; i < 10000; i++) {
                DownloadContent dc = new DownloadContent();
                dc.load("1", i);
            }
        } else if (getName().equals("2")) {
            for (int i = 10001; i < 20000; i++) {
                DownloadContent dc = new DownloadContent();
                dc.load("2", i);
            }
        } else if (getName().equals("3")) {
            for (int i = 20001; i < 30000; i++) {
                DownloadContent dc = new DownloadContent();
                dc.load("3", i);
            }
        } else if (getName().equals("4")) {
            for (int i = 30001; i < 40000; i++) {
                DownloadContent dc = new DownloadContent();
                dc.load("4", i);
            }
        } else if (getName().equals("5")) {
            for (int i = 40001; i < 50000; i++) {
                DownloadContent dc = new DownloadContent();
                dc.load("5", i);
            }
        } else if (getName().equals("6")) {
            for (int i = 50001; i < 60000; i++) {
                DownloadContent dc = new DownloadContent();
                dc.load("6", i);
            }
        } else if (getName().equals("7")) {
            for (int i = 60001; i < 70000; i++) {
                DownloadContent dc = new DownloadContent();
                dc.load("7", i);
            }
        } else if (getName().equals("8")) {
            for (int i = 70001; i < 80000; i++) {
                DownloadContent dc = new DownloadContent();
                dc.load("8", i);
            }
        } else if (getName().equals("9")) {
            for (int i = 80001; i < 90000; i++) {
                DownloadContent dc = new DownloadContent();
                dc.load("9", i);
            }
        } else if (getName().equals("10")) {
            for (int i = 90001; i < 100000; i++) {
                DownloadContent dc = new DownloadContent();
                dc.load("10", i);
            }
        }
    }
}

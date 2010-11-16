/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.impl;

import factories.FactoryHTML2XML;
import factories.FactoryHTTP;
import httpclient.HttpData;
import java.io.InputStreamReader;
import org.apache.commons.io.FileUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import xml.Html2Xml;
import xml.HttpData2Xpp;

/**
 *
 * @author Apopov
 */
public class HttpData2XppImpl implements HttpData2Xpp {

    public XmlPullParser getXpp(String url) {
        XmlPullParserFactory factory = null;
        XmlPullParser xpp = null;
        HttpData http = FactoryHTTP.getInstance().getHttpData();
        Html2Xml xml = FactoryHTML2XML.getInstance().getHtml2Xml();
        try {
            factory = XmlPullParserFactory.newInstance();
            xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml.convertHtml2Xml(http.downloadContentAsFile(url))), "UTF-8"));
        } catch (Exception ex) {
        }
        return xpp;
    }

    public XmlPullParser getXpp(String url, boolean useProxy) {
        XmlPullParserFactory factory = null;
        XmlPullParser xpp = null;
        HttpData http = FactoryHTTP.getInstance().getHttpData();
        Html2Xml xml = FactoryHTML2XML.getInstance().getHtml2Xml();
        try {
            factory = XmlPullParserFactory.newInstance();
            xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml.convertHtml2Xml(http.downloadContentAsFile(url, useProxy))), "UTF-8"));
        } catch (Exception ex) {
        }
        return xpp;
    }

    public XmlPullParser getXpp(String url, String inputEncoding) {
        XmlPullParserFactory factory = null;
        XmlPullParser xpp = null;
        HttpData http = FactoryHTTP.getInstance().getHttpData();
        Html2Xml xml = FactoryHTML2XML.getInstance().getHtml2Xml();
        try {
            factory = XmlPullParserFactory.newInstance();
            xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml.convertHtml2Xml(http.downloadContentAsFile(url, inputEncoding, "UTF-8"))), "UTF-8"));
        } catch (Exception ex) {
        }
        return xpp;
    }

    public XmlPullParser getXpp(String url, String inputEncoding, boolean useProxy) {
        XmlPullParserFactory factory = null;
        XmlPullParser xpp = null;
        HttpData http = FactoryHTTP.getInstance().getHttpData();
        Html2Xml xml = FactoryHTML2XML.getInstance().getHtml2Xml();
        try {
            factory = XmlPullParserFactory.newInstance();
            xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml.convertHtml2Xml(http.downloadContentAsFile(url, inputEncoding, "UTF-8", useProxy))), "UTF-8"));
        } catch (Exception ex) {
        }
        return xpp;
    }

    public XmlPullParser getXpp(String url, String inputEncoding, String outputEncoding) {
        XmlPullParserFactory factory = null;
        XmlPullParser xpp = null;
        HttpData http = FactoryHTTP.getInstance().getHttpData();
        Html2Xml xml = FactoryHTML2XML.getInstance().getHtml2Xml();
        try {
            factory = XmlPullParserFactory.newInstance();
            xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml.convertHtml2Xml(http.downloadContentAsFile(url, inputEncoding, outputEncoding))), outputEncoding));
        } catch (Exception ex) {
        }
        return xpp;
    }

    public XmlPullParser getXpp(String url, String inputEncoding, String outputEncoding, boolean useProxy) {
        XmlPullParserFactory factory = null;
        XmlPullParser xpp = null;
        HttpData http = FactoryHTTP.getInstance().getHttpData();
        Html2Xml xml = FactoryHTML2XML.getInstance().getHtml2Xml();
        try {
            factory = XmlPullParserFactory.newInstance();
            xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml.convertHtml2Xml(http.downloadContentAsFile(url, inputEncoding, outputEncoding, useProxy))), outputEncoding));
        } catch (Exception ex) {
        }
        return xpp;
    }

    public XmlPullParser getXpp(String url, String inputEncoding, String outputEncoding, boolean useProxy, String ip) {
        XmlPullParserFactory factory = null;
        XmlPullParser xpp = null;
        HttpData http = FactoryHTTP.getInstance().getHttpData();
        Html2Xml xml = FactoryHTML2XML.getInstance().getHtml2Xml();
        try {
            factory = XmlPullParserFactory.newInstance();
            xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml.convertHtml2Xml(http.downloadContentAsFile(url, inputEncoding, outputEncoding, useProxy, ip))), outputEncoding));
        } catch (Exception ex) {
        }
        return xpp;
    }
}

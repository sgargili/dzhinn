/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ira.xml.impl;

import ira.httpclient.FactoryHttpData;
import ira.httpclient.HttpData;

import java.io.InputStreamReader;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import ira.xml.Html2Xml;
import ira.xml.HttpData2Xpp;

/**
 * @author Apopov
 */
@Repository
@Service("httpData2Xpp")
public class HttpData2XppImpl implements HttpData2Xpp {

    private HttpData http = FactoryHttpData.getInstance().getHttpData();
    private Html2Xml html2Xml;

    @Autowired
    public void setHtml2Xml(Html2Xml html2Xml) {
        this.html2Xml = html2Xml;
    }

    public XmlPullParser getXpp(String url) {
        XmlPullParserFactory factory = null;
        XmlPullParser xpp = null;
        try {
            factory = XmlPullParserFactory.newInstance();
            xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(FileUtils.openInputStream(html2Xml.convertHtml2Xml(http.downloadContentAsFile(url))), "UTF-8"));
        } catch (Exception ex) {
        }
        return xpp;
    }

    public XmlPullParser getXpp(String url, boolean useProxy) {
        XmlPullParserFactory factory = null;
        XmlPullParser xpp = null;
        try {
            factory = XmlPullParserFactory.newInstance();
            xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(FileUtils.openInputStream(html2Xml.convertHtml2Xml(http.downloadContentAsFile(url, useProxy))), "UTF-8"));
        } catch (Exception ex) {
        }
        return xpp;
    }

    public XmlPullParser getXpp(String url, String inputEncoding) {
        XmlPullParserFactory factory = null;
        XmlPullParser xpp = null;
        try {
            factory = XmlPullParserFactory.newInstance();
            xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(FileUtils.openInputStream(html2Xml.convertHtml2Xml(http.downloadContentAsFile(url, inputEncoding, "UTF-8"))), "UTF-8"));
        } catch (Exception ex) {
        }
        return xpp;
    }

    public XmlPullParser getXpp(String url, String inputEncoding, boolean useProxy) {
        XmlPullParserFactory factory = null;
        XmlPullParser xpp = null;
        try {
            factory = XmlPullParserFactory.newInstance();
            xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(FileUtils.openInputStream(html2Xml.convertHtml2Xml(http.downloadContentAsFile(url, inputEncoding, "UTF-8", useProxy))), "UTF-8"));
        } catch (Exception ex) {
        }
        return xpp;
    }

    public XmlPullParser getXpp(String url, String inputEncoding, String outputEncoding) {
        XmlPullParserFactory factory = null;
        XmlPullParser xpp = null;
        try {
            factory = XmlPullParserFactory.newInstance();
            xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(FileUtils.openInputStream(html2Xml.convertHtml2Xml(http.downloadContentAsFile(url, inputEncoding, outputEncoding))), outputEncoding));
        } catch (Exception ex) {
        }
        return xpp;
    }

    public XmlPullParser getXpp(String url, String inputEncoding, String outputEncoding, boolean useProxy) {
        XmlPullParserFactory factory = null;
        XmlPullParser xpp = null;
        try {
            factory = XmlPullParserFactory.newInstance();
            xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(FileUtils.openInputStream(html2Xml.convertHtml2Xml(http.downloadContentAsFile(url, inputEncoding, outputEncoding, useProxy))), outputEncoding));
        } catch (Exception ex) {
        }
        return xpp;
    }

    public XmlPullParser getXpp(String url, String inputEncoding, String outputEncoding, boolean useProxy, String ip) {
        XmlPullParserFactory factory = null;
        XmlPullParser xpp = null;
        try {
            factory = XmlPullParserFactory.newInstance();
            xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(FileUtils.openInputStream(html2Xml.convertHtml2Xml(http.downloadContentAsFile(url, inputEncoding, outputEncoding, useProxy, ip))), outputEncoding));
        } catch (Exception ex) {
        }
        return xpp;
    }
}

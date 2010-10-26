/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ira.xml.impl;


import ira.httpclient.FactoryHttpData;
import ira.httpclient.HttpData;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import ira.xml.Html2Xml;
import ira.xml.HttpData2Dom;

/**
 * @author APopov
 */
@Repository
@Service("httpData2Dom")
public class HttpData2DomImpl implements HttpData2Dom {
    private HttpData http = FactoryHttpData.getInstance().getHttpData();
    private Html2Xml html2Xml;

    @Autowired
    public void setHtml2Xml(Html2Xml html2Xml) {
        this.html2Xml = html2Xml;
    }

    public Document getDom(String url) {
        Document doc = null;
        DocumentBuilderFactory factory = null;
//        HttpData http = FactoryHTTP.getInstance().getHttpData();
//        Html2Xml html2Xml = FactoryHTML2XML.getInstance().getHtml2Xml();
        try {
            factory = DocumentBuilderFactory.newInstance();
            doc = factory.newDocumentBuilder().parse(FileUtils.openInputStream(html2Xml.convertHtml2Xml(http.downloadContentAsFile(url))));

        } catch (Exception ex) {
        }
        return doc;
    }

    public Document getDom(String url, boolean useProxy) {
        Document doc = null;
        DocumentBuilderFactory factory = null;
        try {
            factory = DocumentBuilderFactory.newInstance();
            doc = factory.newDocumentBuilder().parse(FileUtils.openInputStream(html2Xml.convertHtml2Xml(http.downloadContentAsFile(url, useProxy))));

        } catch (Exception ex) {
        }
        return doc;
    }

    public Document getDom(String url, String inputEncoding) {
        Document doc = null;
        DocumentBuilderFactory factory = null;
        try {
            factory = DocumentBuilderFactory.newInstance();
            doc = factory.newDocumentBuilder().parse(FileUtils.openInputStream(html2Xml.convertHtml2Xml(http.downloadContentAsFile(url, inputEncoding, "UTF-8"))));

        } catch (Exception ex) {
        }
        return doc;
    }

    public Document getDom(String url, String inputEncoding, boolean useProxy) {
        Document doc = null;
        DocumentBuilderFactory factory = null;
        try {
            factory = DocumentBuilderFactory.newInstance();
            doc = factory.newDocumentBuilder().parse(FileUtils.openInputStream(html2Xml.convertHtml2Xml(http.downloadContentAsFile(url, inputEncoding, "UTF-8", useProxy))));

        } catch (Exception ex) {
        }
        return doc;
    }

    public Document getDom(String url, String inputEncoding, String outputEncoding) {
        Document doc = null;
        DocumentBuilderFactory factory = null;
        try {
            factory = DocumentBuilderFactory.newInstance();
            doc = factory.newDocumentBuilder().parse(FileUtils.openInputStream(html2Xml.convertHtml2Xml(http.downloadContentAsFile(url, inputEncoding, outputEncoding))));

        } catch (Exception ex) {
        }
        return doc;
    }

    public Document getDom(String url, String inputEncoding, String outputEncoding, boolean useProxy) {
        Document doc = null;
        DocumentBuilderFactory factory = null;
        try {
            factory = DocumentBuilderFactory.newInstance();
            doc = factory.newDocumentBuilder().parse(FileUtils.openInputStream(html2Xml.convertHtml2Xml(http.downloadContentAsFile(url, inputEncoding, outputEncoding, useProxy))));

        } catch (Exception ex) {
        }
        return doc;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.impl;

import factories.FactoryHTML2XML;
import factories.FactoryHTTP;
import httpclient.HttpData;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import xml.Html2Xml;
import xml.HttpData2Dom;

/**DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file)
 *
 * @author APopov
 */
@Repository
@Service("httpData2Dom")
public class HttpData2DomImpl implements HttpData2Dom {

    public Document getDom(String url) {
        Document doc = null;
        DocumentBuilderFactory factory = null;
        HttpData http = FactoryHTTP.getInstance().getHttpData();
        Html2Xml xml = FactoryHTML2XML.getInstance().getHtml2Xml();
        try {
            factory = DocumentBuilderFactory.newInstance();
            doc = factory.newDocumentBuilder().parse(FileUtils.openInputStream(xml.convertHtml2Xml(http.downloadContentAsFile(url))));

        } catch (Exception ex) {
        }
        return doc;
    }

    public Document getDom(String url, boolean useProxy) {
        Document doc = null;
        DocumentBuilderFactory factory = null;
        HttpData http = FactoryHTTP.getInstance().getHttpData();
        Html2Xml xml = FactoryHTML2XML.getInstance().getHtml2Xml();
        try {
            factory = DocumentBuilderFactory.newInstance();
            doc = factory.newDocumentBuilder().parse(FileUtils.openInputStream(xml.convertHtml2Xml(http.downloadContentAsFile(url, useProxy))));

        } catch (Exception ex) {
        }
        return doc;
    }

    public Document getDom(String url, String inputEncoding) {
        Document doc = null;
        DocumentBuilderFactory factory = null;
        HttpData http = FactoryHTTP.getInstance().getHttpData();
        Html2Xml xml = FactoryHTML2XML.getInstance().getHtml2Xml();
        try {
            factory = DocumentBuilderFactory.newInstance();
            doc = factory.newDocumentBuilder().parse(FileUtils.openInputStream(xml.convertHtml2Xml(http.downloadContentAsFile(url, inputEncoding, "UTF-8"))));

        } catch (Exception ex) {
        }
        return doc;
    }

    public Document getDom(String url, String inputEncoding, boolean useProxy) {
        Document doc = null;
        DocumentBuilderFactory factory = null;
        HttpData http = FactoryHTTP.getInstance().getHttpData();
        Html2Xml xml = FactoryHTML2XML.getInstance().getHtml2Xml();
        try {
            factory = DocumentBuilderFactory.newInstance();
            doc = factory.newDocumentBuilder().parse(FileUtils.openInputStream(xml.convertHtml2Xml(http.downloadContentAsFile(url, inputEncoding, "UTF-8", useProxy))));

        } catch (Exception ex) {
        }
        return doc;
    }

    public Document getDom(String url, String inputEncoding, String outputEncoding) {
        Document doc = null;
        DocumentBuilderFactory factory = null;
        HttpData http = FactoryHTTP.getInstance().getHttpData();
        Html2Xml xml = FactoryHTML2XML.getInstance().getHtml2Xml();
        try {
            factory = DocumentBuilderFactory.newInstance();
            doc = factory.newDocumentBuilder().parse(FileUtils.openInputStream(xml.convertHtml2Xml(http.downloadContentAsFile(url, inputEncoding, outputEncoding))));

        } catch (Exception ex) {
        }
        return doc;
    }

    public Document getDom(String url, String inputEncoding, String outputEncoding, boolean useProxy) {
        Document doc = null;
        DocumentBuilderFactory factory = null;
        HttpData http = FactoryHTTP.getInstance().getHttpData();
        Html2Xml xml = FactoryHTML2XML.getInstance().getHtml2Xml();
        try {
            factory = DocumentBuilderFactory.newInstance();
            doc = factory.newDocumentBuilder().parse(FileUtils.openInputStream(xml.convertHtml2Xml(http.downloadContentAsFile(url, inputEncoding, outputEncoding, useProxy))));

        } catch (Exception ex) {
        }
        return doc;
    }
}

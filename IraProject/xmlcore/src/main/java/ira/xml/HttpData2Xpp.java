/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ira.xml;

import org.xmlpull.v1.XmlPullParser;

/**
 *
 * @author Apopov
 */
public interface HttpData2Xpp {

    public XmlPullParser getXpp(String url);

    public XmlPullParser getXpp(String url, boolean useProxy);

    public XmlPullParser getXpp(String url, String inputEncoding);

    public XmlPullParser getXpp(String url, String inputEncoding, boolean useProxy);

    public XmlPullParser getXpp(String url, String inputEncoding, String outputEncoding);

    public XmlPullParser getXpp(String url, String inputEncoding, String outputEncoding, boolean useProxy);

    public XmlPullParser getXpp(String url, String inputEncoding, String outputEncoding, boolean useProxy, String ip);
}

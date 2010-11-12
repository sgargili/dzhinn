package processing;

import factories.FactoryHTTPData2XmlParser;
import org.xmlpull.v1.XmlPullParser;
import pojo.FcenterProduct;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 12.11.2010
 * Time: 14:08:57
 * To change this template use File | Settings | File Templates.
 */
public class OrionProcessing {
    private boolean useProxy;
    private String ip;
    private int port;

    public OrionProcessing(boolean useProxy, String ip, int port) {
        this.useProxy = useProxy;
        this.ip = ip;
        this.port = port;
    }

    public String convertUrl(String inputUrl) {
        String url = "";
        Pattern pat = Pattern.compile("(.*grupp=)(.+)(&tab.*)");
        Matcher mat = pat.matcher(inputUrl);
        if (mat.find()) {
            try {
                url = mat.group(1) + URLEncoder.encode(mat.group(2), "WINDOWS-1251") + mat.group(3);
            } catch (UnsupportedEncodingException ex) {
                url = inputUrl;
            }
        } else {
            url = inputUrl;
        }

        return url;
    }

    private Map<String, String> getPtLinks() {

        Map<String, String> links = new HashMap<String, String>();

        XmlPullParser xpp = FactoryHTTPData2XmlParser.getInstance().getHttpData2Xpp().getXpp("http://optvideo.com/new_design/new_kat/katalog.php", "Windows-1251", "UTF-8", useProxy, ip + ":" + port);

        try {
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {

                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("a") //
                        && xpp.getAttributeCount() == 3 //
                        && xpp.getAttributeValue(0).equals("rect")
                        && xpp.getAttributeName(1).equals("title")
                        && xpp.getAttributeName(2).equals("href")) {
                    links.put(xpp.getAttributeValue(1).trim(), xpp.getAttributeValue(2).trim() + "&selind_sort=2");
                }
                eventType = xpp.next();
            }
        } catch (Exception ex) {
        }
        System.gc();
        return links;
    }

    private Map<String, String> getPtFullLinks(Map<String, String> ptLinks) {
        Map<String, String> links = new HashMap<String, String>();

        Set<String> pts = ptLinks.keySet();

        XmlPullParser xpp = null;
        int eventType;

        boolean process = true;

        String url = "";
        boolean urlBool = false;

        for (String pt : pts) {
            xpp = FactoryHTTPData2XmlParser.getInstance().getHttpData2Xpp().getXpp(convertUrl(ptLinks.get(pt)), "Windows-1251", "UTF-8", useProxy, ip + ":" + port);
            process = true;
            try {
                eventType = xpp.getEventType();
                while (eventType != XmlPullParser.END_DOCUMENT) {

                    if (eventType == XmlPullParser.START_TAG //
                            && xpp.getName().equals("a") //
                            && xpp.getAttributeCount() == 3 //
                            && xpp.getAttributeValue(0).equals("rect")
                            && xpp.getAttributeName(1).equals("class")
                            && xpp.getAttributeName(2).equals("href")) {
                        url = "http://optvideo.com/new_design/new_kat/"
                                + xpp.getAttributeValue(2).trim()
                                + "&selind_sort=2";
                        urlBool = true;
                    }

                    if (eventType == XmlPullParser.TEXT && urlBool && process) {
                        links.put(pt + " - " + xpp.getText().trim(), convertUrl(url));
                    }

                    if (eventType == XmlPullParser.END_TAG && xpp.getName().equals("a") && urlBool) {
                        urlBool = false;
                    }

                    if (eventType == XmlPullParser.TEXT && process) {
                        if (xpp.getText().trim().equals("Бренды")) {
                            process = false;
                        }
                    }
                    eventType = xpp.next();

                }
                url = "";
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("");
        }
        return links;
    }

    private List<String> getProductLinksBYUrl(String inputUrl) {
        List<String> links = new ArrayList<String>();

        String url = "";

        XmlPullParser xpp = FactoryHTTPData2XmlParser.getInstance().getHttpData2Xpp().getXpp(inputUrl, "Windows-1251", "UTF-8", useProxy, ip + ":" + port);

        try {
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {

                if (eventType == XmlPullParser.START_TAG //
                        && xpp.getName().equals("a") //
                        && xpp.getAttributeCount() == 5 //
                        && xpp.getAttributeValue(0).equals("rect")
                        && xpp.getAttributeName(1).equals("class")
                        && xpp.getAttributeName(2).equals("target")) {
                    links.add(xpp.getAttributeValue(4).trim());
                }

                eventType = xpp.next();
                url = "";
            }
        } catch (Exception ex) {
        }

        return links;
    }

    public boolean startGrabbing() {
        Map<String, String> ptLinks = getPtFullLinks(getPtLinks());
        return true;
    }
}

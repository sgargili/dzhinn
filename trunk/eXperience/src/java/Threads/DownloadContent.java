/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Threads;

/**
 *
 * @author root
 */
import DAO.FactoryNixDAO;
import Pojo.Nixdata;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class DownloadContent {
    private String fullName;
    private String manufacturer;
    private String article;
    private String groupe;
    private String attribute;
    private String attributeValue;
    static int bayan = 0;

    public String DownloadContent(String url, String pt, String filename) throws IOException, XmlPullParserException, SQLException {
        HttpClient client = new HttpClient();
        client.getHostConfiguration().setProxy("127.0.0.1", 8118);
        String inputLine = "";
        String allString = "";
        String outputString = "";
        GetMethod getMethod = null;
        try {
            getMethod = new GetMethod(url);
            int getResult = client.executeMethod(getMethod);
            InputStream result = getMethod.getResponseBodyAsStream();
            InputStreamReader isr = new InputStreamReader(result, "WINDOWS-1251");
            BufferedReader in = new BufferedReader(isr);
            while ((inputLine = in.readLine()) != null) {
                allString += inputLine;
            }
            String re = "id='goods_name'>(.*?)</h1>";
            Pattern p = Pattern.compile(re);
            Matcher m = p.matcher(allString);
            if (m.find()) {
                fullName = m.group(1);
            }
            re = "temp_good_id=(\\d+)";
            p = Pattern.compile(re);
            m = p.matcher(allString);
            if (m.find()) {
                article = m.group(1);
            }
            re = "(id=\"PriceTable\".*?</table>)";
            p = Pattern.compile(re);
            m = p.matcher(allString);
            if (m.find()) {
                outputString = "<?xml version=\"1.0\" encoding=\"WINDOWS-1251\"?>" +
                        "<table fullname=\"" +
                        fullName +
                        "\" " +
                        "article=\"" +
                        article +
                        "\" " +
                        m.group();//&
                outputString = outputString.replaceAll("(&nbsp;)|(&lt;)|(&gt;)", " ");
                outputString = outputString.replaceAll("&quot;", "inch ");
                outputString = outputString.replaceAll("<tr>.*?price_container'>", "");
                outputString = outputString.replaceAll("target=new", "");
                outputString = outputString.replaceAll("([|].*?<a.*?</a>)|(<a.*?</a>)", "");
                outputString = outputString.replaceAll("\\s+", " ");
                outputString = outputString.replaceAll("<tr>.*?юмориста.*?tr>", " ");
                outputString = outputString.replaceAll("&", "and");
            }
            in.close();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        // FileUtils.writeStringToFile(new File(filename), outputString);
//        fullName = "";
//        article = "";
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        xpp.setInput(new StringReader(outputString));
        Nixdata ptl;
        List<Nixdata> nixdataList = new ArrayList<Nixdata>();
        boolean gbool = false, abool = false, vbool = false;
        try {
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {
                    if (xpp.getName().equals("table")) {
                        fullName = xpp.getAttributeValue(0);
                        article = xpp.getAttributeValue(1);
                    } else if (xpp.getName().equals("td") && xpp.getAttributeValue(0).equals("e")) {
                        gbool = true;
                    } else if (xpp.getName().equals("td") && xpp.getAttributeValue(0).equals("desc_property")) {
                        abool = true;
                    } else if (xpp.getName().equals("td") && xpp.getAttributeValue(0).equals("desc_desc")) {
                        vbool = true;
                    }
                } else if (eventType == XmlPullParser.TEXT) {
                    if (gbool && !abool && !vbool) {
                        groupe = xpp.getText().trim();
                    } else if (abool) {
                        attribute = xpp.getText().trim();
                    } else if (vbool) {
                        attributeValue = xpp.getText().trim();
                    }
                } else if (eventType == XmlPullParser.END_TAG) {
                    if (xpp.getName().equals("td") && gbool) {
                        gbool = false;
                    } else if (xpp.getName().equals("td") && abool) {
                        abool = false;
                    } else if (xpp.getName().equals("td") && vbool) {
                        vbool = false;
                        ptl = new Nixdata();
                        ptl.setFullName(fullName);
                        ptl.setManufacturer("NoName");
                        ptl.setArticle(article);
                        ptl.setProductType(pt);
                        ptl.setPictureUrl("NoPics");
                        ptl.setGroupe(pt + " - " + groupe);
                        ptl.setAttribute(attribute);
                        ptl.setAttributeValue(attributeValue);
                        nixdataList.add(ptl);
                    }
                }
                eventType = xpp.next();


            }
        } catch (XmlPullParserException e) {
            ptl = new Nixdata();
            ptl.setFullName("Что то упало в парсере, смотри вот тут: " + e.getMessage());
            ptl.setManufacturer(e.getMessage());
            ptl.setArticle(article);

            nixdataList.add(ptl);
        } catch (Exception e) {
            ptl = new Nixdata();
            ptl.setFullName("Что то упало в парсере, смотри вот тут: " + e.getMessage());
            ptl.setManufacturer(e.getMessage());
            ptl.setArticle(article);

            nixdataList.add(ptl);
        }
        manufacturer = "NoName";
        for (Iterator it = nixdataList.iterator(); it.hasNext();) {
            Nixdata ndt = (Nixdata) it.next();
            try {
                if (ndt.getAttribute().equals("Производитель")) {
                    manufacturer = ndt.getAttributeValue();
                    break;
                }
            } catch (Exception e) {
            }
        }
        int i = 0;
        for (Iterator it = nixdataList.iterator(); it.hasNext();) {
            Nixdata ndt = (Nixdata) it.next();
            try {
                ndt.setManufacturer(manufacturer);
                nixdataList.set(i, ndt);
                FactoryNixDAO.getInstance().getNixdataDAO().addNixdata(nixdataList.get(i));
                i++;
            } catch (Exception e) {
            }
        }


        return outputString;
    }

}

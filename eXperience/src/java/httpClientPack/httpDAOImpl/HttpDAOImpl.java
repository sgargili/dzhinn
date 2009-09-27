/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpClientPack.httpDAOImpl;

import Pojo.Manufacturer;
import Pojo.ProductType;
import httpClientPack.httpDAO.HttpDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 *
 * @author APopov
 */
public class HttpDAOImpl implements HttpDAO {

    private HttpClient client = new HttpClient();

    @Override
    public boolean Login4Value(String Login, String Password) {
        boolean output = false;
        String st_url = "https://www.value4it.com/login/authorize2.jsp";
        PostMethod method = new PostMethod(st_url);
        method.setParameter("USERNAME", Login);
        method.setParameter("PASSWORD", Password);
        method.setParameter("btlogin", "SIGN-IN");
        try {
            int returnCode = client.executeMethod(method);
            output = true;
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            method.releaseConnection();
        }
        return output;
    }

    @Override
    public boolean Logout4Value() {
        boolean output = false;
        String url = "https://www.value4it.com/login/logout.jsp";
        GetMethod getMethod = new GetMethod(url);
        try {
            int getResult = client.executeMethod(getMethod);
            output = true;
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        return output;
    }

    @Override
    public String DownloadFromValue(String url) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection DownloadManufacturersFromValue() throws XmlPullParserException, IOException {
        boolean bool = false;
        String url = "https://www.value4it.com/cf/admin/search_panel_articles.jsp";
        String inputLine = "";
        String allString = "";
        String outputString = "";
        List<Manufacturer> MNList = new ArrayList<Manufacturer>();
        GetMethod getMethod = new GetMethod(url);
        try {
            int getResult = client.executeMethod(getMethod);
            InputStream result = getMethod.getResponseBodyAsStream();
            InputStreamReader isr = new InputStreamReader(result, "UTF-8");
            BufferedReader in = new BufferedReader(isr);
            while ((inputLine = in.readLine()) != null) {
                allString += inputLine;
            }
            String re = "(name=.VENDOR.*?</select>)";
            Pattern p = Pattern.compile(re);
            Matcher m = p.matcher(allString);
            if (m.find()) {
                outputString = "<select " + m.group();
                outputString = outputString.replaceAll("selected", "");
                outputString = outputString.replaceAll("&.*?;", "");
            }
            in.close();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        XmlPullParserFactory factory = factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        xpp.setInput(new StringReader(outputString));
        int eventType = xpp.getEventType();
        Manufacturer manu = null;
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("option")) {
                manu = new Manufacturer();
                bool = true;
                if (!xpp.getAttributeValue(0).equals("")) {
                    manu.setManufacturerId(Long.parseLong(xpp.getAttributeValue(0)));
                }
            } else if (eventType == XmlPullParser.TEXT && bool && !xpp.getText().equals("--- Any ---")) {
                manu.setManufacturerName(xpp.getText());
                MNList.add(manu);
            } else if (eventType == XmlPullParser.END_TAG) {
                bool = false;
            }
            eventType = xpp.next();
        }

        return MNList;
    }

    @Override
    public boolean Login4Profit(String Login, String Password) {
        boolean output = false;
        String st_url = "https://www.it4profit.com/login/authorize2.jsp";
        PostMethod method = new PostMethod(st_url);
        method.setParameter("USERNAME", Login);
        method.setParameter("PASSWORD", Password);
        method.setParameter("btlogin", "SIGN-IN");

        try {
            int returnCode = client.executeMethod(method);
            output = true;
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            method.releaseConnection();
        }
        return output;
    }

    @Override
    public boolean Logout4Profit() {
        boolean output = false;
        String url = "https://www.it4profit.com/login/logout.jsp";
        GetMethod getMethod = new GetMethod(url);
        try {
            int getResult = client.executeMethod(getMethod);
            output = true;
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        return output;
    }

    @Override
    public String DownloadFromProfit(String url) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection DownloadPTFromProfit() throws XmlPullParserException, IOException {
        boolean bool = false;
        String url = "https://www.it4profit.com/pd/adminArticleAdd.jsp";
        String inputLine = "";
        String allString = "";
        String outputString = "";
        List<ProductType> PTList = new ArrayList<ProductType>();
        GetMethod getMethod = new GetMethod(url);
        try {
            int getResult = client.executeMethod(getMethod);
            InputStream result = getMethod.getResponseBodyAsStream();
            InputStreamReader isr = new InputStreamReader(result, "UTF-8");
            BufferedReader in = new BufferedReader(isr);
            while ((inputLine = in.readLine()) != null) {
                allString += inputLine;
            }
            String re = "(<select.*name=.PT.*?</select>)";
            Pattern p = Pattern.compile(re);
            Matcher m = p.matcher(allString);
            if (m.find()) {
                outputString = m.group();
                outputString = outputString.replaceAll("selected", "");
            }
            in.close();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        XmlPullParserFactory factory = factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        xpp.setInput(new StringReader(outputString));
        int eventType = xpp.getEventType();
        ProductType PT = null;
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("option")) {
                PT = new ProductType();
                bool = true;
                if (!xpp.getAttributeValue(0).equals("")) {
                    PT.setProductTypeId(Long.parseLong(xpp.getAttributeValue(0)));
                }
            } else if (eventType == XmlPullParser.TEXT && bool && !xpp.getText().equals("--- Any ---")) {
                PT.setProductTypeName(xpp.getText());
                PTList.add(PT);
            } else if (eventType == XmlPullParser.END_TAG) {
                bool = false;
            }
            eventType = xpp.next();
        }

        return PTList;
    }

    @Override
    public String DownloadContent(String url) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

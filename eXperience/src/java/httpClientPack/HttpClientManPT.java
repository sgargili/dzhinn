/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpClientPack;

import DAO.FactoryDAO;
import Pojo.Manufacturer;
import Pojo.ProductType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import processing.ArrayDuplDel;

/**
 *
 * @author Admin4DB2
 */
public class HttpClientManPT {

    private HttpClient client = new HttpClient();

    private String Login() {
        String st_url = "https://www.it4profit.com/login/authorize2.jsp";
        PostMethod method = new PostMethod(st_url);
        method.setParameter("USERNAME", "andreypopov");
        method.setParameter("PASSWORD", "Andrey1602");
        method.setParameter("btlogin", "SIGN-IN");

        try {
            int returnCode = client.executeMethod(method);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            method.releaseConnection();
        }
        return "";
    }

    private void LogOut() {
        String url = "https://www.it4profit.com/login/logout.jsp";
        GetMethod getMethod = new GetMethod(url);
        try {
            int getResult = client.executeMethod(getMethod);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
    }

    @SuppressWarnings("static-access")
    public String getManPt() throws SQLException, XmlPullParserException, IOException {
        // client.getParams().setContentCharset("UTF-8");
        Login();
        FactoryDAO fDao = FactoryDAO.getInstance();
        String url = "https://www.it4profit.com/pd/adminArticleAdd.jsp";
        String inputLine = "";
        String allString = "";
        String allString2 = "", allString3 = "";

        List<ProductType> list1 = new ArrayList<ProductType>();
        List<Manufacturer> list2 = new ArrayList<Manufacturer>();
        GetMethod getMethod = new GetMethod(url);
        //  getMethod.getParams().setContentCharset("UTF-8");
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
                allString2 = m.group();
                allString2 = allString2.replaceAll("selected", "");
                // allString2 = allString2.replaceAll("&amp;", "&");
            }
            allString = allString.replaceAll(re, "");
            String re2 = "(<select.*?name=.MNF.*?</select>)";
            Pattern p2 = Pattern.compile(re2);
            Matcher m2 = p2.matcher(allString);
            if (m2.find()) {
                allString3 = m2.group();
                allString3 = allString3.replaceAll("selected", "");
                allString3 = allString3.replaceAll("&.*?;", "|||");
            }

            in.close();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        xpp.setInput(new StringReader(allString2));
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if ((eventType == XmlPullParser.START_TAG) && xpp.getName().equals("option")) {
                try {
                    list1.add(new ProductType(Long.parseLong(xpp.getAttributeValue(0)), xpp.nextText()));
                } catch (Exception e) {
                    list1.add(new ProductType(Long.parseLong(xpp.getAttributeValue(0)), e.getMessage()));
                }
            }
            eventType = xpp.next();
        }

        XmlPullParser xpp2 = factory.newPullParser();
        xpp2.setInput(new StringReader(allString3));
        eventType = xpp2.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if ((eventType == XmlPullParser.START_TAG) && xpp2.getName().equals("option")) {
                list2.add(new Manufacturer(Long.parseLong(xpp2.getAttributeValue(0)), xpp2.nextText()));
            }
            eventType = xpp2.next();
        }
        Iterator iterator = list2.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Manufacturer MN = (Manufacturer) iterator.next();
            if (MN.getManufacturerName().equals("")) {
                continue;
            }
            if (!fDao.getManufacturerDAO().isManufacturerPresent(MN.getManufacturerName())) {
                fDao.getManufacturerDAO().addManufacturer(MN);
            } else {
                fDao.getManufacturerDAO().updateManufacturer(MN);
            }
            System.out.println(MN.getManufacturerId() + " " + MN.getManufacturerName());
            i++;
        }
        iterator = list1.iterator();
        i = 0;
        while (iterator.hasNext()) {
            ProductType PT = (ProductType) iterator.next();
            if (PT.getProductTypeName().equals("")) {
                continue;
            }
            if (!fDao.getProduct_TypeDAO().isProduct_Type_IdPresent(PT.getProductTypeId())) {
                fDao.getProduct_TypeDAO().addProduct_Type(PT);
            } else {
                PT.setId(fDao.getProduct_TypeDAO().getIdByProduct_Type_Id(PT.getProductTypeId()));
                fDao.getProduct_TypeDAO().updateProduct_Type(PT);
            }
        }
        LogOut();
        return "Done...";
    }

    public String getAllManPt() throws SQLException, XmlPullParserException, IOException {
        FactoryDAO fDao = FactoryDAO.getInstance();
        String inputLine, allString = "";
        // client.getParams().setContentCharset("UTF-8");
        //client.getParams().setContentCharset("UTF-8");

        String url = "http://localhost:8084/Manufacturers.xml";
        List<Manufacturer> list = new ArrayList<Manufacturer>();
        GetMethod getMethod = new GetMethod(url);
        // getMethod.getParams().setContentCharset("WINDOWS-1251");
        try {
            int getResult = client.executeMethod(getMethod);
//            allString = getMethod.getResponseBodyAsString();
            InputStream result = getMethod.getResponseBodyAsStream();
            InputStreamReader isr = new InputStreamReader(result, "UTF-8");
            BufferedReader in = new BufferedReader(isr);

            while ((inputLine = in.readLine()) != null) {
                allString += inputLine;
            }
            in.close();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        xpp.setInput(new StringReader(allString));
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if ((eventType == XmlPullParser.START_TAG) && xpp.getName().equals("node")) {
                list.add(new Manufacturer(Long.parseLong(xpp.getAttributeValue(0)), xpp.getAttributeValue(1)));
            }
            eventType = xpp.next();
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Manufacturer Man = (Manufacturer) iterator.next();
            if (!fDao.getManufacturerDAO().isManufacturerPresent(Man.getManufacturerName())) {
//                fDao.getManufacturerDAO().updateManufacturer(Man);
//            } else {
                fDao.getManufacturerDAO().addManufacturer(Man);
            }
        }
        return "Done...";
    }

    public String getAllManPtNew() throws SQLException, XmlPullParserException, IOException {
        FactoryDAO fDao = FactoryDAO.getInstance();
        String inputLine, allString = "";
        String url = "http://localhost:8084/Trees.xml";
        Set<ProductType> list = new LinkedHashSet<ProductType>();
        GetMethod getMethod = new GetMethod(url);
        try {
            int getResult = client.executeMethod(getMethod);
            InputStream result = getMethod.getResponseBodyAsStream();
            InputStreamReader isr = new InputStreamReader(result, "UTF-8");
            BufferedReader in = new BufferedReader(isr);

            while ((inputLine = in.readLine()) != null) {
                allString += inputLine;
            }
            in.close();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        xpp.setInput(new StringReader(allString));
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if ((eventType == XmlPullParser.START_TAG) && xpp.getName().equals("node")) {
                list.add(new ProductType(Long.parseLong(xpp.getAttributeValue(0)), xpp.getAttributeValue(4)));
            }
            eventType = xpp.next();
        }
        Iterator iterator = list.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            ProductType Man = (ProductType) iterator.next();
//            if (!fDao.getManufacturerDAO().isManufacturerPresent(Man.getManufacturerName())) {
////                fDao.getManufacturerDAO().updateManufacturer(Man);
////            } else {
//                fDao.getManufacturerDAO().addManufacturer(Man);
//            }
            System.out.println(Man.getProductTypeId() + " " + Man.getProductTypeName());
            i++;
        }
        System.out.println(i);
        allString = "";
        inputLine = "";
        String url2 = "http://localhost:8084/ItemsInNode.xml";
        Set<ProductType> list2 = new LinkedHashSet<ProductType>();
        GetMethod getMethod2 = new GetMethod(url2);
        try {
            int getResult2 = client.executeMethod(getMethod2);
            InputStream result2 = getMethod2.getResponseBodyAsStream();
            InputStreamReader isr2 = new InputStreamReader(result2, "UTF-8");
            BufferedReader in2 = new BufferedReader(isr2);

            while ((inputLine = in2.readLine()) != null) {
                allString += inputLine;
            }
            in2.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            getMethod2.releaseConnection();
        }
        factory = XmlPullParserFactory.newInstance();
        xpp = factory.newPullParser();
        xpp.setInput(new StringReader(allString));
        eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if ((eventType == XmlPullParser.START_TAG) && xpp.getName().equals("nodeItem")) {
                list2.add(new ProductType(Long.parseLong(xpp.getAttributeValue(0))));
            }
            eventType = xpp.next();
        }
        iterator = list2.iterator();
        i = 0;
        String[] tempArray = new String[list2.size()];

        while (iterator.hasNext()) {
            ProductType Man2 = (ProductType) iterator.next();
            tempArray[i] = "" + Man2.getProductTypeId();
//            ProductType Man2 = (ProductType) iterator.next();
//            System.out.println(Man2.getProductTypeId());
            i++;
        }
        ArrayDuplDel add = new ArrayDuplDel();
        String[] newtempArray = add.ArrayDuplDel(tempArray);
        i = newtempArray.length;

        System.out.println(i);

//        String[] tempArray = (String[]) list2.toArray();
//        ArrayDuplDel add = new ArrayDuplDel();
//        String[] newtempArray = add.ArrayDuplDel(tempArray);
//        i = newtempArray.length;
        return "Done " + i;
    }
}

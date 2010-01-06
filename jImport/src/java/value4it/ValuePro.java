/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package value4it;

import DAO.FactoryDAO;
import HttpClient.http;
import Pojo.Cookies;
import Pojo.ValueArticle;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 *
 * @author Apopov
 */
public class ValuePro {

    private HttpClient client = new HttpClient();

    public void login() {
        if (!isSessionAlive()) {
            String st_url = "http://cf.value4it.com/login/authorize2.jsp";
            PostMethod method = new PostMethod(st_url);
            method.setParameter("USERNAME", "apopov");
            method.setParameter("PASSWORD", "Andrey1602");
            method.setParameter("btlogin", "SIGN-IN");
            try {
                int returnCode = client.executeMethod(method);
                setCookie();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                method.releaseConnection();
            }
        } else {
            getCookie();
        }
    }

    public void logout() {
        String url = "http://cf.value4it.com/login/logout.jsp";
        GetMethod getMethod = new GetMethod(url);
        try {
            int getResult = client.executeMethod(getMethod);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            getMethod.releaseConnection();
        }
    }

    private void updateSessionTime() {
        setCookie();
    }

    public String setCookie() {
        String cookie = "";
        Cookie[] cookies = client.getState().getCookies();
        for (int i = 0; i < cookies.length; i++) {
            cookie += cookies[i];
        }
        if (!cookie.equals("") && cookie != null) {
            Cookies cs = new Cookies();
            cs.setId(1);
            cs.setCookie(cookie);
            cs.setTime(System.currentTimeMillis());
            try {
                FactoryDAO.getInstance().getCookiesDAO().addCookies(cs);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return cookie;
    }

    public boolean getCookie() {
        boolean out = false;
        try {
            HttpState initialState = new HttpState();
            Cookie mycookie = new Cookie();
            mycookie.setDomain("cf.value4it.com");
            mycookie.setPath("/");
            mycookie.setName("JSESSIONID");
            mycookie.setValue(FactoryDAO.getInstance().getCookiesDAO().getCookies(1)//
                    .replaceAll("JSESSIONID=", "")//
                    .replaceAll(":-1", ""));//
            initialState.addCookie(mycookie);
            client.setState(initialState);
            out = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return out;
    }

    public boolean isSessionAlive() {
        boolean out = false;
        try {
            long sessionTime = FactoryDAO.getInstance().getCookiesDAO().getCookiesTime(1);
            long nowTime = System.currentTimeMillis();
            if ((nowTime - sessionTime) < 1799999) {
                out = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return out;
    }

//    public String DownloadContentAsString(String url, String encoding) {
//        login();
//        //String url = "http://213.53.57.20/ShopIX/exportFullXML.jsp?shopId=74";
//        String allString = "";
//        GetMethod getMethod = new GetMethod(url);
//        getMethod.setFollowRedirects(false);
////        Cookie[] cookies = client.getState().getCookies();
////        //System.out.println("Present cookies: ");
////        for (int i = 0; i < cookies.length; i++) {
////            System.out.println("\"" + cookies[i] + "\"");
////        }
//        try {
//            int getResult = client.executeMethod(getMethod);
//            System.out.println(getResult);
//            System.out.println(HttpStatus.SC_TEMPORARY_REDIRECT);
//            allString = IOUtils.toString(getMethod.getResponseBodyAsStream(), encoding);
//            allString = allString.replaceAll("Error 500:.*", "<?xml version=\"1.0\" encoding=\"UTF-8\"?><itemCard></itemCard>");
//        } catch (Exception e) {
//            System.err.println(e);
//        } finally {
//            getMethod.releaseConnection();
//        }
//        return allString;
//    }
    private String export(List articlesData, boolean isRuEn) {
        NameValuePair[] req;
        ValueArticle va;
        String url = "http://cf.value4it.com/cf/admin/export_product.jsp";
        String out = buildResponse(articlesData, "Export");
        boolean process = false;
        List exportData = new ArrayList();
        for (Iterator it = articlesData.iterator(); it.hasNext();) {
            va = (ValueArticle) it.next();
            if (!va.getArticleId().equals("Empty") //
                    && !va.getArticle().equals("Empty")//
                    && !va.getArticle().equals("")//
                    && va.getArticle() != null//
                    && !va.getArticleId().equals("")//
                    && va.getArticleId() != null) {
                process = true;
                exportData.add(va);
            }
        }
        if (process) {
            login();
            try {
                PostMethod getMethod = new PostMethod(url);
                int i = 0;
                if (isRuEn) {
                    req = new NameValuePair[7 + exportData.size()];
                    req[0] = new NameValuePair("referer", "");
                    req[1] = new NameValuePair("FACTORY_ID", "137");
                    req[2] = new NameValuePair("ACTION", "EXPORT");
                    req[3] = new NameValuePair("PN_RPP", "100");
                    req[4] = new NameValuePair("LANGS", "");
                    req[5] = new NameValuePair("LANG", "en");
                    req[6] = new NameValuePair("LANG", "ru");
                    for (Iterator it = exportData.iterator(); it.hasNext();) {
                        va = (ValueArticle) it.next();
                        req[7 + i++] = new NameValuePair("ID_" + va.getArticleId(), va.getArticleId());
                        // System.out.println("Прошло!!! -> " + va.getArticleId());
                    }
                } else {
                    req = new NameValuePair[11 + exportData.size()];
                    req[0] = new NameValuePair("referer", "");
                    req[1] = new NameValuePair("FACTORY_ID", "137");
                    req[2] = new NameValuePair("ACTION", "EXPORT");
                    req[3] = new NameValuePair("PN_RPP", "100");
                    req[4] = new NameValuePair("LANGS", "");
                    req[5] = new NameValuePair("LANG", "bg");
                    req[6] = new NameValuePair("LANG", "hr");
                    req[7] = new NameValuePair("LANG", "en");
                    req[8] = new NameValuePair("LANG", "pl");
                    req[9] = new NameValuePair("LANG", "ru");
                    req[10] = new NameValuePair("LANG", "sl");
                    for (Iterator it = exportData.iterator(); it.hasNext();) {
                        va = (ValueArticle) it.next();
                        req[11 + i++] = new NameValuePair("ID_" + va.getArticleId(), va.getArticleId());
                    }
                }
                getMethod.setRequestBody(req);
                int getResult = client.executeMethod(getMethod);
                getMethod.releaseConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            updateSessionTime();
        }
        return out;

    }

    private String exportMark(List articlesData) {
        NameValuePair[] req;
        ValueArticle va;
        String url = "http://cf.value4it.com/cf/admin/articles_admin.jsp";
        String out = buildResponse(articlesData, "Export Marketing");
        boolean process = false;
        List exportData = new ArrayList();
        for (Iterator it = articlesData.iterator(); it.hasNext();) {
            va = (ValueArticle) it.next();
            if (!va.getArticleId().equals("Empty") //
                    && !va.getArticle().equals("Empty")//
                    && !va.getArticle().equals("")//
                    && va.getArticle() != null//
                    && !va.getArticleId().equals("")//
                    && va.getArticleId() != null) {
                process = true;
                exportData.add(va);
            }
        }
        if (process) {
            login();
            try {
                PostMethod getMethod = new PostMethod(url);
                int i = 0;
                req = new NameValuePair[3 + 2 * exportData.size()];
                req[0] = new NameValuePair("POST_ACTION", "updateMarketing");
                req[1] = new NameValuePair("SOURCE", "");
                req[2] = new NameValuePair("NEW_OWNER_ID", "70919085040801266");
                for (Iterator it = exportData.iterator(); it.hasNext();) {
                    va = (ValueArticle) it.next();
                    req[3 + i++] = new NameValuePair("ID_" + va.getArticleId(), va.getArticleId());
                    req[3 + i++] = new NameValuePair("TARGET_" + va.getArticleId(), va.getArticleId());
                }
                getMethod.setRequestBody(req);
                int getResult = client.executeMethod(getMethod);
                getMethod.releaseConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            updateSessionTime();
        }
        return out;

    }

    private String[] splitString(String inputString) {
        String[] outputStringArray = null;
        String splitPattern = "\\|\\|\\|";
        if (!inputString.equals("")) {
            outputStringArray = inputString.split(splitPattern);
        }
        return outputStringArray;
    }

    public boolean isArticle(String article) {
        Pattern p = Pattern.compile("\\d{17}");
        Matcher m = p.matcher(article);
        if (m.matches()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isAllIds(String[] articles) {
        boolean out = false;
        Pattern p = Pattern.compile("\\d{17,18}");
        Matcher m;
        for (int i = 0; i < articles.length; i++) {
            m = p.matcher(articles[i]);
            if (m.matches()) {
                out = true;
            } else {
                return false;
            }
        }
        return out;
    }

    public List getArtclesIdByArticles(String[] articles) throws XmlPullParserException, UnsupportedEncodingException, IOException {

        http http = new http();
        XmlPullParserFactory factory = factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();

        List out = new ArrayList();
        Set<String> strSet = new HashSet();
        ValueArticle va;
        String urlPattern = "";

        for (int i = 0; i < articles.length; i++) {
            strSet.add(articles[i]);
        }
        for (Iterator it = strSet.iterator(); it.hasNext();) {
            urlPattern += (String) it.next() + ";";
        }
        File xml = http.DownloadContentAsFile("http://213.53.57.39/cfInfoWS/cfcode.exml?article=" + urlPattern);

        xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), "UTF-8"));
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("article")) {
                if (strSet.contains(xpp.getAttributeValue(2).trim())) {
                    va = new ValueArticle(xpp.getAttributeValue(2).trim(), xpp.getAttributeValue(0));
                    out.add(va);
                    strSet.remove(xpp.getAttributeValue(2).trim());
                }
            }
            eventType = xpp.next();
        }
        for (Iterator it = strSet.iterator(); it.hasNext();) {
            va = new ValueArticle((String) it.next(), "Empty");
            out.add(va);
        }
        return out;
    }

    public List getArtclesByArticlesId(String[] articlesId) throws XmlPullParserException, UnsupportedEncodingException, IOException {

        http http = new http();
        XmlPullParserFactory factory = factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();

        List out = new ArrayList();
        Set<String> strSet = new HashSet();
        ValueArticle va;
        String urlPattern = "";

        for (int i = 0; i < articlesId.length; i++) {
            strSet.add(articlesId[i]);
        }
        for (Iterator it = strSet.iterator(); it.hasNext();) {
            urlPattern += (String) it.next() + ";";
        }
        File xml = http.DownloadContentAsFile("http://213.53.57.39/cfInfoWS/cf.exml?article=" + urlPattern.replaceAll(";$", ""));

        xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), "UTF-8"));
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("article")) {
                if (strSet.contains(xpp.getAttributeValue(0).trim())) {
                    va = new ValueArticle(xpp.getAttributeValue(2).trim(), xpp.getAttributeValue(0));
                    out.add(va);
                    strSet.remove(xpp.getAttributeValue(0).trim());
                }
            }
            eventType = xpp.next();
        }
        for (Iterator it = strSet.iterator(); it.hasNext();) {
            va = new ValueArticle("Empty", (String) it.next());
            out.add(va);
        }
        return out;
    }

    public String buildResponse(List articlesData, String requestAction) {
        ValueArticle va;
        int i = 1;
        String out = "<table bgcolor=black align=center cellspacing='1' cellpadding='1' border=0 width=98%>"//
                + "<tr bgcolor = #2d4491 align=center>"//
                + "<td>"//
                + "<font color=white>#</font>"//
                + "</td>"//
                + "<td>"//
                + "<font color=white>Article</font>"//
                + "</td>"//
                + "<td>"//
                + "<font color=white>Exist</font>"//
                + "</td>"//
                + "<td>"//
                + "<font color=white>ArticleID</font>"//
                + "</td>"//
                + "<td>"//
                + "<font color=white>Request Action</font>"//
                + "</td>"//
                + "<td>"//
                + "<font color=white>Request Status</font>"//
                + "</td>"//
                + "</tr>";//
        for (Iterator it = articlesData.iterator(); it.hasNext();) {
            va = (ValueArticle) it.next();
            out += "<tr bgcolor = #cfcdcd>"//
                    + " <td style='padding-left:4px; text-align: center'>"//
                    + i++//
                    + "</td>"//
                    + " <td style='padding-left:4px; text-align: center'>"//
                    + (!va.getArticle().equals("Empty") ? va.getArticle() : "<font color=red>-</font>")//
                    + "</td>"//
                    + "<td style='padding-left:4px; text-align: center'>"//
                    + (!va.getArticleId().equals("Empty") && !va.getArticle().equals("Empty") ? "Yes" : "<font color=red>No</font>")//
                    + "</td>"//
                    + "<td style='padding-left:4px; text-align: center'>"//
                    + (!va.getArticleId().equals("Empty") ? va.getArticleId() : "<font color=red>-</font>")//
                    + "</td>"//
                    + "<td style='padding-left:4px; text-align: center'>"//
                    + requestAction//
                    + "</td>"//
                    + "<td style='padding-left:4px; text-align: center'>"//
                    + (!va.getArticleId().equals("Empty") && !va.getArticle().equals("Empty") ? "Passed" : "<font color=red>-</font>")//
                    + "</td>"//
                    + "</tr>";//
        }
        out += "</table>";
        return out;
    }

    public String exportByProducts(String products, boolean ruEnBool) {
        if (products == null || products.equals("")) {
            return "Введите Articles или ArticlesId...";
        }
        String[] temp = splitString(products);
        Pattern p = Pattern.compile("[А-Яа-я]");
        Matcher m;
        for (int i = 0; i < temp.length; i++) {
            m = p.matcher(temp[i]);
            if (m.find()) {
                return "Русские символы в строке <b>" + (i + 1) + "</b> -> <b>" + temp[i] + "</b>";
            }
        }
        String out = "Ошибка...";
        ValueArticle va;
        List data = new ArrayList();
        try {
            if (isArticle(temp[0])) {
                data = getArtclesIdByArticles(temp);
            } else if (isAllIds(temp)) {
                data = getArtclesByArticlesId(temp);
            } else {
                return "Введите однотипные данные, либо только Articles, либо ArticlesId...";
            }
            out = export(data, ruEnBool);
        } catch (Exception ex) {
            out = ex.getMessage();
        }
        return out;
    }

    public String exportMarketing(String products) {
        if (products == null || products.equals("")) {
            return "Введите Articles или ArticlesId...";
        }
        String[] temp = splitString(products);
        Pattern p = Pattern.compile("[А-Яа-я]");
        Matcher m;
        for (int i = 0; i < temp.length; i++) {
            m = p.matcher(temp[i]);
            if (m.find()) {
                return "Русские символы в строке <b>" + (i + 1) + "</b> -> <b>" + temp[i] + "</b>";
            }
        }
        String out = "Ошибка...";
        ValueArticle va;
        List data = new ArrayList();
        try {
            if (isArticle(temp[0])) {
                data = getArtclesIdByArticles(temp);
            } else if (isAllIds(temp)) {
                data = getArtclesByArticlesId(temp);
            } else {
                return "Введите однотипные данные, либо только Articles, либо ArticlesId...";
            }
            out = exportMark(data);
        } catch (Exception ex) {
            out = ex.getMessage();
        }
        return out;
    }
}

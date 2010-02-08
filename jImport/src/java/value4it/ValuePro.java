/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package value4it;

import DAO.FactoryDAO;
import HttpClient.http;
import Pojo.Cookies;
import Pojo.Logs;
import Pojo.ValueArticle;
import Pojo.ValueLink;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContextFactory;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 *
 * @author Apopov
 */
public class ValuePro {

    private HttpClient client = new HttpClient();
    final Calendar cal = Calendar.getInstance(TimeZone.getDefault());
    Logs log;
    private static Map ipMap = new HashMap();
    int count = 1;

    public void login() {
        if (!isSessionAlive()) {
            String st_url = "http://cf.value4it.com/login/authorize2.jsp";
            PostMethod method = new PostMethod(st_url);
            method.setParameter("USERNAME", "apopov");
            method.setParameter("PASSWORD", "Andrey1602");
            method.setParameter("btlogin", "SIGN-IN");
            try {
                client.getParams().setParameter(HttpMethodParams.USER_AGENT, "Http Java Client");
                int returnCode = client.executeMethod(method);
                log = new Logs();
                log.setLogType("Login. Create new Session.");
                log.setLogMessage(setCookie());
                log.setIp(WebContextFactory.get().getHttpServletRequest().getRemoteAddr());
                log.setLogTime(cal.get(Calendar.DATE) + "/"//
                        + cal.get(Calendar.MONTH) + "/"//
                        + cal.get(Calendar.YEAR) + " "//
                        + cal.get(Calendar.HOUR) + ":"//
                        + cal.get(Calendar.MINUTE) + ":"//
                        + cal.get(Calendar.SECOND));
                FactoryDAO.getInstance().getLogsDAO().addLogs(log);
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
            client.getParams().setParameter(HttpMethodParams.USER_AGENT, "Http Java Client");
            int getResult = client.executeMethod(getMethod);
            log = new Logs();
            log.setLogType("Logout.");
            log.setLogMessage("Just logout...");
            log.setIp(WebContextFactory.get().getHttpServletRequest().getRemoteAddr());
            log.setLogTime(cal.get(Calendar.DATE) + "/"//
                    + cal.get(Calendar.MONTH) + "/"//
                    + cal.get(Calendar.YEAR) + " "//
                    + cal.get(Calendar.HOUR) + ":"//
                    + cal.get(Calendar.MINUTE) + ":"//
                    + cal.get(Calendar.SECOND));
            FactoryDAO.getInstance().getLogsDAO().addLogs(log);
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

    private String export(List articlesData, String ip, boolean isRuEn) {
        String exportStr = "";
        int varCount = 0;
        NameValuePair[] req;
        ValueArticle va;
        ScriptSession ss;
        ScriptBuffer script;
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
                PostMethod getMethod;
//                int i;
//                System.out.println(exportData.size());
//                int n = 0;
//                int ost = 0;
//                if (exportData.size() % 10 == 0) {
//                    n = exportData.size() / 10;
//                } else {
//                    n = exportData.size() / 10 + 1;
//                    ost = exportData.size() % 10;
//                }
                try {
                    //for (int j = 0; j < n; j++) {
                    for (Iterator it = exportData.iterator(); it.hasNext();) {
                        ss = WebContextFactory.get().getScriptSession();
                        script = new ScriptBuffer();
                        try {
                            script.appendScript("updateProd(");
                            script.appendData(exportData.size());
                            script.appendScript(",");
                            script.appendData(count++);
                            script.appendScript(");");
                            ss.addScript(script);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        getMethod = new PostMethod(url);
//                        i = 0;
                        if (isRuEn) {
                            // Тупняк... Если, типа, итерация последняя, то количество зависит от остатка...
//                            if (j != n - 1) {
//                                req = new NameValuePair[17];
//                            } else {
//                                req = new NameValuePair[7 + ost];
//                            }
                            req = new NameValuePair[8];
                            req[0] = new NameValuePair("referer", "");
                            req[1] = new NameValuePair("FACTORY_ID", "137");
                            req[2] = new NameValuePair("ACTION", "EXPORT");
                            req[3] = new NameValuePair("PN_RPP", "100");
                            req[4] = new NameValuePair("LANGS", "");
                            req[5] = new NameValuePair("LANG", "en");
                            req[6] = new NameValuePair("LANG", "ru");
                            varCount = 7;
                            //for (int l = j * 10; l < (j + 1) * 10; l++) {
                            try {
                                va = (ValueArticle) it.next();
                                req[7] = new NameValuePair("ID_" + va.getArticleId(), va.getArticleId());
                                // System.out.println("Прошло!!! -> " + va.getArticleId());
                            } catch (Exception ex) {
                            }
                            //  }

                        } else {
//                            if (ost == 0) {
//                                req = new NameValuePair[21];
//                            } else {
//                                req = new NameValuePair[11 + ost];
//                            }
                            req = new NameValuePair[12];
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
                            varCount = 11;
                            //for (int l = j * 10; l < (j + 1) * 10; l++) {
                            try {
                                va = (ValueArticle) it.next();
                                req[11] = new NameValuePair("ID_" + va.getArticleId(), va.getArticleId());
                            } catch (Exception ex) {
                            }
                            //}
                        }
                        getMethod.setRequestBody(req);
                        client.getParams().setParameter(HttpMethodParams.USER_AGENT, "Bla-bla-bla...");
                        client.executeMethod(getMethod);
                        getMethod.releaseConnection();
                        //System.out.println("Длинна запроса -> " + req.length);
                        exportStr = "Size: " + (req.length - varCount) + " Body: ";
                        for (int k = 0; k < req.length; k++) {
                            exportStr += req[k].getName() + "=" + req[k].getValue() + "/";
                        }
                        log = new Logs();
                        log.setLogType("Export by Products.");
                        log.setLogMessage(exportStr);
                        log.setIp(WebContextFactory.get().getHttpServletRequest().getRemoteAddr());
                        log.setLogTime(cal.get(Calendar.DATE) + "/"//
                                + cal.get(Calendar.MONTH) + "/"//
                                + cal.get(Calendar.YEAR) + " "//
                                + cal.get(Calendar.HOUR) + ":"//
                                + cal.get(Calendar.MINUTE) + ":"//
                                + cal.get(Calendar.SECOND));
                        FactoryDAO.getInstance().getLogsDAO().addLogs(log);
                        Thread.sleep(300);
                        req = null;
                        getMethod = null;
                    }
                } catch (IndexOutOfBoundsException ex) {
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            updateSessionTime();
        }
        count = 1;
        return out;
    }

    public int getCount() {
        return count;
    }

    private String exportMark(List articlesData) {
        String exportMarkStr = "";
        NameValuePair[] req;
        ValueArticle va;
        ScriptSession ss;
        ScriptBuffer script;
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
                PostMethod getMethod;
//                int i;
//                int n = 0;
//                int ost = 0;
//                if (exportData.size() % 10 == 0) {
//                    n = exportData.size() / 10;
//                } else {
//                    n = exportData.size() / 10 + 1;
//                    ost = exportData.size() % 10;
//                }
//                for (int j = 0; j < n; j++) {
//                    i = 0;
//                    if (j != n - 1) {
//                        req = new NameValuePair[23];
//                    } else {
//                        req = new NameValuePair[3 + 2 * ost];
//                    }
                for (Iterator it = exportData.iterator(); it.hasNext();) {
                    ss = WebContextFactory.get().getScriptSession();
                    script = new ScriptBuffer();
                    try {
                        script.appendScript("updateMark(");
                        script.appendData(exportData.size());
                        script.appendScript(",");
                        script.appendData(count++);
                        script.appendScript(");");
                        ss.addScript(script);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    getMethod = new PostMethod(url);
                    req = new NameValuePair[5];
                    req[0] = new NameValuePair("POST_ACTION", "updateMarketing");
                    req[1] = new NameValuePair("SOURCE", "");
                    req[2] = new NameValuePair("NEW_OWNER_ID", "70919085040801266");
                    // for (int l = j * 10; l < (j + 1) * 10; l++) {
                    try {
                        va = (ValueArticle) it.next();
                        req[3] = new NameValuePair("ID_" + va.getArticleId(), va.getArticleId());
                        req[4] = new NameValuePair("TARGET_" + va.getArticleId(), va.getArticleId());
                    } catch (Exception ex) {
                    }
                    // }
                    getMethod.setRequestBody(req);
                    client.getParams().setParameter(HttpMethodParams.USER_AGENT, "Http Java Client");
                    client.executeMethod(getMethod);
                    getMethod.releaseConnection();
                    exportMarkStr = "Size: " + (req.length - 3) / 2 + " Body: ";
                    for (int k = 0; k < req.length; k++) {
                        exportMarkStr += req[k].getName() + "=" + req[k].getValue() + "/";
                    }
                    log = new Logs();
                    log.setLogType("Export Marketing.");
                    log.setLogMessage(exportMarkStr);
                    log.setIp(WebContextFactory.get().getHttpServletRequest().getRemoteAddr());
                    log.setLogTime(cal.get(Calendar.DATE) + "/"//
                            + cal.get(Calendar.MONTH) + "/"//
                            + cal.get(Calendar.YEAR) + " "//
                            + cal.get(Calendar.HOUR) + ":"//
                            + cal.get(Calendar.MINUTE) + ":"//
                            + cal.get(Calendar.SECOND));
                    FactoryDAO.getInstance().getLogsDAO().addLogs(log);
                    req = null;
                    getMethod = null;
                    Thread.sleep(300);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            updateSessionTime();
        }
        count = 1;
        return out;

    }

    private String aLink(List articlesData) {
        String aLinkStr = "";
        NameValuePair[] req;
        ScriptSession ss;
        ScriptBuffer script;
        ValueLink vl;
        String url = "http://cf.value4it.com/cf/classcat/classcat_links.jsp";
        String out = buildResponse4Link(articlesData, "Add Links");
        boolean process = false;
        String linkType = "1";
        List exportData = new ArrayList();
        for (Iterator it = articlesData.iterator(); it.hasNext();) {
            vl = (ValueLink) it.next();
            if (!vl.getClasscatId().equals("Empty") //
                    && !vl.getArticle().equals("Empty")//
                    && !vl.getArticle().equals("")//
                    && vl.getArticle() != null//
                    && !vl.getClasscatId().equals("")//
                    && vl.getClasscatId() != null) {
                process = true;
                exportData.add(vl);
            }
        }
        if (process) {
            login();
            try {
                PostMethod getMethod;
//                int n = 0;
//                if (exportData.size() % 10 == 0) {
//                    n = exportData.size() / 10;
//                } else {
//                    n = exportData.size() / 10 + 1;
//                }
//                for (int j = 0; j < n; j++) {
                for (Iterator it = exportData.iterator(); it.hasNext();) {
                    ss = WebContextFactory.get().getScriptSession();
                    script = new ScriptBuffer();
                    try {
                        script.appendScript("updateLink(");
                        script.appendData(exportData.size());
                        script.appendScript(",");
                        script.appendData(count++);
                        script.appendScript(");");
                        ss.addScript(script);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    getMethod = new PostMethod(url);
                    // for (int l = j * 10; l < (j + 1) * 10; l++) {
                    vl = (ValueLink) it.next();
                    if (vl.getLinkType().trim().equalsIgnoreCase("Datasheet")) {
                        linkType = "3";
                    } else if (vl.getLinkType().trim().equalsIgnoreCase("Data sheet")) {
                        linkType = "3";
                    } else if (vl.getLinkType().trim().equalsIgnoreCase("Specifications")) {
                        linkType = "2";
                    } else if (vl.getLinkType().trim().equalsIgnoreCase("Specification")) {
                        linkType = "2";
                    }
                    req = new NameValuePair[6];
                    req[0] = new NameValuePair("LANG_CODE", "en");
                    req[1] = new NameValuePair("TYPE_DOC", linkType);
                    req[2] = new NameValuePair("INFO_ID", "");
                    req[3] = new NameValuePair("TEXT", vl.getLinkType());
                    req[4] = new NameValuePair("CLASSCAT_ID", vl.getClasscatId());
                    req[5] = new NameValuePair("SOURCE", vl.getLink());
                    getMethod.setRequestBody(req);
                    client.getParams().setParameter(HttpMethodParams.USER_AGENT, "Http Java Client");
                    client.executeMethod(getMethod);
                    getMethod.releaseConnection();
                    aLinkStr = "Size: " + (req.length - 5) + " Body: ";
                    for (int k = 0; k < req.length; k++) {
                        aLinkStr += req[k].getName() + "=" + req[k].getValue() + "/";
                    }
                    log = new Logs();
                    log.setLogType("Add Link.");
                    log.setLogMessage(aLinkStr);
                    log.setIp(WebContextFactory.get().getHttpServletRequest().getRemoteAddr());
                    log.setLogTime(cal.get(Calendar.DATE) + "/"//
                            + cal.get(Calendar.MONTH) + "/"//
                            + cal.get(Calendar.YEAR) + " "//
                            + cal.get(Calendar.HOUR) + ":"//
                            + cal.get(Calendar.MINUTE) + ":"//
                            + cal.get(Calendar.SECOND));
                    FactoryDAO.getInstance().getLogsDAO().addLogs(log);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException ex) {
                    }
                    // }
                    getMethod = null;
                    req = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            updateSessionTime();
        }
        count = 1;
        return out;

    }

    private String cngStat(List articlesData, String status) {
        String cStatkStr = "";
        if (status.equals("Research")) {
            status = "4";
        } else if (status.equals("Control")) {
            status = "5";
        } else if (status.equals("Done")) {
            status = "6";
        }
        NameValuePair[] req;
        ValueArticle va;
        ScriptSession ss;
        ScriptBuffer script;
        String url = "http://cf.value4it.com/cf/admin/articles_admin.jsp";
        String out = buildResponse(articlesData, "Change Status");
        boolean process = false;
        List changeData = new ArrayList();
        for (Iterator it = articlesData.iterator(); it.hasNext();) {
            va = (ValueArticle) it.next();
            if (!va.getArticleId().equals("Empty") //
                    && !va.getArticle().equals("Empty")//
                    && !va.getArticle().equals("")//
                    && va.getArticle() != null//
                    && !va.getArticleId().equals("")//
                    && va.getArticleId() != null) {
                process = true;
                changeData.add(va);
            }
        }
        if (process) {
            login();
            try {
                PostMethod getMethod;
//                int i;
//                int n = 0;
//                int ost = 0;
//                if (changeData.size() % 10 == 0) {
//                    n = changeData.size() / 10;
//                } else {
//                    n = changeData.size() / 10 + 1;
//                    ost = changeData.size() % 10;
//                }
                //for (int j = 0; j < n; j++) {
                for (Iterator it = changeData.iterator(); it.hasNext();) {
                    ss = WebContextFactory.get().getScriptSession();
                    script = new ScriptBuffer();
                    try {
                        script.appendScript("updateStat(");
                        script.appendData(changeData.size());
                        script.appendScript(",");
                        script.appendData(count++);
                        script.appendScript(");");
                        ss.addScript(script);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    getMethod = new PostMethod(url);
                    // req = new NameValuePair[4 + 2 * changeData.size()];
//                    i = 0;
//                    if (j != n - 1) {
//                        req = new NameValuePair[24];
//                    } else {
//                        req = new NameValuePair[4 + 2 * ost];
//                    }
                    req = new NameValuePair[6];
                    req[0] = new NameValuePair("POST_ACTION", "change_status");
                    req[1] = new NameValuePair("SOURCE", "");
                    req[2] = new NameValuePair("NEW_STATUS", status);
                    req[3] = new NameValuePair("NEW_OWNER_ID", "70919085040801266");
//                    for (Iterator it = changeData.iterator(); it.hasNext();) {
//                        va = (ValueArticle) it.next();
//                        req[4 + i++] = new NameValuePair("ID_" + va.getArticleId(), va.getArticleId());
//                        req[4 + i++] = new NameValuePair("TARGET_" + va.getArticleId(), va.getArticleId());
//                    }
                    // for (int l = j * 10; l < (j + 1) * 10; l++) {
                    try {
                        va = (ValueArticle) it.next();
                        req[4] = new NameValuePair("ID_" + va.getArticleId(), va.getArticleId());
                        req[5] = new NameValuePair("TARGET_" + va.getArticleId(), va.getArticleId());
                    } catch (Exception ex) {
                    }
                    // }
                    getMethod.setRequestBody(req);
                    client.getParams().setParameter(HttpMethodParams.USER_AGENT, "Http Java Client");
                    client.executeMethod(getMethod);
                    getMethod.releaseConnection();
                    cStatkStr = "Size: " + (req.length - 4) / 2 + " Body: ";
                    for (int k = 0; k < req.length; k++) {
                        cStatkStr += req[k].getName() + "=" + req[k].getValue() + "/";
                    }
                    log = new Logs();
                    log.setLogType("Change Status.");
                    log.setLogMessage(cStatkStr);
                    log.setIp(WebContextFactory.get().getHttpServletRequest().getRemoteAddr());
                    log.setLogTime(cal.get(Calendar.DATE) + "/"//
                            + cal.get(Calendar.MONTH) + "/"//
                            + cal.get(Calendar.YEAR) + " "//
                            + cal.get(Calendar.HOUR) + ":"//
                            + cal.get(Calendar.MINUTE) + ":"//
                            + cal.get(Calendar.SECOND));
                    FactoryDAO.getInstance().getLogsDAO().addLogs(log);
                    Thread.sleep(300);
                    req = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            updateSessionTime();
        }
        return out;

    }

    private String cngOwn(List articlesData, String owner) {
        String cOwnStr = "";
        NameValuePair[] req;
        ValueArticle va;
        ScriptSession ss;
        ScriptBuffer script;
        String url = "http://cf.value4it.com/cf/admin/articles_admin.jsp";
        String out = buildResponse(articlesData, "Change Owner");
        boolean process = false;
        List changeData = new ArrayList();
        for (Iterator it = articlesData.iterator(); it.hasNext();) {
            va = (ValueArticle) it.next();
            if (!va.getArticleId().equals("Empty") //
                    && !va.getArticle().equals("Empty")//
                    && !va.getArticle().equals("")//
                    && va.getArticle() != null//
                    && !va.getArticleId().equals("")//
                    && va.getArticleId() != null) {
                process = true;
                changeData.add(va);
            }
        }
        if (process) {
            login();
            try {
                PostMethod getMethod;
//                int i = 0;
//                int n = 0;
//                int ost = 0;
//                if (changeData.size() % 10 == 0) {
//                    n = changeData.size() / 10;
//                } else {
//                    n = changeData.size() / 10 + 1;
//                    ost = changeData.size() % 10;
//                }
                // for (int j = 0; j < n; j++) {
                for (Iterator it = changeData.iterator(); it.hasNext();) {
                    ss = WebContextFactory.get().getScriptSession();
                    script = new ScriptBuffer();
                    try {
                        script.appendScript("updateOwn(");
                        script.appendData(changeData.size());
                        script.appendScript(",");
                        script.appendData(count++);
                        script.appendScript(");");
                        ss.addScript(script);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    getMethod = new PostMethod(url);
                    //req = new NameValuePair[3 + 2 * changeData.size()];
//                    i = 0;
//                    if (j != n - 1) {
//                        req = new NameValuePair[23];
//                    } else {
//                        req = new NameValuePair[3 + 2 * ost];
//                    }
                    req = new NameValuePair[5];
                    req[0] = new NameValuePair("POST_ACTION", "change_owner");
                    req[1] = new NameValuePair("SOURCE", "");
                    req[2] = new NameValuePair("NEW_OWNER_ID", owner);
//                    for (Iterator it = changeData.iterator(); it.hasNext();) {
//                        va = (ValueArticle) it.next();
//                        req[3 + i++] = new NameValuePair("ID_" + va.getArticleId(), va.getArticleId());
//                        req[3 + i++] = new NameValuePair("TARGET_" + va.getArticleId(), va.getArticleId());
//                    }
                    //for (int l = j * 10; l < (j + 1) * 10; l++) {
                    try {
                        va = (ValueArticle) it.next();
                        req[3] = new NameValuePair("ID_" + va.getArticleId(), va.getArticleId());
                        req[4] = new NameValuePair("TARGET_" + va.getArticleId(), va.getArticleId());
                    } catch (Exception ex) {
                    }
                    //}
                    getMethod.setRequestBody(req);
                    client.getParams().setParameter(HttpMethodParams.USER_AGENT, "Http Java Client");
                    client.executeMethod(getMethod);
                    getMethod.releaseConnection();
                    cOwnStr = "Size: " + (req.length - 3) / 2 + " Body: ";
                    for (int k = 0; k < req.length; k++) {
                        cOwnStr += req[k].getName() + "=" + req[k].getValue() + "/";
                    }
                    log = new Logs();
                    log.setLogType("Change Owner.");
                    log.setLogMessage(cOwnStr);
                    log.setIp(WebContextFactory.get().getHttpServletRequest().getRemoteAddr());
                    log.setLogTime(cal.get(Calendar.DATE) + "/"//
                            + cal.get(Calendar.MONTH) + "/"//
                            + cal.get(Calendar.YEAR) + " "//
                            + cal.get(Calendar.HOUR) + ":"//
                            + cal.get(Calendar.MINUTE) + ":"//
                            + cal.get(Calendar.SECOND));
                    FactoryDAO.getInstance().getLogsDAO().addLogs(log);
                    Thread.sleep(300);
                    req = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            updateSessionTime();
        }
        return out;

    }

    public String clearCache() {
        login();
        String out = "<div>";
        GetMethod getMethod = new GetMethod("http://cf.value4it.com/admin/long-name-to-clear-cache.jsp");
        try {
            client.getParams().setParameter(HttpMethodParams.USER_AGENT, "Http Java Client");
            client.executeMethod(getMethod);
            log = new Logs();
            log.setLogType("Clear Cache.");
            log.setLogMessage("Just clear cache...");
            log.setIp(WebContextFactory.get().getHttpServletRequest().getRemoteAddr());
            log.setLogTime(cal.get(Calendar.DATE) + "/"//
                    + cal.get(Calendar.MONTH) + "/"//
                    + cal.get(Calendar.YEAR) + " "//
                    + cal.get(Calendar.HOUR) + ":"//
                    + cal.get(Calendar.MINUTE) + ":"//
                    + cal.get(Calendar.SECOND));
            FactoryDAO.getInstance().getLogsDAO().addLogs(log);
            out = IOUtils.toString(getMethod.getResponseBodyAsStream(), "UTF-8").trim();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        updateSessionTime();
        return out + "</div>";
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
        Pattern p = Pattern.compile("\\d{17,18}");
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

    public List getClasscatIdByArticles(String[] articles) throws XmlPullParserException, UnsupportedEncodingException, IOException {
        String[] data;
        Map articleLinkMap = new HashMap();
        Map articleLinkTypeMap = new HashMap();
        http http = new http();
        XmlPullParserFactory factory = factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();

        List out = new ArrayList();
        Set<String> strSet = new HashSet();
        ValueLink vl;
        String urlPattern = "";

        for (int i = 0; i < articles.length; i++) {
            try {
                data = articles[i].split("\\t");
                articleLinkMap.put(data[0], data[2]);
                articleLinkTypeMap.put(data[0], data[1]);
                strSet.add(data[0]);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
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
                    vl = new ValueLink(xpp.getAttributeValue(2).trim(), xpp.getAttributeValue(1), (String) articleLinkTypeMap.get(xpp.getAttributeValue(2).trim()), (String) articleLinkMap.get(xpp.getAttributeValue(2).trim()));
                    out.add(vl);
                    strSet.remove(xpp.getAttributeValue(2).trim());
                }
            }
            eventType = xpp.next();
        }
        for (Iterator it = strSet.iterator(); it.hasNext();) {
            vl = new ValueLink((String) it.next(), "Empty", "Empty", "Empty");
            out.add(vl);
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

    public String buildResponse4Link(List articlesData, String requestAction) {
        ValueLink vl;
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
                + "<font color=white>ClasscatID</font>"//
                + "</td>"//
                + "<td>"//
                + "<font color=white>Request Action</font>"//
                + "</td>"//
                + "<td>"//
                + "<font color=white>Request Status</font>"//
                + "</td>"//
                + "</tr>";//
        for (Iterator it = articlesData.iterator(); it.hasNext();) {
            vl = (ValueLink) it.next();
            out += "<tr bgcolor = #cfcdcd>"//
                    + " <td style='padding-left:4px; text-align: center'>"//
                    + i++//
                    + "</td>"//
                    + " <td style='padding-left:4px; text-align: center'>"//
                    + (!vl.getArticle().equals("Empty") ? vl.getArticle() : "<font color=red>-</font>")//
                    + "</td>"//
                    + "<td style='padding-left:4px; text-align: center'>"//
                    + (!vl.getClasscatId().equals("Empty") && !vl.getArticle().equals("Empty") ? "Yes" : "<font color=red>No</font>")//
                    + "</td>"//
                    + "<td style='padding-left:4px; text-align: center'>"//
                    + (!vl.getClasscatId().equals("Empty") ? vl.getClasscatId() : "<font color=red>-</font>")//
                    + "</td>"//
                    + "<td style='padding-left:4px; text-align: center'>"//
                    + requestAction//
                    + "</td>"//
                    + "<td style='padding-left:4px; text-align: center'>"//
                    + (!vl.getClasscatId().equals("Empty") && !vl.getArticle().equals("Empty") ? "Passed" : "<font color=red>-</font>")//
                    + "</td>"//
                    + "</tr>";//
        }
        out += "</table>";
        return out;
    }

    public String exportByProducts(String products, String ip, boolean ruEnBool) {
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
            out = export(data, ip, ruEnBool);
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

    public String changeStatus(String products, String status) {
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
            out = cngStat(data, status);
        } catch (Exception ex) {
            out = ex.getMessage();
        }
        return out;
    }

    public String changeOwner(String products, String owner) {
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
            out = cngOwn(data, owner);
        } catch (Exception ex) {
            out = ex.getMessage();
        }
        return out;
    }

    public String addLink(String products) {
        if (products == null || products.equals("")) {
            return "Введите данные...";
        }
        String[] temp = splitString(products);
        if (temp[0].split("\\t").length != 3) {
            return "Введены не верные данные... Верный формат -  артикль\"символ табуляции\"тип ссылки\"символ табуляции\"ссылка";
        }
        Pattern p = Pattern.compile("[А-Яа-я]");
        Matcher m;
        for (int i = 0; i < temp.length; i++) {
            m = p.matcher(temp[i]);
            if (m.find()) {
                return "Русские символы в строке <b>" + (i + 1) + "</b> -> <b>" + temp[i] + "</b>";
            }
        }
        String out = "Смори логи...";
        ValueLink vl;
        List data = new ArrayList();
        try {
            data = getClasscatIdByArticles(temp);
            out = aLink(data);
        } catch (Exception ex) {
            out = ex.getMessage();
        }
        return out;
    }

    public String clearSession() {
        login();
        logout();
        Cookies cs = new Cookies();
        cs.setId(1);
        cs.setCookie("");
        cs.setTime(0L);
        try {
            FactoryDAO.getInstance().getCookiesDAO().addCookies(cs);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Cleared...";
    }
}

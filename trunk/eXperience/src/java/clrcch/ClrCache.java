/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clrcch;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 *
 * @author Администратор
 */
public class ClrCache {

    private static final long serialVersionUID = 1L;
    private String inputLine = "";
    private String outputLine = "";
    private String www;

    private String Elab(String in) {
        String out = "";
        int intValue;
        String re = "Cleared.*(\\d*)\\sms";
        Pattern p = Pattern.compile(re);
        Matcher m = p.matcher(in);
        if (m.find()) {
            www = m.group(1);
            try {
                intValue = Integer.parseInt(m.group(1));

            } catch (NumberFormatException e) {
                intValue = 120000;
            }
            out = "Кэш очищен! До следующего запуска очистки нужно подождать: " + intValue / 1000 + " с.";
        } else {
            re = "(\\d*)\\sms";
            p = Pattern.compile(re);
            m = p.matcher(in);
            if (m.find()) {
                www = m.group(1);
                out = "До следующего запуска очистки нужно подождать: " + Integer.parseInt(m.group(1)) / 1000 + " с.";
            }
        }

        return out;
    }

    private String CleareCacheF() {
        HttpClient client = new HttpClient();

        String st_url = "http://cf.value4it.com/login/authorize2.jsp";
        PostMethod method = new PostMethod(st_url);
        method.setParameter("USERNAME", "apopov");
        method.setParameter("PASSWORD", "Andrey1602");
        method.setParameter("btlogin", "SIGN-IN");

        try {
            int returnCode = client.executeMethod(method);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            method.releaseConnection();
        }


        String url = "http://cf.value4it.com/admin/long-name-to-clear-cache.jsp";
        GetMethod getMethod = new GetMethod(url);

        try {
            int getResult = client.executeMethod(getMethod);
            InputStream result = getMethod.getResponseBodyAsStream();
            InputStreamReader isr = new InputStreamReader(result);
            BufferedReader in = new BufferedReader(isr);
            while ((inputLine = in.readLine()) != null) {
                outputLine += inputLine;
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        String urllo = "http://cf.value4it.com/login/logout.jsp";
        GetMethod getMethodlo = new GetMethod(urllo);
        try {
            int getResult = client.executeMethod(getMethodlo);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }

        return outputLine = outputLine.trim();
    }

    public String CleareCache() {
        return Elab(CleareCacheF());
    }
}

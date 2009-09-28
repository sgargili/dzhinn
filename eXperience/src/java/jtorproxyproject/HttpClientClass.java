/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtorproxyproject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

/**
 *
 * @author APopov
 */
public class HttpClientClass {

    private HttpClient client = new HttpClient();
    private String ArtID = "";
    private String url = "http://www.2ip.ru/";
    private String inputLine = "";
    private String allString = "";
    private String aID = "";
    private String re = "(\\d{1,3}[.]\\d{1,3}[.]\\d{1,3}[.]\\d{1,3})";

    public String getIP() {


        client.getHostConfiguration().setProxy("localhost", 8118);
        GetMethod getMethod = new GetMethod(url);
        try {
            int getResult = client.executeMethod(getMethod);
            InputStream result = getMethod.getResponseBodyAsStream();
            InputStreamReader isr = new InputStreamReader(result);
            BufferedReader in = new BufferedReader(isr);
            Pattern p = Pattern.compile(re);
            while ((inputLine = in.readLine()) != null) {
                allString += inputLine;
            }
            Matcher m = p.matcher(allString);
            if (m.find()) {
                aID = m.group(0);
            }
            in.close();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }

        return aID;
    }
}

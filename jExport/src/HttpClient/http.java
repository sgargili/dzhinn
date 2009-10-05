/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author APopov
 */
public class http {

    private HttpClient client = new HttpClient();

    public String DownloadManufacturersFromValue() {
        String url = "http://213.53.57.20/ShopIX/exportFullXML.jsp?shopId=71";
//        String inputLine = "";
        String allString = "";
        InputStream result = null;
//        InputStreamReader isr = null;
//        BufferedReader in = null;
        GetMethod getMethod = new GetMethod(url);
        try {
            int getResult = client.executeMethod(getMethod);
            result = getMethod.getResponseBodyAsStream();
            allString = IOUtils.toString(result, "UTF-8");
//            isr = new InputStreamReader(result, "UTF-8");
//            in = new BufferedReader(isr);
//            while ((inputLine = in.readLine()) != null) {
//                allString += inputLine;
//            }
//            in.close();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        return allString;
    }
}

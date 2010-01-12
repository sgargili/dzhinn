/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HttpClient;

import java.io.File;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author APopov
 */
public class http {

    private HttpClient client = new HttpClient();

    public String DownloadContentAsString(String url) {
        //String url = "http://213.53.57.20/ShopIX/exportFullXML.jsp?shopId=74";
        String allString = "";
        GetMethod getMethod = new GetMethod(url);
        try {
            client.getParams().setParameter(HttpMethodParams.USER_AGENT, "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; Maxthon; .NET CLR 2.0.50727; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)");
            int getResult = client.executeMethod(getMethod);
            allString = IOUtils.toString(getMethod.getResponseBodyAsStream(), "UTF-8");
            allString = allString.replaceAll("Error 500:.*", "<?xml version=\"1.0\" encoding=\"UTF-8\"?><itemCard></itemCard>");
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        return allString;
    }

    public String DownloadContentAsString(String url, String encoding) {
        //String url = "http://213.53.57.20/ShopIX/exportFullXML.jsp?shopId=74";
        String allString = "";
        GetMethod getMethod = new GetMethod(url);
        try {
            client.getParams().setParameter(HttpMethodParams.USER_AGENT, "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; Maxthon; .NET CLR 2.0.50727; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)");
            int getResult = client.executeMethod(getMethod);
            allString = IOUtils.toString(getMethod.getResponseBodyAsStream(), encoding);
            allString = allString.replaceAll("Error 500:.*", "<?xml version=\"1.0\" encoding=\"UTF-8\"?><itemCard></itemCard>");
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        return allString;
    }

    public File DownloadContentAsFile(String url) {
        //String url = "http://213.53.57.20/ShopIX/exportFullXML.jsp?shopId=74";
        File tempFile = new File("temp");
        GetMethod getMethod = new GetMethod(url);
        try {
            client.getParams().setParameter(HttpMethodParams.USER_AGENT, "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; Maxthon; .NET CLR 2.0.50727; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)");
            int getResult = client.executeMethod(getMethod);
            org.apache.sanselan.util.IOUtils.putInputStreamToFile(getMethod.getResponseBodyAsStream(), tempFile);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        return tempFile;
    }
}

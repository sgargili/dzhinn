/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HttpClient;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
        client.getHostConfiguration().setProxy("127.0.0.1", 8118);
        //String url = "http://213.53.57.20/ShopIX/exportFullXML.jsp?shopId=74";
        String allString = "";
        GetMethod getMethod = new GetMethod(url);
        try {
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

    public void setCookie(String url) {
        GetMethod getMethod = new GetMethod(url);
        try {
            int getResult = client.executeMethod(getMethod);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
    }

    public void setCookie(String url, boolean useProxy) {
        client.getParams().setParameter(HttpMethodParams.USER_AGENT, "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
        if (useProxy) {
            client.getHostConfiguration().setProxy("127.0.0.1", 9050);
        }
        GetMethod getMethod = new GetMethod(url);
        try {
            int getResult = client.executeMethod(getMethod);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
    }

    public String DownloadContentAsString(String url, String encoding) {
        client.getHostConfiguration().setProxy("127.0.0.1", 8118);
        //String url = "http://213.53.57.20/ShopIX/exportFullXML.jsp?shopId=74";
        String allString = "";
        GetMethod getMethod = new GetMethod(url);
        try {
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
        client.getHostConfiguration().setProxy("127.0.0.1", 8118);
        //String url = "http://213.53.57.20/ShopIX/exportFullXML.jsp?shopId=74";
        File tempFile = new File("temp");
        GetMethod getMethod = new GetMethod(url);
        try {
            int getResult = client.executeMethod(getMethod);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile), "WINDOWS-1251"));
            out.write(IOUtils.toCharArray(getMethod.getResponseBodyAsStream(), "UTF-8"));

            out.flush();
            out.close();

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        return tempFile;
    }

    public File DownloadContentAsFile(String url, boolean useProxy) {
        client.getParams().setParameter(HttpMethodParams.USER_AGENT, "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
        if (useProxy) {
            client.getHostConfiguration().setProxy("127.0.0.1", 8118);
        }
        //String url = "http://213.53.57.20/ShopIX/exportFullXML.jsp?shopId=74";
        File tempFile = new File("/home/ilyahoo/NetBeansProjects/Temp/temp.html");
        GetMethod getMethod = new GetMethod(url);
        try {
            int getResult = client.executeMethod(getMethod);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile), "UTF-8"));
            out.write(IOUtils.toCharArray(getMethod.getResponseBodyAsStream(), "UTF-8"));

            out.flush();
            out.close();

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        return tempFile;
    }

    public byte[] DownloadContentAsBinFile(String url, boolean useProxy) throws FileNotFoundException, IOException {
        client.getParams().setParameter(HttpMethodParams.USER_AGENT, "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
        byte[] res={0};
        if (useProxy) {
            client.getHostConfiguration().setProxy("127.0.0.1", 8118);
        }
        //String url = "http://213.53.57.20/ShopIX/exportFullXML.jsp?shopId=74";
        //FileOutputStream out = new FileOutputStream("/home/ilyahoo/NetBeansProjects/Temp/temp");
        GetMethod getMethod = new GetMethod(url);
        try {
            int getResult = client.executeMethod(getMethod);
            //BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile)));
            //ByteArrayOutputStream out = new ByteArrayOutputStream(tempFile);
            //out.write(IOUtils.toCharArray(getMethod.getResponseBodyAsStream(), "UTF-8"));
//            out.write(IOUtils.toByteArray(getMethod.getResponseBodyAsStream()));
//
//            out.flush();
//            out.close();
            res = IOUtils.toByteArray(getMethod.getResponseBodyAsStream());
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        return res;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package http;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author APopov
 */
public class Http {

    private HttpClient client = new HttpClient();

    public String DownloadContentAsString(String url, String encoding, boolean useProxy) {
        client.getParams().setParameter(HttpMethodParams.USER_AGENT, "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
        if (useProxy) {
            client.getHostConfiguration().setProxy("127.0.0.1", 8118);
        }
        String allString = "";
        GetMethod getMethod = new GetMethod(url);
        try {
            int getResult = client.executeMethod(getMethod);
            allString = IOUtils.toString(getMethod.getResponseBodyAsStream(), encoding);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        return allString;
    }

    public File DownloadContentAsFile(String url) {
        client.getHostConfiguration().setProxy("127.0.0.1", 8118);
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
        File tempFile = new File("temp.html");
        GetMethod getMethod = null;
        try {
            getMethod = new GetMethod(url);
            int getResult = client.executeMethod(getMethod);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile), "UTF-8"));
            out.write(IOUtils.toCharArray(getMethod.getResponseBodyAsStream(), "WINDOWS-1251"));

            out.flush();
            out.close();

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                getMethod.releaseConnection();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return tempFile;
    }

    public void DownloadBinaryFile(String url, boolean useProxy, String fileName) {
        client.getParams().setParameter(HttpMethodParams.USER_AGENT, "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
        if (useProxy) {
            client.getHostConfiguration().setProxy("127.0.0.1", 8118);
        }
        GetMethod getMethod = new GetMethod(url);
        try {
            FileOutputStream fos = null;
            File tempFile = new File("/home/admin/keyPics/" + fileName + ".jpg");
            int getResult = client.executeMethod(getMethod);
            byte[] imageData = getMethod.getResponseBody();
            fos = new FileOutputStream(tempFile);
            fos.write(imageData);
            fos.close();

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        //return tempFile;
    }

    public File DownloadContentAsFile(String url, boolean useProxy, String tempFileName) {
        client.getParams().setParameter(HttpMethodParams.USER_AGENT, "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
        if (useProxy) {
            client.getHostConfiguration().setProxy("127.0.0.1", 8118);
        }
        File tempFile = new File("/root/" + tempFileName + ".html");
        GetMethod getMethod = new GetMethod(url);
        try {
            int getResult = client.executeMethod(getMethod);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile), "UTF-8"));
            out.write(IOUtils.toCharArray(getMethod.getResponseBodyAsStream(), "WINDOWS-1251"));

            out.flush();
            out.close();

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        return tempFile;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Admin4DB2
 */
import java.io.*;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.sanselan.util.IOUtils;


public class InputStreamToFile {

    private static HttpClient client = new HttpClient();

    private static String DownloadManufacturersFromValue() {
        String url = "http://213.53.57.20/ShopIX/exportFullXML.jsp?shopId=74";
        InputStream result = null;
        GetMethod getMethod = new GetMethod(url);
        try {
            int getResult = client.executeMethod(getMethod);
            result = getMethod.getResponseBodyAsStream();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                File f = new File("C://outFile.xml");
                IOUtils.putInputStreamToFile(result, f);
                System.out.println("\nFile is created...................................");
            } catch (IOException e) {
                System.out.println(e);
            }
            getMethod.releaseConnection();
        }

        return "Done";
    }

    public static void main(String args[]) {
        DownloadManufacturersFromValue();
    }
}

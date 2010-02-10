/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HttpClient;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author APopov
 */
public class AllProducts {

    public static void main(String[] arg) throws IOException {
        http client = new http();
        File fl = client.DownloadContentAsFile("http://213.53.57.20/ShopIX/exportFullXML.jsp?shopId=74");
        FileUtils.copyFile(fl, new File("C:/allProducts.xml"));
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import HttpClient.http;
import Xalan.XalanTransform;
import java.io.IOException;
import javax.xml.transform.TransformerException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author APopov
 */
public class XsltTest {

    public static void main(String[] arg) throws IOException, TransformerException {
        http th = new http();
        XalanTransform xslt = new XalanTransform();
        String str = "";
        str = FileUtils.readFileToString(xslt.XSLProcessor(th.DownloadContentAsFile("http://213.53.57.20/ShopIX/cardXML.jsp?shopId=74&productId=52015")), "UTF-8");
        System.out.println(str);
    }
}

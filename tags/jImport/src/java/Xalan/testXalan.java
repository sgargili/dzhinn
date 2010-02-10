/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Xalan;

import HttpClient.http;
import java.io.IOException;
import javax.xml.transform.TransformerException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author APopov
 */
public class testXalan {

    public static void main(String[] arg) throws TransformerException, IOException {
        XalanTransform xslt = new XalanTransform();
        http http = new http();
        String temp = FileUtils.readFileToString(xslt.XSLProcessor(http.DownloadContentAsFile("http://213.53.57.20/CatExp/card.exml?shop=74&lang=ru&product=90608064101374952")), "UTF-8")//
                .replaceAll("(\r\n)|(\r)|(\n)|(\n\r)", "") //
                .replaceAll(">\\s+<", "><");//



        System.out.println(temp);
    }
}

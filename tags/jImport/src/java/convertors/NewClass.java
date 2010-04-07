/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package convertors;

import HttpClient.http;
import java.io.File;

/**
 *
 * @author APopov
 */
public class NewClass {

    public static void main(String[] arg) {
        http ht = new http();
        File file = new File("D://xmlTest.xml");
        file = ht.DownloadContentAsFile("http://213.53.57.20/CatExp/productsAll.exml?shop=51");
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yandexmarket;

import HttpClient.http;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author APopov
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        File aaa = new File("c://ipTest.txt");
        http ht = new http();
        String str = ht.DownloadContentAsString("http://2ip.ru/");
        FileUtils.writeStringToFile(aaa, str);

    }
}

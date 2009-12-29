/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gkey;

import http.Http;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author root
 */
public class TorTest {

    public static void main(String[] args) throws IOException {
//    Http ht = new Http();
//    File fl =new File("/root/IP.html");
//    File fl2;
//    fl2 = ht.DownloadContentAsFile("http://2ip.ru/", true);
//    FileUtils.copyFile(fl2, fl);
        Pattern p = Pattern.compile(";$");
        Matcher m = p.matcher("aaasasasa;".replaceAll(";$", ""));
        if (m.find()) {
            System.out.println("Ага");
        }
    }
}

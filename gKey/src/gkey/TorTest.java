/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gkey;

import dao.FactoryDAO;
import http.Http;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import pojo.Keyhtml;
import pojo.TempPojo;
import pojo.TempPojo2;

/**
 *
 * @author root
 */
public class TorTest {

    public static void main(String[] args) throws IOException, SQLException {
//        Http ht = new Http();
//    File fl =new File("/root/IP.html");
//    File fl2;
//    fl2 = ht.DownloadContentAsFile("http://2ip.ru/", true);
//    FileUtils.copyFile(fl2, fl);
//        Pattern p = Pattern.compile(";$");
//        Matcher m = p.matcher("aaasasasa;".replaceAll(";$", ""));
//        if (m.find()) {
//            System.out.println("Ага");
//        }
        // String str = ht.DownloadContentAsString("http://shop.key.ru/shop/goods/49985", "WINDOWS-1251", true);
        //String str = ht.DownloadContentAsString("http://2ip.ru", "UTF-8", true);

        //System.out.println(str);
//        JustDownload jd = new JustDownload();
//        jd.load("1", 49985);
//        List lst = FactoryDAO.getInstance().getTempPojoDAO2().getAllTempPojo2();
//        Set temp = new HashSet();
//        TempPojo2 tp;
//        for (Iterator it = lst.iterator(); it.hasNext();) {
//            tp = (TempPojo2) it.next();
//            temp.add(tp.getKeyarticle());
//        }
//        System.out.println(lst.size());
//        System.out.println(temp.size());
//        System.out.println(temp.contains("49985"));

        List lst;
        Keyhtml tp;
        DownloadContentv2 dc = new DownloadContentv2();
        int j = 0;
        for (int k = 0; k < 10; k++) {
            lst = FactoryDAO.getInstance().getKeyHtmlDAO().getAllKeyHtml((10000 + 1) * k, 10000);
            for (Iterator it = lst.iterator(); it.hasNext();) {
                tp = (Keyhtml) it.next();
                try {
                    dc.load(j++ + "", Integer.parseInt(tp.getKeyarticle()), tp.getKeyhtml());
                } catch (Exception ex) {
                }
            }
            lst = null;
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yandexmarket;

import DAO.FactoryDAO;
import HttpClient.http;
import Pojo.Newarticles;
import Proxy.IpChange;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author ilyahoo
 */
public class DownPic {

    private static String theOutputEncoding = "UTF-8";

    public static void main(String[] args) throws SQLException, IOException {

        FactoryDAO fd = FactoryDAO.getInstance();
        http ht1 = new http();
        List<Newarticles> articles = (List<Newarticles>) fd.getnewArticlesDAO().getAllArticles();
        //File fl, temp;
        File temp;
        byte[] fl;
        Pattern ptr = Pattern.compile("captcha.yandex.net");
        Matcher mt;
        Pattern ptr2 = Pattern.compile(".title.404");
        Matcher mt2;
        Pattern ptr3 = Pattern.compile("Connect to market.yandex.ru:80 failed");
        Matcher mt3;
        IpChange ip = new IpChange();

        for (Iterator iter = articles.iterator(); iter.hasNext();) {
            Newarticles art = (Newarticles) iter.next();
            if (art.getId() > 774) {
                System.out.print(art.getId() + ") ");
                System.out.println(art.getPicurl());
                if (art.getPicurl() != null) {
                    fl = ht1.DownloadContentAsBinFile(art.getPicurl(), true);
                    System.out.println("Dannye skachalis...");
                    while (true) {
                        try {
//                        mt = ptr.matcher(FileUtils.readFileToString(fl, theOutputEncoding));
//                        mt2 = ptr2.matcher(FileUtils.readFileToString(fl, theOutputEncoding));
//                        mt3 = ptr3.matcher(FileUtils.readFileToString(fl, theOutputEncoding));


//                        if (!mt.find() & !mt2.find() & !mt3.find()) {
                            if (true) {
                                System.out.println("begin");
                                temp = new File("/home/ilyahoo/NetBeansProjects/Temp/Pic/" + art.getKeyart() + ".jpg");
                                //FileUtils.writeByteArrayToFile(temp, FileUtils.readFileToByteArray(fl));
                                FileUtils.writeByteArrayToFile(temp, fl);

                                break;
                            }
                            ip.setChange();
                            System.out.println("Сменился Ip...");
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    }
                }
            }
        }

    }
}

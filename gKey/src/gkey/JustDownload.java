/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gkey;

import tor.IpChange;
import dao.FactoryDAO;
import http.Http;
import pojo.Keyhtml;

/**
 *
 * @author Apopov
 */
public class JustDownload {

    static int bayan = 0;

    public void load(String threadNum, int i) {
        FactoryDAO fd = FactoryDAO.getInstance();
//        try {
//            if (fd.getKeyHtmlDAO().isHtmlPresent(i + "")) {
//                System.out.println("Uzhe est' article -> " + i);
//                return;
//            }
//        } catch (Exception ex) {
//        }
        
        IpChange ip = new IpChange();
        String tempStr = "";
        Http ht = new Http();
        Keyhtml kh;
        try {
            System.out.println("Поток " + threadNum + " -> Продукт -> " + i);
            if (bayan++ == 17) {
                ip.setChange();
                bayan = 1;
                System.out.println(" Сменился IP...");
            }
            tempStr = ht.DownloadContentAsString("http://shop.key.ru/shop/goods/" + i, "WINDOWS-1251", true);
            kh = new Keyhtml();
            kh.setKeyarticle(i + "");
            kh.setKeyhtml(tempStr);
            fd.getKeyHtmlDAO().addKeyHtml(kh);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}

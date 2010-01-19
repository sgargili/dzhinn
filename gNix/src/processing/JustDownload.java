/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package processing;

import tor.IpChange;
import dao.FactoryDAO;
import http.Http;
import pojo.NixInputData;

/**
 *
 * @author Apopov
 */
public class JustDownload {

    static int bayan = 0;

    public void load(String threadNum, NixInputData nixInput) {

        FactoryDAO fd = FactoryDAO.getInstance();

        IpChange ip = new IpChange();

        String tempStr = "";

        Http ht = new Http();

        try {
            System.out.println("Поток " + threadNum + " -> Продукт -> " + nixInput.getProductUrl());
            if (bayan++ == 17) {
                ip.setChange();
                bayan = 1;
                System.out.println(" Сменился IP...");
            }
            tempStr = ht.DownloadContentAsString("http://www.nix.ru" + nixInput.getProductUrl(), "WINDOWS-1251", true);
            nixInput = new NixInputData();
            nixInput.setHtmlData(tempStr);
            fd.getNixInputDataDAO().addNixInputData(nixInput);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}

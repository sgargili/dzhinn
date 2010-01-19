/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gnix;

import java.io.IOException;
import processing.NixProcessing;
import dao.FactoryDAO;
//import http.Http;
import http.Http;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FileUtils;
import pojo.NixInputData;
import pojo.PtLink;
import tor.IpChange;

/**
 *
 * @author APopov
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

//        NixProcessing nix = NixProcessing.getInstance();
//        FactoryDAO fd = FactoryDAO.getInstance();
//
//        List generalLinks = nix.getAllNixPT();
//        List allLinks;
//
//        IpChange ip = new IpChange();
//
//        PtLink pt;
//        NixInputData nid;
//
//        String tempLink = "";
//
//        for (Iterator it = generalLinks.iterator(); it.hasNext();) {
//            pt = (PtLink) it.next();
//            System.out.println(pt.getProductType() + " - " + pt.getLink());
//            allLinks = nix.getDepartmentNixLinks(pt.getLink());
//            for (Iterator it2 = allLinks.iterator(); it2.hasNext();) {
//                tempLink = (String) it2.next();
//                ip.setChange();
//                nid = new NixInputData();
//                nid.setProductType(pt.getProductType());
//                nid.setProductUrl(tempLink);
//                fd.getNixInputDataDAO().addNixInputData(nid);
//            }
//        }
        NixProcessing nix = NixProcessing.getInstance();
        Http ht = new Http();
        nix.getProductDescFromHTML("", "Ноут", ht.DownloadContentAsString("http://www.nix.ru/autocatalog/notebook_microstar/MSI_Xslim_X340041RU_9S7135214041_CM723_1.2_2048_320_WiFi_WiMAX_BT_cam_VistaHP_13.4_1.34_72320.html", "Windows-1251", true));
    }
}

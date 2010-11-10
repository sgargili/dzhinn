/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import factories.FactoryDao;
import pojo.FcenterProduct;
import processing.FcenterProcessing;
import processing.NixProcessing;

/**
 * @author PAV
 */
public class Class4Test {

    public static void main(String[] args) {

//        FactoryDao fd = FactoryDao.getInstance();
//        List<String> list = fd.getInputDataDao().getAllArticlesByShop(2);
//        for(String str : list){
//            System.out.println(str);
//        }
//        System.out.println(fd.getInputDataDao().getAllArticlesByShop(2).size());
//        fd.getInputDataDao().getAllInputData();

//        NixProcessing shop = new NixProcessing();
//
//        Map<Integer, String> products;
//
//        Set<Integer> articles;
//
//        Map<String, String> pts = shop.getNixDepartments("http://www.nix.ru/price/price.html");
//
//        Set<String> deps = pts.keySet();
////
//        for (String depUrl : deps) {
//            products = shop.getLink4AllProductLinksByUrl("http://www.nix.ru/price/" + depUrl);
//            articles = products.keySet();
//            for (int article : articles) {
//                shop.getProductDescFromNixHTML(article + "", pts.get(depUrl), "Nix.ru", "http://www.nix.ru" + products.get(article), true, "127.0.0.1:8118");
////                System.out.println(article);
//               // shop.downloadPics(article + "", "c://temp/");
//            }
//        }


        FcenterProcessing fcenter = new FcenterProcessing();
        System.out.println(fcenter.getFcenterDescriptionInCsv().getAbsolutePath());
//        List<FcenterProduct> list = fcenter.getProductsLinks();
//        for (FcenterProduct pro : list) {
//            fcenter.getDescription(pro);
//        }
//          fcenter.downloadPics("90039", "C://pics4Fcenter/");

    }
}

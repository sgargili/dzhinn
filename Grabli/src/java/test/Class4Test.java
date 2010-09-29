/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import processing.NixProcessing;

/**
 *
 * @author PAV
 */
public class Class4Test {

    public static void main(String[] args) {

        NixProcessing shop = new NixProcessing();

        Map<Integer, String> products;

        Set<Integer> articles;

        Map<String, String> pts = shop.getNixDepartments("http://www.nix.ru/price/price.html");

        Set<String> deps = pts.keySet();

        for (String depUrl : deps) {
            products = shop.getLink4AllProductLinksByUrl("http://www.nix.ru/price/" + depUrl);
            articles = products.keySet();
            for (int article : articles) {
                shop.getProductDescFromNixHTML(article + "", pts.get(depUrl), "Nix.ru", "http://www.nix.ru" + products.get(article), true, "127.0.0.1:8118");
                shop.downloadPics(article + "", "c://temp/");
            }
        }
//        Map<Integer, String> strs = shop.getLink4AllProductLinksByUrl("http://localhost:8080/acers.htm");
//        Set set = strs.entrySet();
//        //System.out.println("Nachalo: "+ strs.get(24895));
//        for(Object obj : set){
//            System.out.println(obj);
//        }
//        shop.getProductDescFromNixHTML("98568", "Mobile PC", "Nix.ru", "http://localhost:8080/pics.htm", false, "");
        //shop.downloadPics("98553", "C://temp/");
    }
}

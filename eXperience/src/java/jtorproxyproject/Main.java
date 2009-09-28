/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtorproxyproject;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 *
 * @author APopov
 */
public class Main {

    private static String art;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        
        IpChange ipсh = new IpChange();
        String str = "";
        for (int i = 0; i < 5; i++) {
            if (ipсh.setChange()) {
                HttpClientClass hcc = new HttpClientClass();
                str = hcc.getIP();
            }
            System.out.println(str);
           // Thread.sleep(10000);
        }

    }
}

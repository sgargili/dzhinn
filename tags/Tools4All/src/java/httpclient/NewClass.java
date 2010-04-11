/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package httpclient;

import factories.FactoryHTTP;
import java.io.File;

/**
 *
 * @author Apopov
 */
public class NewClass {
    public static void main(String[] args) {
        HttpData http = FactoryHTTP.getInstance().getHttpData();
        http.downloadContentAsFile("http://www.ya.ru", "UTF-8", "WINDOWS-1251", new File("C://new.html"), false);
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package yandexmarket;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 *
 * @author root
 */
public class NewClass1 {
    public static void main(String[] args) throws UnsupportedEncodingException{
    System.out.println(URLDecoder.decode("Hello", "UTF-8"));
    }

}

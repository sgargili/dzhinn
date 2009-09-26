/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author APopov
 */
public class StringToStrteam {

    public InputStream convert(String str) {
        InputStream is = null;
        try {
            is = new ByteArrayInputStream(str.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return is;
    }
}

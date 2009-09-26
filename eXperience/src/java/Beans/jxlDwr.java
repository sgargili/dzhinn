/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author APopov
 */
public class jxlDwr {

    public void www(InputStream inp) {
        try {
            File f = new File("c:/test2.xls");
            OutputStream out = new FileOutputStream(f);
            byte buf[] = new byte[1024];
            int len;
            while ((len = inp.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.close();
            inp.close();
        } catch (IOException e) {
        }
    }
}

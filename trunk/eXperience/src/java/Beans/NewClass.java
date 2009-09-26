/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Admin4DB2
 */
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class NewClass {

    public static void main(String[] args) throws Exception {
        ZipFile zip = new ZipFile(new File("C:/compressed.zip"));

        for (Enumeration e = zip.entries(); e.hasMoreElements();) {
            ZipEntry entry = (ZipEntry) e.nextElement();
            System.out.println("File name: " + entry.getName());
        }
    }
}

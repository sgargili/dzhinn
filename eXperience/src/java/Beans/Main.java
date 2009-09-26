/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Admin4DB2
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {

    public static void main(String[] args) throws Exception {
        ZipInputStream inStream = new ZipInputStream(new FileInputStream("C:/compressed.zip"));
        OutputStream outStream = new FileOutputStream("C:/extracted.txt");

        byte[] buffer = new byte[1024];
        int read;
        ZipEntry entry;
        if ((entry = inStream.getNextEntry()) != null) {
            while ((read = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, read);
            }
        }
        outStream.close();
        inStream.close();
    }
}

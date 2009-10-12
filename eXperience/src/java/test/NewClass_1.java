/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import FTP.FTPClient;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author APopov
 */
public class NewClass_1 {

    public static void main(String[] str) throws IOException {
        FTPClient ftp = new FTPClient();
        ftp.connect("u196802.ftp.masterhost.ru", 21, "u196802", "heolody2ess9y");
        ftp.cwd("temp");
        System.out.println(ftp.pwd());
        ftp.stor(FileUtils.openInputStream(new File("C:/eee.txt")), "xyz.txt");
        ftp.stor(FileUtils.openInputStream(new File("C:/eee.txt")), "xyz2.txt");
        ftp.disconnect();

    }
}

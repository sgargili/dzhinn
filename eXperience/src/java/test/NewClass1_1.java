/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Admin4DB2
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;
import org.apache.commons.net.ftp.FTPClient;

public class NewClass1_1 {

    public static void main(String[] args) throws SocketException, IOException {
        FTPClient client = new FTPClient();
        FileInputStream fis = null;

        client.connect("u196802.ftp.masterhost.ru");
        client.login("u196802", "heolody2ess9y");

        String filename = "c:/eee.txt";
        fis = new FileInputStream(filename);
        client.storeFile("eee.txt", fis);
        client.logout();
        fis.close();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author APopov
 */
import org.apache.commons.net.ftp.FTPClient;
import java.io.IOException;
import java.io.FileOutputStream;

public class FtpDownloadDemo {

    public static void main(String[] args) {
        FTPClient client = new FTPClient();
        FileOutputStream fos = null;

        try {
            client.connect("192.168.1.178", 20021);
            client.login("x51xp", "Xcw67uQ");

            //
            // The remote filename to be downloaded.
            //
            String filename = "pic.jpg";
            fos = new FileOutputStream(filename);

            //
            // Download file from FTP server
            //
            System.out.println(client.retrieveFile("/u196802" + filename, fos));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

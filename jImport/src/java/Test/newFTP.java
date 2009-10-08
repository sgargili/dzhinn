/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import com.jscape.inet.ftp.Ftp;
import com.jscape.inet.ftp.FtpException;
import java.io.File;

/**
 *
 * @author APopov
 */
public class newFTP {

    public static void main(String[] arg) throws FtpException {
        // create Ftp instance with FTP hostname, username and password as arguments
        Ftp ftp = new Ftp("192.168.1.178", "x51xp", "Xcw67uQ");
        ftp.setPort(20021);
        ftp.setBinary();
        ftp.setLocalDir(new File("C:/tmp"));

// establish connection
        ftp.connect();
        ftp.setDir("/Fotos");
        String listing = ftp.getDirListingAsString();

// print directory listing to console
        // ftp.download("pic.jpg");
        ftp.upload(new File("C:/pic.jpg"));
        System.out.println(listing);


    }
}

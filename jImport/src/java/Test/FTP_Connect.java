/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author Admin4DB2
 */
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.commons.net.ftp.FTPClientConfig;

public class FTP_Connect {

    private File tempFile;

    @SuppressWarnings("static-access")
    public void getDataFile() {

        String server = "u196802.ftp.masterhost.ru";
        String username = "u196802";
        String password = "heolody2ess9y";
        String folder = "temp";
        String destinationFolder = "C:/art/";
        FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_L8);
        conf.setServerLanguageCode("ru");
        try
         {
            FTPClient ftp = new FTPClient();
            ftp.configure(conf);
            ftp.connect(server);
            ftp.login(username, password);
            ftp.setDefaultTimeout(5000 * 1000);
            ftp.changeWorkingDirectory(folder);

            FTPFile[] files = ftp.listFiles();
           // System.out.print(ftp.);

            System.out.println("Number of files in dir: " + files.length);

            for (int i = 0; i < files.length; i++) {
                tempFile = new File(destinationFolder + files[i].getName());
                FileOutputStream output = new FileOutputStream(tempFile);
                ftp.retrieveFile(folder + "/" + files[i].getName(), output);
                output.close();
            }
            ftp.logout();
            ftp.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

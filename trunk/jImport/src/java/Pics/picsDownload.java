/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.net.URL;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author APopov
 */
public class picsDownload {

    public static void main(String[] arg) throws IOException {
        File fl = new File("C:/pic.jpg");
        FileInputStream in = null;
//        fl.createNewFile();
//        URL url = new URL("http://freestock2008.value4it.ru/pimg/s/resize/400x300x400x300/50610093515000470.jpg");
//        FileUtils.copyURLToFile(url, fl);
//        FTPClient ftpClient = new FTPClient();
//        ftpClient.connect("u196802.ftp.masterhost.ru");
//        ftpClient.login("u196802", "heolody2ess9y");
//        try {
//            in = new FileInputStream(fl);
//            ftpClient.storeFile("programfiler/movies.jpg", in);
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//
//
//        ftpClient.disconnect();
        FTPClient ftp = new FTPClient();

        int reply;
        try {
            ftp.connect("192.168.1.178", 20021);
            ftp.login("x51xp", "Xcw67uQ");
            ftp.changeWorkingDirectory("/Fotos");
            System.out.println(ftp.getReplyString());
            //ftp.set
           // ftp.sendCommand("SYST");
            //System.out.println(ftp.getReplyString());
            //ftp.sendCommand("FEAT");
            //System.out.println(ftp.getReplyString());
//            ftp.sendCommand("OPTS UTF8 ON");
//            System.out.println(ftp.getReplyString());
//            ftp.sendCommand("PWD");
//            System.out.println(ftp.getReplyString());
//            ftp.sendCommand("TYPE I");
//            System.out.println(ftp.getReplyString());
//            ftp.sendCommand("PASV");
//            System.out.println(ftp.getReplyString());
//            ftp.sendCommand("MLSD");
//            System.out.println(ftp.getReplyString());

            reply = ftp.getReplyCode();
            if (FTPReply.isPositiveCompletion(reply)) {
                in = new FileInputStream(fl);
                System.out.println("Connected Success");
//                String[] names = ftp.listNames();
//                for (String name : names) {
//                    System.out.println("Name = " + name);
//                }

                FTPFile[] ftpFiles = ftp.listFiles();
                for (FTPFile ftpFile : ftpFiles) {
                    //
                    // Check if FTPFile is a regular file
                    //
                    //  if (ftpFile.getType() == FTPFile.FILE_TYPE) {
                    System.out.println("FTPFile: " + ftpFile.getName() + "; " +
                            FileUtils.byteCountToDisplaySize(ftpFile.getSize()));
                    // }
                }
                System.out.println("Connection is end...");
                ftp.disconnect();
            } else {
                System.out.println("Connection Failed");
                ftp.disconnect();
            }

        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
//        FileOutputStream dfile;
//        try {
//            File file = new File("C://download2.jpg");
////            if (file.exists()) {
////                System.out.println("File alrdey exists closing...");
////                System.exit(1);
////            }
//            dfile = new FileOutputStream(file);
//            in = new FileInputStream(fl);
//            System.out.println("Connected Success");
//            System.out.println(ftp.storeFile("//temp.jpg", in));
//
//           // System.out.println(ftp.retrieveFile("pic.jpg", dfile));
//
//        } catch (IOException e) {
//            System.out.println(e);
//        }

    }

    public static void getDataFiles(String server,
            String username,
            String password,
            String folder,
            String destinationFolder,
            Calendar start,
            Calendar end) {
        try {
            // Connect and logon to FTP Server
            FTPClient ftp = new FTPClient();
            ftp.connect(server);
            ftp.login(username, password);
            System.out.println("Connected to " +
                    server + ".");
            System.out.print(ftp.getReplyString());

            // List the files in the directory
            ftp.changeWorkingDirectory(folder);
            FTPFile[] files = ftp.listFiles();
            System.out.println("Number of files in dir: " + files.length);
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
            for (int i = 0; i < files.length; i++) {
                Date fileDate = files[i].getTimestamp().getTime();
                if (fileDate.compareTo(start.getTime()) >= 0 &&
                        fileDate.compareTo(end.getTime()) <= 0) {
                    // Download a file from the FTP Server
                    System.out.print(df.format(files[i].getTimestamp().getTime()));
                    System.out.println("\t" + files[i].getName());
                    File file = new File(destinationFolder +
                            File.separator + files[i].getName());
                    FileOutputStream fos = new FileOutputStream(file);
                    ftp.retrieveFile(files[i].getName(), fos);
                    fos.close();
                    file.setLastModified(fileDate.getTime());
                }
            }

            // Logout from the FTP Server and disconnect
            ftp.logout();
            ftp.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zip;

/**
 *
 * @author APopov
 */
import java.io.*;
import java.util.zip.*;
import org.apache.commons.io.FileUtils;

public class UnZip {

    final static int BUFFER = 2048;

    public File unZip(File zipFile) {
        File output = null;
        try {
            BufferedOutputStream dest = null;
            FileInputStream fis = FileUtils.openInputStream(zipFile);
            ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                int count;
                byte data[] = new byte[BUFFER];
                System.out.println(entry.getName());
                output = new File(entry.getName());
                FileOutputStream fos = new FileOutputStream(output);
                dest = new BufferedOutputStream(fos, BUFFER);
                while ((count = zis.read(data, 0, BUFFER)) != -1) {
                    dest.write(data, 0, count);
                }
                dest.flush();
                dest.close();
            }
            zis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }
}


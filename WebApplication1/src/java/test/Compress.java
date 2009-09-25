/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipFile;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author APopov
 */
public class Compress {

    public static void main(String[] arg) throws IOException, ArchiveException {
        File fl = new File("C://testcsv.csv");
        File f2 = new File("C://testcsv.zip");
        final OutputStream out = new FileOutputStream(f2);
        ArchiveOutputStream os = new ArchiveStreamFactory().createArchiveOutputStream("zip", out);
        os.putArchiveEntry(new ZipArchiveEntry("xyi.csv"));
        IOUtils.copy(new FileInputStream(fl), os);
        os.closeArchiveEntry();
        os.close();

    }
}

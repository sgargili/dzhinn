/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.FactoryNixDAO;
import Pojo.Nixdata;
import SevenZip.Compression.LZMA.Decoder;
import SevenZip.Compression.LZMA.Encoder;
import csvprocessing.CsvReader;
import csvprocessing.CsvWriter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author APopov
 */
public class NewClass1 {

    public static void main(String[] args) throws IOException, SQLException {
        Long start = System.currentTimeMillis();
        CsvWriter csvw = new CsvWriter("C://MonitorLCD.csv", ',', Charset.forName("WINDOWS-1251"));
        String[] temp = new String[8];
        List<Nixdata> ndl = FactoryNixDAO.getInstance().getNixdataDAO().getAllNixdata();
        if (ndl.equals(null)) {
            System.exit(0);
        }
        Collections.sort(ndl, new Comparator<Nixdata>() {

            public int compare(Nixdata o1, Nixdata o2) {
                try {
                    String withoutEx1 = o1.getArticle();
                    String withoutEx2 = o2.getArticle();
                    return withoutEx1.compareTo(withoutEx2);
                } catch (NullPointerException e) {
                    return "".compareTo("");
                }
            }
        });
        long i = 0;
        for (Iterator it = ndl.iterator(); it.hasNext();) {
            Nixdata ndt = (Nixdata) it.next();
            Pattern p = Pattern.compile("(то\\sупало\\sв\\sпарсере)|(СЛИТО)");
            Matcher m = p.matcher(ndt.getFullName());
            if (m.find()) {
                continue;
            }
            p = Pattern.compile("LCD мониторы");
            m = p.matcher(ndt.getProductType());
            if (m.find()) {
                try {
                    temp[0] = ndt.getFullName().replaceAll("\\s+", " ").replaceAll("\\s/", "/");
                    temp[1] = ndt.getManufacturer().replaceAll("\\s+", " ");
                    temp[2] = ndt.getArticle();
                    temp[3] = ndt.getProductType().replaceAll("\\s+", " ");
                    temp[4] = ndt.getPictureUrl();
                    temp[5] = ndt.getGroupe().replaceAll("\\s+", " ");
                    if (!(ndt.getAttribute() == null) && !ndt.getAttribute().equals("")) {
                        temp[6] = ndt.getAttribute().replaceAll("\\s+", " ");
                    }
//                    if (!ndt.getAttributeValue().equals("")) {
                    temp[7] = ndt.getAttributeValue().replaceAll("\\s+", " ");
//                    } else {
//                        temp[0] = "";
//                        temp[1] = "";
//                        temp[2] = "";
//                        temp[3] = "";
//                        temp[4] = "";
//                        temp[5] = "";
//                        temp[6] = "";
//                        temp[7] = "";
//                    }
                    if (temp[7].equals("")) {
                        continue;
                    }
                    csvw.writeRecord(temp);
                } catch (NullPointerException e) {
                    System.out.println(i + " -> " + e + " -> " + ndt.getArticle());
                }
            }
            i++;
        }
        //csvw.flush();
        csvw.close();
//        File fl = new File("C://testcsv.csv");
//        BufferedInputStream inStream = new BufferedInputStream(FileUtils.openInputStream(fl));
//        BufferedOutputStream outStream = new BufferedOutputStream(FileUtils.openOutputStream(new File("C://testcsv.7z")));
//        Encoder encoder = new Encoder();
//
//        encoder.SetEndMarkerMode(true);
//        encoder.WriteCoderProperties(outStream);
//        long fileSize;
//
//        fileSize = fl.length();
//
//        for (int i = 0; i < 8; i++) {
//            outStream.write((int) (fileSize >>> (8 * i)) & 0xFF);
//        }
//        encoder.Code(inStream, outStream, 0, 0, null);
//        outStream.flush();
//        outStream.close();
//        inStream.close();
        Long end = System.currentTimeMillis();
        System.out.println(end - start + " ms");
    }
}

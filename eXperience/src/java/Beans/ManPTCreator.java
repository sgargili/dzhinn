package Beans;

/**
 *
 * @author Admin4DB2
 */
import csvprocessing.elabCsvManPT;
import csvprocessing.elabCsvMatch;
import csvprocessing.elabCsvSupp;
import java.io.*;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import xlsprocessing.elabXlsMatch;
import xlsprocessing.elabXslSupp;

public class ManPTCreator {

    private String elabXLS(File fl, String type) throws SQLException {
        if (type.equals("Supplier")) {
            elabXslSupp exs = new elabXslSupp();
            return exs.addSupplierPrice(fl);
        } else {
            if (type.equals("Matching")) {
                elabXlsMatch exm = new elabXlsMatch();
                return exm.addMatching(fl);
            }
            return "";
        }
    }

    private String elabCSV(File fl, boolean bool) throws SQLException, IOException {
        elabCsvManPT ecm = new elabCsvManPT();
        return ecm.addManPT(fl, bool);
    }

    private File elabZip(File file) throws ZipException, IOException {
        ZipFile zip = new ZipFile(file);

        String output = "";
        for (Enumeration e = zip.entries(); e.hasMoreElements();) {
            ZipEntry entry = (ZipEntry) e.nextElement();
            output = entry.getName();
        }
        File fl = new File(output);
        ZipInputStream inStream = new ZipInputStream(new FileInputStream(file));
        OutputStream outStream = new FileOutputStream(fl);
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
        return fl;
    }

    private File createFile(InputStream inp, String fileName) {
        try {
            File f = new File(fileName);
            OutputStream out = new FileOutputStream(f);
            byte buf[] = new byte[1024];
            int len;
            while ((len = inp.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.close();
            inp.close();
            return f;
        } catch (IOException e) {
            return null;
        }

    }

    private boolean validate(String fileName) {
        String re = "([.]zip$)|([.]csv$)|([.]xls$)";
        Pattern p = Pattern.compile(re);
        Matcher m = p.matcher(fileName);
        if (m.find()) {
            return true;
        }
        return false;
    }

    public String writeToFile(InputStream uploadFile, boolean cheker, String filename) throws ZipException, IOException, SQLException {

        if (!validate(filename)) {
            return "Не верный формат файла. Поддерживаемые форматы: csv, xls, zip(csv,xls).";
        }

        File fl = null;

        String temp = "";

        String re = "([0-9a-zA-Zа-яА-Я-_]+[.].{3})";
        Pattern p = Pattern.compile(re);
        Matcher m = p.matcher(filename);

        if (m.find()) {

            try {
                temp = m.group();
                fl = createFile(uploadFile, temp);
            } catch (Exception ex) {
            }

            re = "[.]zip$";
            p = Pattern.compile(re);
            m = p.matcher(filename);
            if (m.find()) {
                fl = elabZip(fl);
                if (!validate(fl.getName())) {
                    return "Не верный формат файла в архиве. Поддерживаемые форматы: csv, xls.";
                }
                re = "[.]xls$";
                p = Pattern.compile(re);
                m = p.matcher(fl.getName());
                if (m.find()) {
        //            temp = elabXLS(fl, type);
                } else {
                    temp = elabCSV(fl, cheker);
                }
            } else {
                re = "[.]xls$";
                p = Pattern.compile(re);
                m = p.matcher(temp);
                if (m.find()) {
               //     temp = elabXLS(fl, type);
                } else {
                    temp = elabCSV(fl, cheker);
                }
            }
        }
        fl.delete();
        return temp;
    }
}

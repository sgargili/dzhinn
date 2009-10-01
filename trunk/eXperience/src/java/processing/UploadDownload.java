package processing;

import Beans.ManPTCreator;
import Beans.fCreator;
import httpClientPack.HttpClientManPT;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipException;
import org.apache.commons.io.FileUtils;
import org.directwebremoting.io.FileTransfer;
import org.xmlpull.v1.XmlPullParserException;

public class UploadDownload {

    public String uploadFile(InputStream uploadFile, String fileName, String type, String SupplierName) throws ZipException, IOException, SQLException {
        fCreator fc = new fCreator();
        return fc.writeToFile(fileName, uploadFile, type, SupplierName);
        //return fileName;
    }

    public String setManPT(InputStream uploadFile, String priz, String fileName) throws ZipException, IOException, SQLException {
        boolean bool = false;
        if (priz.equals("true")) {
            bool = true;
        }
        ManPTCreator mc = new ManPTCreator();

        return mc.writeToFile(uploadFile, bool, fileName);
    }

    public String createUpdateManPt() throws SQLException, XmlPullParserException, IOException {
        Long time1 = System.currentTimeMillis();
        HttpClientManPT updManPt = new HttpClientManPT();
        String temp = updManPt.getManPt();
        Long time2 = System.currentTimeMillis();
        return temp;
        // return "Обновлено за: " + (time2 - time1) / 1000 + " сек.";
    }

    public FileTransfer convertXLSCSV(InputStream uploadFile, String fileName, String encoding, String checkSeparator, String checkZip) throws Exception {
        Pattern p = Pattern.compile("(\\.csv)|(\\.xls)");
        Matcher m = p.matcher(fileName);
        if (!m.find()) {
            return null;
        }
        Xls2Csv x2c = new Xls2Csv();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        File fl;
        p = Pattern.compile("\\.csv");
        m = p.matcher(fileName);
        if (m.find()) {
            fileName = fileName.replaceAll("(.*\\\\)?(.+)\\.csv", "$2");
            fl = x2c.convertCsv2Csv(uploadFile, fileName, encoding, checkSeparator, checkZip);
        } else {
            fileName = fileName.replaceAll("(.*\\\\)?(.+)\\.xls", "$2");
            fl = x2c.convertXls2Csv(uploadFile, fileName, encoding, checkSeparator, checkZip);
        }
        buffer.write(FileUtils.readFileToByteArray(fl));
        if (checkZip.equals("true")) {
            return new FileTransfer(fileName + ".zip", "application/x-zip-compressed", buffer.toByteArray());
        } else {
            return new FileTransfer(fileName + ".csv", "csv/text", buffer.toByteArray());
        }
    }
}

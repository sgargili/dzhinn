package processing;

import Beans.ManPTCreator;
import Beans.fCreator;
import httpClientPack.HttpClientManPT;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.zip.ZipException;
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
}

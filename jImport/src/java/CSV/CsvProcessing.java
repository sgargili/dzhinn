package CSV;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.directwebremoting.io.FileTransfer;

public class CsvProcessing {

    private static final Logger LOG = Logger.getLogger(CsvProcessing.class);

    public FileTransfer convertXLSCSV(InputStream uploadFile, String fileName, String encoding, String checkSeparator, String checkZip, String engine) throws Exception {
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
            if (engine.equals("Jexcel")) {
                fileName = fileName.replaceAll("(.*\\\\)?(.+)\\.xls", "$2");
                fl = x2c.convertXls2CsvV1(uploadFile, fileName, encoding, checkSeparator, checkZip);
            } else {
                fileName = fileName.replaceAll("(.*\\\\)?(.+)\\.xls", "$2");
                fl = x2c.convertXls2CsvV2(uploadFile, fileName, encoding, checkSeparator, checkZip);
            }
        }
        buffer.write(FileUtils.readFileToByteArray(fl));
        if (checkZip.equals("true")) {
            return new FileTransfer(fileName + ".zip", "application/x-zip-compressed", buffer.toByteArray());
        } else {
            return new FileTransfer(fileName + ".csv", "csv/text", buffer.toByteArray());
        }
    }

    public FileTransfer fixItprofitFile(InputStream uploadFile, String fileName) throws Exception {
        Pattern p = Pattern.compile("(\\.csv)|(\\.zip)");
        LOG.info("(\\.csv)|(\\.zip)");
        Matcher m = p.matcher(fileName);
        if (!m.find()) {
            return null;
        }
        Xls2Csv x2c = new Xls2Csv();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        File fl = null;
        p = Pattern.compile("\\.csv");
        m = p.matcher(fileName);
        if (m.find()) {
            fileName = fileName.replaceAll("(.*\\\\)?(.+)\\.csv", "$2");
            fl = x2c.fixIt4profitFile(uploadFile, fileName, false);
        } else {
            LOG.info("Зип нах пошел...");
            fileName = fileName.replaceAll("(.*\\\\)?(.+)\\.zip", "$2");
            fl = x2c.fixIt4profitFile(uploadFile, fileName, true);
        }
        buffer.write(FileUtils.readFileToByteArray(fl));
        LOG.info("Выполнилось...");
        return new FileTransfer(fileName + ".zip", "application/x-zip-compressed", buffer.toByteArray());
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package processing;

/**
 *
 * @author APopov
 */
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.*;

public class Xls2Csv {

    public File convert(InputStream uploadFile, String fileName, String encoding, String checkSeparator, String checkZip) throws IOException {
        File file = new File("temp.csv");
        boolean sepbool = false, zipbool = false;
        if (checkSeparator.equals("true")) {
            sepbool = true;
        }
        if (checkZip.equals("true")) {
            zipbool = true;
        }
        IOUtils.copyLarge(uploadFile, FileUtils.openOutputStream(file));
        File file2 = new File(fileName);
        List lines = FileUtils.readLines(file, encoding);
        String re;
        Pattern p;
        Matcher m;
        if (sepbool) {
            int i = 0;
            for (Iterator it = lines.iterator(); it.hasNext();) {
                String str = (String) it.next();
                str = str.replaceAll(";", ",");
                str = str.trim();
                lines.set(i, str);
                i++;
            }
        } else {
            int i = 0;
            for (Iterator it = lines.iterator(); it.hasNext();) {
                String str = (String) it.next();
                str = str.replaceAll("\"", "\"\"");
                str = str.replaceAll(";", "\",\"");
                re = "(^.)";
                p = Pattern.compile(re);
                m = p.matcher(str);
                if (m.find()) {
                    str = m.replaceAll("\"$1");
                }
                re = "(.$)";
                p = Pattern.compile(re);
                m = p.matcher(str);
                if (m.find()) {
                    str = m.replaceAll("$1\"");
                }
                str = str.replaceAll("\"{3,}", "\"\"");
                str = str.trim();
                lines.set(i, str);
                i++;
            }
        }
        FileUtils.writeLines(file2, encoding, lines);
        if (zipbool) {
            
        }
        return file2;
    }
}


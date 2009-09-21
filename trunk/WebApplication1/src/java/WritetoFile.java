
import com.sun.syndication.io.XmlReader;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.*;

public class WritetoFile {

    public static void main(String[] args) throws IOException {
        File file = new File("C://111.xml");
        File file2 = new File("C://softAllDone.csv");
        XmlReader xr = new XmlReader(file);
        String encoding = xr.getEncoding();
        System.out.println(encoding);
        List lines = FileUtils.readLines(file, "WINDOWS-1251");
        String re;
        Pattern p;
        Matcher m;
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
            str = str.trim();
            lines.set(i, str);
            i++;
        }
        FileUtils.writeLines(file2, "UTF-8", lines);
    }
}

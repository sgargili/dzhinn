/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.FactoryDAO;
import Pojo.Nixdata;
import csvprocessing.CsvReader;
import csvprocessing.CsvWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author APopov
 */
public class NewClass1 {

    public static void main(String[] args) throws IOException, SQLException {
        CsvWriter csvw = new CsvWriter("C://testcsv.csv", ',', Charset.forName("UTF-8"));
        String[] temp = new String[8];
        List<Nixdata> ndl = FactoryDAO.getInstance().getNixdataDAO().getAllNixdata();
        for (Iterator it = ndl.iterator(); it.hasNext();) {
            Nixdata ndt = (Nixdata) it.next();
            Pattern p = Pattern.compile("то\\sупало\\sв\\sпарсере");
            Matcher m = p.matcher(ndt.getFullName());
            if (m.find()) {
                continue;
            }
            temp[0] = ndt.getFullName();
            temp[1] = ndt.getManufacturer();
            temp[2] = ndt.getArticle();
            temp[3] = ndt.getProductType();
            temp[4] = ndt.getPictureUrl();
            temp[5] = ndt.getGroupe();
            temp[6] = ndt.getAttribute();
            temp[7] = ndt.getAttributeValue();
            csvw.writeRecord(temp);
        }
        csvw.flush();
        csvw.close();
    }
}

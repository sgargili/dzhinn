/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.FactoryDAO;
import com.thoughtworks.xstream.XStream;
//import dao.FactoryDAO;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.io.FileUtils;
//import pojo.Keymarketing;

/**
 *
 * @author Apopov
 */
public class xmlOutput {

    public static void main(String[] args) throws SQLException, IOException {
//        List data = FactoryDAO.getInstance().getKeyMarketingDAO().getAllKeydata();
//        XStream xstream = new XStream();
////        xstream.alias("item", Keymarketing.class);
////        xstream.alias("list", List.class);
////        xstream.registerConverter(new xmlConvertor());
//        OutputStream out = FileUtils.openOutputStream(new File("D://keyMarketing.xml"));
//        xstream.toXML(data, out);
//        out.flush();
//        out.close();
    }
}

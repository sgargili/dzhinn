/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gkey;

import com.thoughtworks.xstream.XStream;
import dao.FactoryDAO;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import pojo.Keymarketing;

/**
 *
 * @author Apopov
 */
public class xmlOutput {

    public static void main(String[] args) throws SQLException, IOException {
        List data = FactoryDAO.getInstance().getKeyMarketingDAO().getAllKeydata();
        XStream xstream = new XStream();
        xstream.alias("item", Keymarketing.class);
        xstream.alias("list", List.class);
        //xstream.registerConverter(new marketingConvertor());
        xstream.omitField(Keymarketing.class, "id");
        xstream.aliasField("id", Keymarketing.class, "keyarticle");
        xstream.useAttributeFor(Keymarketing.class, "id");
        xstream.useAttributeFor(Keymarketing.class, "keyarticle");
        xstream.setMode(XStream.NO_REFERENCES);
        //xstream.registerLocalConverter(Keymarketing.class, "keymarketing", new marketingConvertor());
        

        //xstream.addImplicitCollection(Keymarketing.class, "id");
        //xstream.alias("phonenumber", PhoneNumber.class);
        String xml = xstream.toXML(data);
        System.out.println(xml);
        FileUtils.writeStringToFile(new File("C://OldCategoriesnew.xml"), xml, "UTF-8");


    }
}

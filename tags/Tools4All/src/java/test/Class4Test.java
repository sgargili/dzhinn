/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.FactoryDAO4Imports;
import pojo.Categories;
import pojo.oldCat;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author APopov
 */
public class Class4Test {

    @SuppressWarnings("static-access")
    public static void main(String[] args) throws SQLException, IOException {
        List<oldCat> oldList = new ArrayList();
        oldCat oc;
        @SuppressWarnings("static-access")
        FactoryDAO4Imports factory = FactoryDAO4Imports.getInstance();
        @SuppressWarnings("static-access")
        List<oldCat> lst = (List<oldCat>) factory.getCategoriesDAO().getAllCategoriesNew();

        XStream xstream = new XStream();
        xstream.alias("OldCat", oldCat.class);
        xstream.alias("OldCats", List.class);
        xstream.useAttributeFor(oldCat.class, "Cat");
        xstream.useAttributeFor(oldCat.class, "Pic");
        //xstream.alias("phonenumber", PhoneNumber.class);
        String xml = xstream.toXML(oldList);
        System.out.println(xml);
        FileUtils.writeStringToFile(new File("C://OldCategoriesnew.xml"), xml, "UTF-8");
    }
}
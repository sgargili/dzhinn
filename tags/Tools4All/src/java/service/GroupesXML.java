/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.thoughtworks.xstream.XStream;
import factories.FactoryDAO4Grabli;
import java.util.ArrayList;
import java.util.List;
import pojo.Groupe;
import pojo.ProductType;

/**
 *
 * @author Apopov
 */
public class GroupesXML {

    FactoryDAO4Grabli fd = FactoryDAO4Grabli.getInstance();
    XStream xstream = new XStream();
    List groupeList = new ArrayList();
    long id;
    String xml;

    private void initXstream() {
        xstream.alias("Groupes", List.class);
        xstream.alias("Groupe", Groupe.class);
        xstream.aliasField("Id", Groupe.class, "groupeId");
        xstream.aliasField("Name", Groupe.class, "groupeName");
        xstream.omitField(Groupe.class, "attributes");
        xstream.omitField(Groupe.class, "productTypes");

    }

    public String getAllGroupes() {
        groupeList = fd.getGroupeDAO().getAllGroupesOnly();
        initXstream();
        xml = xstream.toXML(groupeList);
        return xml;
    }

    public String getGroupesByPtId(int id) {
        groupeList = fd.getGroupeDAO().getGroupesOnlyByProductTypeId(id);
        initXstream();
        xml = xstream.toXML(groupeList);
        return xml;
    }

    public String getGroupesByPtName(String ptName) {
        ProductType pt = fd.getProductTypeDAO().getProductTypeByName(ptName);
        groupeList = fd.getGroupeDAO().getGroupesOnlyByProductTypeId(pt.getProductTypeId());
        initXstream();
        xml = xstream.toXML(groupeList);
        return xml;
    }

    public String getGroupesByTemplate(String template) {
        groupeList = fd.getGroupeDAO().getGroupesOnlyByTemplate(template);
        initXstream();
        xml = xstream.toXML(groupeList);
        return xml;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author APopov
 */
import factories.FactoryDAO;
import pojo.ValueUser;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

public class ValueUsers {

    FactoryDAO fd = FactoryDAO.getInstance();
    XStream xstream = new XStream();
    List vUsersList = new ArrayList();
    long id;
    String xml;

    private void initXstream() {
        xstream.alias("Owners", List.class);
        xstream.alias("Owner", ValueUser.class);
        xstream.aliasField("Id", ValueUser.class, "id");
        xstream.aliasField("Name", ValueUser.class, "name");
    }

    public String getValueUsers() {
        vUsersList = fd.getValueUserDAO().getAllValueUsers();
        initXstream();
        xml = xstream.toXML(vUsersList);
        return xml;
    }

    public String getValueUserById(long id) {
        ValueUser vu;
        vu = fd.getValueUserDAO().getValueUserById(id);
        if (vu != null) {
            vUsersList.add(vu);
        }
        initXstream();
        xml = xstream.toXML(vUsersList);
        return xml;
    }

    public String getValueUsersByName(String name) {
        vUsersList = fd.getValueUserDAO().getValueUserByName(name);
        initXstream();
        xml = xstream.toXML(vUsersList);
        return xml;
    }
}

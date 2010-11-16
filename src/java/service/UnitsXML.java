/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.thoughtworks.xstream.XStream;
import factories.FactoryDAO4Grabli;
import java.util.ArrayList;
import java.util.List;
import pojo.Unit;

/**
 *
 * @author APopov
 */
public class UnitsXML {

    FactoryDAO4Grabli fd = FactoryDAO4Grabli.getInstance();
    XStream xstream = new XStream();
    List unitsList = new ArrayList();
    long id;
    String xml;

    private void initXstream() {
        xstream.alias("Units", List.class);
        xstream.alias("Unit", Unit.class);
        xstream.aliasField("Id", Unit.class, "unitId");
        xstream.aliasField("Name", Unit.class, "unitName");
        xstream.aliasField("AltName", Unit.class, "unitAlternative");
        xstream.omitField(Unit.class, "unitAlternativeNames");

    }

    public String getAllUnits() {
        unitsList = fd.getUnitDAO().getAllUnitsOnly();
        initXstream();
        xml = xstream.toXML(unitsList);
        return xml;
    }

//    public String getUnitsByPtId(int id) {
//        unitsList = fd.getAttributeDAO().getAttributesOnlyByProductTypeId(id);
//        initXstream();
//        xml = xstream.toXML(unitsList);
//        return xml;
//    }

    public String getUnitsPtName(String unitName) {
        unitsList = fd.getUnitDAO().getUnitsOnlyByTemplate(unitName);
        initXstream();
        xml = xstream.toXML(unitsList);
        return xml;
    }
}

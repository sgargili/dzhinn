/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.thoughtworks.xstream.XStream;
import factories.FactoryDAO4Grabli;
import java.util.ArrayList;
import java.util.List;
import pojo.UnitAlternativeName;

/**
 *
 * @author Apopov
 */
public class UnitsAltXML {

    FactoryDAO4Grabli fd = FactoryDAO4Grabli.getInstance();
    XStream xstream = new XStream();
    List unitsList = new ArrayList();
    long id;
    String xml;

    private void initXstream() {
        xstream.alias("Unit", List.class);
        xstream.alias("UnitAltName", UnitAlternativeName.class);
        xstream.aliasField("Id", UnitAlternativeName.class, "unitAlternativeNameId");
        xstream.aliasField("Name", UnitAlternativeName.class, "unitAlternativeNameValue");
        xstream.omitField(UnitAlternativeName.class, "unit");

    }

    public String getAllUnitAlternativeNames() {
        unitsList = fd.getUnitAlternativeNameDAO().getAllUnitAlternativeNamesOnly();
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
    public String getUnitAlternativeNamesByUnitId(int unitId) {
        unitsList = fd.getUnitAlternativeNameDAO().getAllUnitAlternativeNamesByUnitId(unitId);
        initXstream();
        xml = xstream.toXML(unitsList);
        return xml;
    }
}

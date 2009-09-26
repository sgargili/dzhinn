/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package processing;

import DAO.FactoryDAO;
import Pojo.Manufacturer;
import httpClientPack.HttpClientManPT;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author APopov
 */
public class ManufacturerAll {

    public String getAll(String Request) throws Exception {
        Collection manufacturers = FactoryDAO.getInstance().getManufacturerDAO().getAllManufacturers();
        List lst = new ArrayList();
        lst = (List) manufacturers;
        String Resp = "";
        Collections.sort(lst, new Comparator<Manufacturer>() {

            public int compare(Manufacturer o1, Manufacturer o2) {
                String withoutEx1 = o1.getManufacturerName();
                String withoutEx2 = o2.getManufacturerName();
                return withoutEx1.compareTo(withoutEx2);
            }
//            public int compare(DataBean o1, DataBean o2) {
//                throw new UnsupportedOperationException("Not supported yet.");
//            }
        });
        // Resp = "<select id=\"s1\">";
        int i = 0;
        Iterator iterator = manufacturers.iterator();
        while (iterator.hasNext()) {
            Resp = "<select id='selManufac'>";
            while (iterator.hasNext()) {
                Manufacturer manufacturer = (Manufacturer) iterator.next();
                Resp += "<option value='" + manufacturer.getManufacturerId() + "'>";
                Resp += manufacturer.getManufacturerName();
                Resp += "</option>";
            }
            Resp += "</select>";
//            Manufacturer manufacturer = (Manufacturer) iterator.next();
//            Resp += manufacturer.getManufacturerName() + ";&nbsp;";
//            i++;
        }
        // Resp += "</select>";
        return Resp;
    }

    public String addNew(String Id, String Name) throws Exception {
        Manufacturer man = new Manufacturer(Long.parseLong(Id), Name);
        FactoryDAO.getInstance().getManufacturerDAO().addManufacturer(man);
        return "Done";
    }

    public String updateManPT() throws Exception {
        HttpClientManPT hcm = new HttpClientManPT();
        String str = hcm.getManPt();
        return str;
    }
}

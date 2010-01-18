/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gnix;

import dao.FactoryDAO;
import java.util.Iterator;
import java.util.List;
import pojo.NixInputData;
import pojo.PtLink;

/**
 *
 * @author APopov
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        NixProcessing nix = NixProcessing.getInstance();
        FactoryDAO fd = FactoryDAO.getInstance();

        List generalLinks = nix.getAllNixPT();
        List allLinks;

        PtLink pt;
        NixInputData nid;

        String tempLink = "";

        for (Iterator it = generalLinks.iterator(); it.hasNext();) {
            pt = (PtLink) it.next();
            System.out.println(pt.getProductType() + " - " + pt.getLink());
            allLinks = nix.getDepartmentNixLinks(pt.getLink());
            for (Iterator it2 = allLinks.iterator(); it2.hasNext();) {
                tempLink = (String) it2.next();
                nid = new NixInputData();
                nid.setProductType(pt.getProductType());
                nid.setProductUrl(tempLink);
                fd.getNixInputDataDAO().addNixInputData(nid);
            }
        }
    }
}

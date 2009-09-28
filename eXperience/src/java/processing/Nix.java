/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package processing;

import DAO.FactoryNixDAO;
import Pojo.Nixlinks;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author APopov
 */
public class Nix {

    public String getPTStatus() throws SQLException {
        boolean bool = FactoryNixDAO.getInstance().getNixProcessDAO().getNixProcessById(0L);
        if (bool) {
            return "Updating in process...";
        } else {
            return "Ready for updating.";
        }
    }

    public String getAllPT() throws SQLException, IOException {
        String output = null;
        List<Nixlinks> all = FactoryNixDAO.getInstance().getNixlinksDAO().getAllNixlink();
        String[] PT = new String[all.size()];
        //System.out.println(all.get(0).getProductType());
        int i = 0;
        List<String> lstt = new ArrayList<String>();
        for (Iterator it = all.iterator(); it.hasNext();) {
            Nixlinks nlk = (Nixlinks) it.next();
            try {
                PT[i] = nlk.getProductType();
//                System.out.println(PT[i]);
                lstt.add(nlk.getProductType());
            } catch (NullPointerException e) {
                PT[i] = e.getMessage();
                lstt.add(e.getMessage());
            }
            i++;
        }
       // FileUtils.writeLines(new File("C://errors.txt"), lstt);
        ArrayDuplDel Add = new ArrayDuplDel();
        String[] outputPT = Add.ArrayDuplDel(PT);
        output = "<table bgcolor=black cellspacing='1' cellpadding='1' border=0 width=100%>";
        output += "<tr bgcolor = #2d4491><td align='center'><font color=white>№</font></td><td align='center'><font color=white>Product Type</font></td></tr>";
        for (i = 0; i < outputPT.length; i++) {
            output += "<tr bgcolor = #cfcdcd align='left'><td align='center' style='padding-left:4px'>" + i + "</td>" +
                    "<td style='padding-left:4px'>" + outputPT[i] + "</td></tr>";
        }
        output += "</table>";

        return output;
    }
}

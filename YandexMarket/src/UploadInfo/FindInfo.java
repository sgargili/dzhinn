/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UploadInfo;

import DAO.FactoryDAO;
import Pojo.KeyUploadInfo;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ilyahoo
 */
public class FindInfo {

    public static void main(String[] args) throws SQLException {
        FactoryDAO fd = FactoryDAO.getInstance();
        List<KeyUploadInfo> keys = (List<KeyUploadInfo>) fd.getUIKeysDAO().getAllKeys();
        int ctr;
        for (Iterator iter = keys.iterator(); iter.hasNext();) {
            KeyUploadInfo ks = (KeyUploadInfo) iter.next();
            ctr = 0;
            for (Iterator iter2 = keys.iterator(); iter.hasNext();) {
                ctr++;
                try {
                    KeyUploadInfo ks2 = (KeyUploadInfo) iter2.next();
                    if (ks.getUplKeyart().equals(ks2.getKeyart())) {
                        ks.setUplFulln(ks2.getFulln());
                        ks.setUplPt(ks2.getPt());
                        ks.setUplVendor(ks2.getVendor());
                        fd.getUIKeysDAO().addKeys(ks);
                        System.out.println(ks.getId() + ") Nashlos i zapisano...");
                        break;
                    }
                } catch (Exception ex) {
                    System.out.println("ostanovilis na " + ctr);
                    break;
                }

            }
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gkey;

import dao.FactoryDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import pojo.Keyhtml;

/**
 *
 * @author root
 */
public class SingleThreadGKeyFromDB {

    public static void main(String[] args) throws IOException, SQLException {
        List lst;
        Keyhtml tp;
        DownloadContentv2 dc = new DownloadContentv2();
        int j = 0;
        for (int k = 0; k < 10; k++) {
            lst = FactoryDAO.getInstance().getKeyHtmlDAO().getAllKeyHtml((10000 + 1) * k, 10000);
            for (Iterator it = lst.iterator(); it.hasNext();) {
                tp = (Keyhtml) it.next();
                try {
                    dc.load(j++ + "", Integer.parseInt(tp.getKeyarticle()), tp.getKeyhtml());
                } catch (Exception ex) {
                }
            }
            lst = null;
        }
    }
}

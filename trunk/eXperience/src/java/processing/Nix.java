/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package processing;

import DAO.FactoryNixDAO;
import java.sql.SQLException;

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
}

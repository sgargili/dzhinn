/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.ValueUser;
import java.util.List;

/**
 *
 * @author APopov
 */
public interface ValueUserDAO {

    public List getAllValueUsers();

    public ValueUser getValueUserById(long id);
}

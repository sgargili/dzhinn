/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import pojo.ValueUser;
import java.util.List;

/**
 *
 * @author APopov
 */
public interface ValueUserDAO {

    public List getAllValueUsers();

    public ValueUser getValueUserById(long id);

    public List getValueUserByName(String name);
}

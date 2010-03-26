/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojo.Soft;

/**
 *
 * @author APopov
 */
public interface SoftDAO {

    public void addSoft(Soft soft);

    public List getAllSofts();

    public List getAllNonEmptySofts();

    public Soft getSoftById(int id);
}

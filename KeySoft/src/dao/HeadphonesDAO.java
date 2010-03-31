/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojo.Headphones;

/**
 *
 * @author IRozhkov
 */
public interface HeadphonesDAO {

    public void addHeadphones(Headphones headphones);

    public List getAllHeadphones();

    public Headphones getHeadphonesById(int id);
}

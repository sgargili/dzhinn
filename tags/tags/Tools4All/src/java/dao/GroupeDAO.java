/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojo.Attribute;
import pojo.Groupe;
import pojo.ProductType;

/**
 *
 * @author APopov
 */
public interface GroupeDAO {

    public void addGroupe(Groupe groupe);

    public void addOrUpdateGroupeNameOnly(Groupe groupe);

    public void deleteGroupe(Groupe groupe);

    public List<Groupe> getAllGroupesOnly();

    public List<Groupe> getGroupesOnlyByProductType(ProductType productType);

    public List<Groupe> getGroupesByProductType(ProductType productType);

    public List<Groupe> getGroupesOnlyByProductTypeId(int id);

    public List<Groupe> getGroupesOnlyByAttribute(Attribute attribute);

    public List<Groupe> getGroupesOnlyByTemplate(String template);

    public List getGroupesWithAttributesByNativeSQL();

    public void updateGroupeCommentByNativeSQL(int id,String comment);

    public Groupe getGroupeById(int id);

    public Groupe getGroupeByName(String name);

    public Groupe getGroupeByIdWithAttributes(int id);

    public boolean isGroupePresent(Groupe groupe);

    public boolean isGroupePresent(String groupeName);
}

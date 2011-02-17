package imf.core.dao;

import java.util.List;

import imf.core.entity.Attribute;
import imf.core.entity.Group;

/**
 * Developed by: Andrey Popov
 * Date (time): 17.02.11 (15:04)
 */

public interface AttributeDao {
    Attribute saveAttribute(Attribute attribute);

    void saveOrUpdateAttribute(Attribute attribute);

    void updateAttribute(Attribute attribute);

    void deleteAttribute(Attribute attribute);

    void deleteAttributeById(Long id);

    List<Attribute> getAllAttributes();

    List<Attribute> getAttributes(int firstResult);

    List<Attribute> getAttributes(int firstResult, int maxResult);

    List<Attribute> getAllAttributesByGroup(Group group);

    List<Attribute> getAttributesByGroup(Group group, int firstResult);

    List<Attribute> getAttributesByGroup(Group group, int firstResult, int maxResult);

    Attribute getAttributeById(Long id);

    Long getTotalRows();

    Long getTotalRowsByGroupId(Long id);
}

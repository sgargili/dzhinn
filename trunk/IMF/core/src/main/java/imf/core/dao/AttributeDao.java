package imf.core.dao;

import java.util.List;

import imf.core.dto.AttributeDto;
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

    List<Attribute> getAllAttributesByName(String attributeName);

    List<Attribute> getAttributesByName(String attributeName, int firstResult);

    List<Attribute> getAttributesByName(String attributeName, int firstResult, int maxResult);

    List<AttributeDto> getAllAttributesDtoByGroup(Group group);

    List<AttributeDto> getAttributesDtoByGroup(Group group, int firstResult);

    List<AttributeDto> getAttributesDtoByGroup(Group group, int firstResult, int maxResult);

    Attribute getAttributeById(Long id);

    Boolean isAttributePresentByName(String name);

    Long getTotalRows();

    Long getTotalRowsByAttributeName(String attributeName);

    Long getTotalRowsByGroupId(Long id);
}

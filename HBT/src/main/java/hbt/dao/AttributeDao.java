package hbt.dao;

import java.util.List;

import hbt.model.Attribute;
import hbt.model.Group;

/**
 * Developed by: Andrey Popov
 * Date (time): 24.02.11 (17:38)
 */

public interface AttributeDao {
    Attribute getAttributeById(Long id);
    List<Attribute> getAttributes();
    List<Attribute> getAllAttributesByGroup(Group group);
}

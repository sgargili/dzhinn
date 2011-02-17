package imf.core.dao;

import java.util.List;

import imf.core.entity.Group;
import imf.core.entity.Template;

/**
 * Developed by: Andrey Popov
 * Date (time): 17.02.11 (15:13)
 */

public interface GroupDao {
    Group saveGroup(Group group);

    void saveOrUpdateGroup(Group group);

    void updateGroup(Group group);

    void deleteGroup(Group group);

    List<Group> getAllGroups();

    List<Group> getGroups(int firstResult);

    List<Group> getGroups(int firstResult, int maxResult);

    List<Group> getAllGroupByTemplate(Template template);

    List<Group> getAllGroupByTemplate(Template template, int firstResult);

    List<Group> getAllGroupByTemplate(Template template, int firstResult, int maxResult);

    Group getGroupById(Long id);

    Long getTotalRows();

    Long getTotalRowsByTemplateId(Long id);
}

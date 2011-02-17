package imf.core.dao;

import java.util.List;

import imf.core.entity.Template;

/**
 * Developed by: Andrey Popov
 * Date (time): 17.02.11 (15:42)
 */

public interface TemplateDao {
    Template saveTemplate(Template template);

    void saveOrUpdateTemplate(Template template);

    void updateTemplate(Template template);

    void deleteTemplate(Template template);

    List<Template> getAllTemplates();

    List<Template> getTemplates(int firstResult);

    List<Template> getTemplates(int firstResult, int maxResult);

    Template getTemplateById(Long id);

    Template getTemplateWithGroupsAndAttributesById(Long id);

    Long getTotalRows();

}

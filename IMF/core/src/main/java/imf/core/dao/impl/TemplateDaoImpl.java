package imf.core.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import imf.core.config.SqlScalarTypesConfig;
import imf.core.dao.TemplateDao;
import imf.core.dto.AttributeDto;
import imf.core.dto.GroupDto;
import imf.core.dto.TemplateDto;
import imf.core.entity.Template;

/**
 * Developed by: Andrey Popov
 * Date (time): 06.03.11 (19:15)
 */
@Repository("templateDao")
public class TemplateDaoImpl implements TemplateDao {

    private Logger log = LoggerFactory.getLogger(TemplateDaoImpl.class);

    @Autowired
    private SqlScalarTypesConfig sqlScalarTypesConfig;

    private String getSqlQuery4TemplatesDto() {

        log.info("Getting SqlString for AttributesDto query...");

        return sqlScalarTypesConfig.getSqlMap().get("sql4TemplatesDto");
    }

    private SQLQuery setScalarTypes4TemplatesDto(SQLQuery query) {

        log.info("Setting Scalar Values for TemplatesDto query...");

        Map<String, AbstractSingleColumnStandardBasicType> scalarMap = sqlScalarTypesConfig.getScalarMap().get("scalarTypes4AttributesDto");

        for (Map.Entry<String, AbstractSingleColumnStandardBasicType> entry : scalarMap.entrySet()) {
            query.addScalar(entry.getKey(), entry.getValue());
        }

        return query;
    }

    private TemplateDto getTemplateDtoFromList(List<Map<String, Object>> data) {

        TemplateDto templateDto = new TemplateDto();
        GroupDto groupDto = new GroupDto();
        AttributeDto attributeDto;

        for (Map<String, Object> map : data) {
            if (templateDto.getId() == null) {
                templateDto.setId((Long) map.get("templateId"));
                templateDto.setName((String) map.get("templateName"));
            }

            attributeDto = new AttributeDto();
            attributeDto.setId((Long) map.get("attributeId"));
            attributeDto.setName((String) map.get("attributeName"));
            attributeDto.setWeight((Integer) map.get("attributeWeight"));
            attributeDto.setComposite((Boolean) map.get("attributeComposite"));
            attributeDto.setRequire((Boolean) map.get("attributeRequire"));

            if (!(map.get("groupId")).equals(groupDto.getId())) {
                groupDto = new GroupDto();
            }

            groupDto.setId((Long) map.get("groupId"));
            groupDto.setName((String) map.get("groupName"));
            groupDto.setWeight((Integer) map.get("groupWeight"));

            groupDto.addAttributeDto(attributeDto);

            if (!templateDto.getGroupDtos().contains(groupDto)) {
                templateDto.addGroupDtos(groupDto);
            }
        }
        return templateDto;
    }

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }


    @Override
    public Template saveTemplate(Template template) {
        template.setId((Long) hibernateTemplate.save(template));
        return template;
    }

    @Override
    public void saveOrUpdateTemplate(Template template) {
        hibernateTemplate.saveOrUpdate(template);
    }

    @Override
    public void updateTemplate(Template template) {
        hibernateTemplate.update(template);
    }

    @Override
    public void deleteTemplate(Template template) {
        hibernateTemplate.delete(template);
    }

    @Override
    @SuppressWarnings("unchecked")
    public TemplateDto getTemplateDto(Template template) {
        log.info("Building DAO request getAllTemplatesDtos(Template template) with templateId: {}", template.getId());

        String sql = getSqlQuery4TemplatesDto();

        SQLQuery query = hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(sql);

        query.setLong("templateId", template.getId());
        query = setScalarTypes4TemplatesDto(query);

        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

        return getTemplateDtoFromList(query.list());
    }

    @Override
    public Boolean isTemplatePresentByName(String templateName) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Template.class);
        criteria.add(Restrictions.eq("name", templateName));
        return criteria.list().size() > 0;
    }
}

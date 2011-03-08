package imf.core.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.NullableType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import imf.core.config.SqlScalarTypesConfig;
import imf.core.dao.TemplateDao;
import imf.core.dto.AttributeDto;
import imf.core.dto.GroupDto;
import imf.core.dto.TemplateDto;
import imf.core.entity.Template;

/**
 * Developed by: Администратор
 * Date (time): 06.03.11 (19:15)
 */
@Repository
@Service("templateDao")
public class TemplateDaoImpl implements TemplateDao {

    private Logger log = LoggerFactory.getLogger(TemplateDaoImpl.class);

    @Autowired
    private SqlScalarTypesConfig sqlScalarTypesConfig;

    private String getSqlQuery4TemplatesDto() {

        log.info("Getting SqlString for AttributesDto query...");

        /*StringBuffer sqlBuffer = new StringBuffer();

        sqlBuffer.append("select");
        sqlBuffer.append("    tpl.id as \"templateId\",");
        sqlBuffer.append("    tpl.\"name\" as \"templateName\",");
        sqlBuffer.append("    grp.id as \"groupId\",");
        sqlBuffer.append("    grp.\"name\" as \"groupName\",");
        sqlBuffer.append("    atr.id as \"attributeId\",");
        sqlBuffer.append("    atr.\"name\" as \"attributeName\",");
        sqlBuffer.append("    g2t.weight as \"attributeWeight\",");
        sqlBuffer.append("    a2g.weight as \"groupWeight\",");
        sqlBuffer.append("    a2g2t.required as \"attributeRequire\",");
        sqlBuffer.append("    a2g2t.composite as \"attributeComposite\" ");
        sqlBuffer.append("from ");
        sqlBuffer.append("    imf.attribute atr ");
        sqlBuffer.append("inner join ");
        sqlBuffer.append("    imf.attribute_2_group a2g");
        sqlBuffer.append("        on a2g.attribute_id = atr.id ");
        sqlBuffer.append("inner join");
        sqlBuffer.append("    imf.\"group\" grp");
        sqlBuffer.append("        on grp.id = a2g.group_id ");
        sqlBuffer.append("inner join");
        sqlBuffer.append("    imf.group_2_template g2t");
        sqlBuffer.append("        on g2t.group_id = grp.id ");
        sqlBuffer.append("inner join");
        sqlBuffer.append("    imf.\"template\" tpl");
        sqlBuffer.append("        on tpl.id = g2t.template_id ");
        sqlBuffer.append("inner join");
        sqlBuffer.append("    imf.attribute_2_group_2_template a2g2t");
        sqlBuffer.append("        on a2g2t.attribute_id = atr.id");
        sqlBuffer.append("        and a2g2t.group_id = grp.id");
        sqlBuffer.append("        and a2g2t.template_id = tpl.id ");
        sqlBuffer.append("where");
        sqlBuffer.append("    tpl.id = :templateId ");
        sqlBuffer.append("order by");
        sqlBuffer.append("    g2t.weight,");
        sqlBuffer.append("    a2g.weight");

        return sqlBuffer.toString();*/
        return sqlScalarTypesConfig.getSqlMap().get("sql4TemplatesDto");
    }

    private SQLQuery setScalarTypes4TemplatesDto(SQLQuery query) {

        log.info("Setting Scalar Values for TemplatesDto query...");

        Map<String, NullableType> scalarMap = sqlScalarTypesConfig.getScalarMap().get("ScalarTypes4TemplatesDto");

        for (Map.Entry<String, NullableType> entry : scalarMap.entrySet()) {
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

            if (!((Long) map.get("groupId")).equals(groupDto.getId())) {
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
    public TemplateDto getTemplateDto(Template template) {
        log.info("Building DAO request getAllTemplatesDtos(Template template) with templateId: {}", template.getId());

        String sql = getSqlQuery4TemplatesDto();

        SQLQuery query = hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(sql);

        query.setLong("templateId", template.getId());
        query = setScalarTypes4TemplatesDto(query);

        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

        return getTemplateDtoFromList(query.list());
    }
}

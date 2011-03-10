package imf.core.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.NullableType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import imf.core.config.SqlScalarTypesConfig;
import imf.core.dao.AttributeDao;
import imf.core.dto.AttributeDto;
import imf.core.entity.Attribute;
import imf.core.entity.Group;

/**
 * Developed by: Andrey Popov
 * Date (time): 17.02.11 (16:13)
 */
@Repository
@Service("attributeDao")
public class AttributeDaoImpl implements AttributeDao {

    private Logger log = LoggerFactory.getLogger(AttributeDaoImpl.class);

    @Autowired
    private SqlScalarTypesConfig sqlScalarTypesConfig;


    private String getSqlQuery4AttributesDto() {

        log.info("Getting SqlString for AttributesDto query...");

        return sqlScalarTypesConfig.getSqlMap().get("sql4AttributesDto");
    }

    private SQLQuery setScalarTypes4AttributesDto(SQLQuery query) {

        log.info("Setting Scalar Values for AttributesDto query...");

        Map<String, NullableType> scalarMap = sqlScalarTypesConfig.getScalarMap().get("ScalarTypes4TemplatesDto");

        for (Map.Entry<String, NullableType> entry : scalarMap.entrySet()) {
            query.addScalar(entry.getKey(), entry.getValue());
        }

        return query;
    }

     private String getLikePattern(String keyWord) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("%");
        buffer.append(keyWord);
        buffer.append("%");
        return buffer.toString();
    }

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public Attribute saveAttribute(Attribute attribute) {
        attribute.setId((Long) hibernateTemplate.save(attribute));
        return attribute;
    }

    @Override
    public void saveOrUpdateAttribute(Attribute attribute) {
        hibernateTemplate.saveOrUpdate(attribute);
    }

    @Override
    public void updateAttribute(Attribute attribute) {
        hibernateTemplate.update(attribute);
    }

    @Override
    public void deleteAttribute(Attribute attribute) {
        hibernateTemplate.delete(attribute);
    }

    @Override
    public void deleteAttributeById(Long id) {
        String deleteQuery = "delete from Attribute attribute where attribute.id = :id";
        Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(deleteQuery);
        query.setLong("id", id);
        query.executeUpdate();
    }

    @Override
    public List<Attribute> getAllAttributes() {
        return hibernateTemplate.loadAll(Attribute.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public List<Attribute> getAttributes(int firstResult) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Attribute.class);
        criteria.setFirstResult(firstResult);
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Attribute> getAttributes(int firstResult, int maxResult) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Attribute.class);
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResult);
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Attribute> getAllAttributesByName(String attributeName) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Attribute.class);
        criteria.add(Restrictions.ilike("name", getLikePattern(attributeName)));
        criteria.setFetchMode("unitsGroup", FetchMode.JOIN);
        criteria.setFetchMode("subsGroup", FetchMode.JOIN);
        criteria.setFetchMode("unitOfMeasure", FetchMode.JOIN);
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Attribute> getAttributesByName(String attributeName, int firstResult) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Attribute.class);
        criteria.add(Restrictions.ilike("name", getLikePattern(attributeName)));
        criteria.setFetchMode("unitsGroup", FetchMode.JOIN);
        criteria.setFetchMode("subsGroup", FetchMode.JOIN);
        criteria.setFetchMode("unitOfMeasure", FetchMode.JOIN);
        criteria.setFirstResult(firstResult);
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Attribute> getAttributesByName(String attributeName, int firstResult, int maxResult) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Attribute.class);
        criteria.add(Restrictions.ilike("name", getLikePattern(attributeName)));
        criteria.setFetchMode("unitsGroup", FetchMode.JOIN);
        criteria.setFetchMode("subsGroup", FetchMode.JOIN);
        criteria.setFetchMode("unitOfMeasure", FetchMode.JOIN);
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResult);
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<AttributeDto> getAllAttributesDtoByGroup(Group group) {

        log.info("Building DAO request getAllAttributesDtoByGroup(Group group) with groupId: {}", group.getId());

        String sql = getSqlQuery4AttributesDto();

        SQLQuery query = hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(sql);

        query.setLong("groupId", group.getId());
        query = setScalarTypes4AttributesDto(query);

        query.setResultTransformer(Transformers.aliasToBean(AttributeDto.class));

        return query.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<AttributeDto> getAttributesDtoByGroup(Group group, int firstResult) {
        log.info("Building DAO request getAllAttributesDtoByGroup(Group group) with groupId: {}", group.getId());

        String sql = getSqlQuery4AttributesDto();

        SQLQuery query = hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(sql);

        query.setLong("groupId", group.getId());
        query = setScalarTypes4AttributesDto(query);

        query.setFirstResult(firstResult);

        query.setResultTransformer(Transformers.aliasToBean(AttributeDto.class));

        return query.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<AttributeDto> getAttributesDtoByGroup(Group group, int firstResult, int maxResult) {
        log.info("Building DAO request getAllAttributesDtoByGroup(Group group) with groupId: {}", group.getId());

        String sql = getSqlQuery4AttributesDto();

        SQLQuery query = hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(sql);

        query.setLong("groupId", group.getId());
        query = setScalarTypes4AttributesDto(query);

        query.setFirstResult(firstResult);
        query.setMaxResults(maxResult);

        query.setResultTransformer(Transformers.aliasToBean(AttributeDto.class));

        return query.list();
    }

    @Override
    public Attribute getAttributeById(Long id) {
        return hibernateTemplate.get(Attribute.class, id);
    }

    @Override
    public Boolean isAttributePresentByName(String name) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Attribute.class);
        criteria.add(Restrictions.eq("name", name));
        return criteria.list().size() > 0;
    }

    @Override
    public Long getTotalRows() {
        return (Long) hibernateTemplate.getSessionFactory().getCurrentSession().
                getNamedQuery("Attribute.findAllAttributesCount").
                uniqueResult();
    }

    @Override
    public Long getTotalRowsByAttributeName(String attributeName) {
        return (Long) hibernateTemplate.getSessionFactory().getCurrentSession().
                getNamedQuery("Attribute.findAllAttributesCountByName").
                setString("attributeName", getLikePattern(attributeName)).
                uniqueResult();
    }

    @Override
    public Long getTotalRowsByGroupId(Long id) {
        return (Long) hibernateTemplate.getSessionFactory().getCurrentSession().
                getNamedQuery("Group.findAllGroupsCountByTemplateId").
                setLong("id", id).
                uniqueResult();
    }
}

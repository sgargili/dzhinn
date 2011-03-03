package imf.core.dao.impl;

import java.util.List;

import imf.core.dao.AttributeDao;
import imf.core.dto.AttributeDto;
import imf.core.entity.Attribute;
import imf.core.entity.Group;
import org.hibernate.*;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Developed by: Andrey Popov
 * Date (time): 17.02.11 (16:13)
 */
@Repository
@Service("attributeDao")
public class AttributeDaoImpl implements AttributeDao {

    private Logger log = LoggerFactory.getLogger(AttributeDaoImpl.class);


    private String getSqlQuery4AttributesDto() {

        log.info("Getting SqlString for AttributesDto query...");

        StringBuffer sqlBuffer = new StringBuffer();

        sqlBuffer.append("select ");
        sqlBuffer.append("  atr.id, ");
        sqlBuffer.append("  atr.comment, ");
        sqlBuffer.append("  atr.name, ");
        sqlBuffer.append("  atr.type, ");
        sqlBuffer.append("  atr.type_of_values as typeOfValues, ");
        sqlBuffer.append("  atr.subs_group_id as subsGroup, ");
        sqlBuffer.append("  atr.unit_id as unitOfMeasure, ");
        sqlBuffer.append("  atr.unit_group_id as unitsGroup,");
        sqlBuffer.append("  a2g.composite as composite, ");
        sqlBuffer.append("  a2g.requare as require, ");
        sqlBuffer.append("  a2g.comment as comment4Group ");
        sqlBuffer.append("from ");
        sqlBuffer.append("  imf.attribute atr ");
        sqlBuffer.append("inner join ");
        sqlBuffer.append("  imf.attribute_2_group a2g ");
        sqlBuffer.append("  on a2g.attribute_id = atr.id ");
        sqlBuffer.append("inner join ");
        sqlBuffer.append("  imf.group grp ");
        sqlBuffer.append("  on grp.id = a2g.group_id ");
        sqlBuffer.append("where ");
        sqlBuffer.append("  grp.id = :groupId");

        return sqlBuffer.toString();
    }

    private SQLQuery setScalarTypes4AttributesDto(SQLQuery query) {

        log.info("Setting Scalar Values for AttributesDto query...");

        query.addScalar("id", Hibernate.LONG);
        query.addScalar("name", Hibernate.STRING);
        query.addScalar("comment", Hibernate.STRING);
        query.addScalar("unitsGroup", Hibernate.LONG);
        query.addScalar("subsGroup", Hibernate.LONG);
        query.addScalar("unitOfMeasure", Hibernate.LONG);
        query.addScalar("type", Hibernate.BYTE);
        query.addScalar("typeOfValues", Hibernate.BYTE);
        query.addScalar("composite", Hibernate.BOOLEAN);
        query.addScalar("require", Hibernate.BOOLEAN);
        query.addScalar("comment4Group", Hibernate.STRING);

        return query;
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
        hibernateTemplate.save(attribute);
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
    public Long getTotalRows() {
        return ((List<Long>) hibernateTemplate.findByNamedQuery("Attribute.findAllAttributesCount")).get(0);

    }

    @Override
    public Long getTotalRowsByGroupId(Long id) {
        return (Long) hibernateTemplate.getSessionFactory().getCurrentSession().
                getNamedQuery("Attribute.findAllAttributesCountById").
                setLong("id", id).
                uniqueResult();
    }
}

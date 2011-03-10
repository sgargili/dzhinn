package imf.core.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.NullableType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import imf.core.config.SqlScalarTypesConfig;
import imf.core.dao.GroupDao;
import imf.core.dto.AttributeDto;
import imf.core.dto.GroupDto;
import imf.core.entity.Group;
import imf.core.entity.Template;

/**
 * Developed by: Andrey Popov
 * Date (time): 09.03.11 (17:11)
 */
@Repository
@Service("groupDao")
public class GroupDaoImpl implements GroupDao {

    private Logger log = LoggerFactory.getLogger(GroupDaoImpl.class);

    @Autowired
    private SqlScalarTypesConfig sqlScalarTypesConfig;


    private String getSqlQuery4GroupsDto() {

        log.info("Getting SqlString for AttributesDto query...");

        return sqlScalarTypesConfig.getSqlMap().get("sql4GroupsDto");
    }

    private SQLQuery setScalarTypes4GroupsDto(SQLQuery query) {

        log.info("Setting Scalar Values for AttributesDto query...");

        Map<String, NullableType> scalarMap = sqlScalarTypesConfig.getScalarMap().get("ScalarTypes4GroupsDto");

        for (Map.Entry<String, NullableType> entry : scalarMap.entrySet()) {
            query.addScalar(entry.getKey(), entry.getValue());
        }

        return query;
    }

    private List<GroupDto> getListGroupDtoFromNativeDataList(List<Map<String, Object>> data) {

        List<GroupDto> groupDtos = new ArrayList<GroupDto>();

        GroupDto groupDto = new GroupDto();
        AttributeDto attributeDto;

        for (Map<String, Object> map : data) {

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

            if (!groupDtos.contains(groupDto)) {
                groupDtos.add(groupDto);
            }
        }
        return groupDtos;
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
    public Group saveGroup(Group group) {
        group.setId((Long) hibernateTemplate.save(group));
        return group;
    }

    @Override
    public void saveOrUpdateGroup(Group group) {
        hibernateTemplate.saveOrUpdate(group);
    }

    @Override
    public void updateGroup(Group group) {
        hibernateTemplate.update(group);
    }

    @Override
    public void deleteGroup(Group group) {
        hibernateTemplate.delete(group);
    }

    @Override
    public List<Group> getAllGroups() {
        return hibernateTemplate.loadAll(Group.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Group> getGroupsByName(String groupName, int firstResult) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Group.class);
        criteria.add(Restrictions.ilike("name", getLikePattern(groupName)));
        criteria.setFirstResult(firstResult);
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Group> getGroupsByName(String groupName, int firstResult, int maxResult) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Group.class);
        criteria.add(Restrictions.ilike("name", getLikePattern(groupName)));
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResult);
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<GroupDto> getAllGroupsWithAttributes() {
        String sql = getSqlQuery4GroupsDto();

        SQLQuery query = hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(sql);

        query = setScalarTypes4GroupsDto(query);

        query.setParameter("firstResult", 0);
        query.setParameter("maxResult", Integer.MAX_VALUE);
        query.setString("groupName", "%");

        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

        return getListGroupDtoFromNativeDataList(query.list());
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<GroupDto> getGroupsWithAttributesByName(String groupName) {
        String sql = getSqlQuery4GroupsDto();

        SQLQuery query = hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(sql);

        query = setScalarTypes4GroupsDto(query);

        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

        query.setInteger("firstResult", 0);
        query.setInteger("maxResult", Integer.MAX_VALUE);
        query.setString("groupName", getLikePattern(groupName));

        return getListGroupDtoFromNativeDataList(query.list());
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<GroupDto> getGroupsWithAttributesByName(String groupName, int firstResult) {
        String sql = getSqlQuery4GroupsDto();

        SQLQuery query = hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(sql);

        query = setScalarTypes4GroupsDto(query);

        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

        query.setParameter("firstResult", firstResult);
        query.setParameter("maxResult", Integer.MAX_VALUE);
        query.setString("groupName", getLikePattern(groupName));

        return getListGroupDtoFromNativeDataList(query.list());
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<GroupDto> getGroupsWithAttributesByName(String groupName, int firstResult, int maxResult) {
        String sql = getSqlQuery4GroupsDto();

        SQLQuery query = hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(sql);

        query = setScalarTypes4GroupsDto(query);

        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

        query.setParameter("firstResult", firstResult);
        query.setParameter("maxResult", maxResult);
        query.setString("groupName", getLikePattern(groupName));

        return getListGroupDtoFromNativeDataList(query.list());
    }

    @Override
    public List<GroupDto> getAllGroupByTemplate(Template template) {
        return null;
    }

    @Override
    public List<GroupDto> getAllGroupByTemplate(Template template, int firstResult) {
        return null;
    }

    @Override
    public List<GroupDto> getAllGroupByTemplate(Template template, int firstResult, int maxResult) {
        return null;
    }

    @Override
    public List<GroupDto> getAllGroupWithAttributesByTemplate(Template template) {
        return null;
    }

    @Override
    public List<GroupDto> getAllGroupWithAttributesByTemplate(Template template, int firstResult) {
        return null;
    }

    @Override
    public List<GroupDto> getAllGroupWithAttributesByTemplate(Template template, int firstResult, int maxResult) {
        return null;
    }

    @Override
    public Group getGroupById(Long id) {
        return hibernateTemplate.get(Group.class, id);
    }

    @Override
    public Group getGroupWithAttributesById(Long id) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Group.class);
        criteria.setFetchMode("attributes", FetchMode.JOIN);
        criteria.add(Restrictions.eq("id", id));
        return (Group) criteria.uniqueResult();
    }

    @Override
    public Boolean isGroupPresentByName(String groupName) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Group.class);
        criteria.add(Restrictions.eq("name", groupName));
        return criteria.list().size() > 0;
    }

    @Override
    public Long getTotalRows() {
        return (Long) hibernateTemplate.getSessionFactory().getCurrentSession().
                getNamedQuery("Group.findAllGroupsCount").
                uniqueResult();
    }

    @Override
    public Long getTotalRowsByName(String groupName) {
        return (Long) hibernateTemplate.getSessionFactory().getCurrentSession().
                getNamedQuery("Group.findAllGroupsCountByName").
                setString("groupName", getLikePattern(groupName)).
                uniqueResult();
    }

    @Override
    public Long getTotalRowsByTemplateId(Long id) {
        return (Long) hibernateTemplate.getSessionFactory().getCurrentSession().
                getNamedQuery("Attribute.findAllAttributesCountById").
                setLong("id", id).
                uniqueResult();
    }
}

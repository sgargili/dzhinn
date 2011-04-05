package imf.core.dao.impl;

import imf.core.dao.SubsGroupDao;
import imf.core.entity.SubsGroup;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Developed by: Andrey Popov
 * Date (time): 14.02.11 (16:25)
 */
@Repository("subsGroupDao")
public class SubsGroupDaoImpl implements SubsGroupDao {
    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public SubsGroup saveSubsGroup(SubsGroup subsGroup) {
        subsGroup.setId((Long) hibernateTemplate.save(subsGroup));
        return subsGroup;
    }

    @Override
    public void saveOrUpdateSubsGroup(SubsGroup subsGroup) {
        hibernateTemplate.saveOrUpdate(subsGroup);
    }

    @Override
    public void updateSubsGroup(SubsGroup subsGroup) {
        hibernateTemplate.update(subsGroup);
    }

    @Override
    public void deleteSubsGroup(SubsGroup subsGroup) {
        hibernateTemplate.delete(subsGroup);
    }

    @Override
    public List<SubsGroup> getAllSubsGroups() {
        return hibernateTemplate.loadAll(SubsGroup.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<SubsGroup> getSubsGroups(int firstResult) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(SubsGroup.class);
        criteria.setFirstResult(firstResult);
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<SubsGroup> getSubsGroups(int firstResult, int maxResult) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(SubsGroup.class);
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResult);
        return criteria.list();
    }

    @Override
    public SubsGroup getSubsGroupById(Long id) {
        return hibernateTemplate.get(SubsGroup.class, id);
    }

    @Override
    public SubsGroup getSubsGroupWithSubstitutesById(Long id) {
        //HQL версия для одного запроса...
        String request = "from SubsGroup sg join fetch sg.substitutes as substitute where sg.id = :id";
        return (SubsGroup) hibernateTemplate.findByNamedParam(request, "id", id).get(0);

        //Транзакционная версия с 2-мя запросами...
//        SubsGroup group = hibernateTemplate.get(SubsGroup.class, id);
//        return group;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Long getTotalRowsCount() {
        return ((List<Long>) hibernateTemplate.findByNamedQuery("SubsGroup.findAllSubsGroupsCount")).get(0);
    }
}

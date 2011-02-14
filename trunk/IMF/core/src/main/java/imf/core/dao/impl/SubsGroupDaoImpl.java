package imf.core.dao.impl;

import imf.core.dao.SubsGroupDao;
import imf.core.entity.SubsGroup;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Developed by: Andrey Popov
 * Date (time): 14.02.11 (16:25)
 */
@Repository
@Service("subsGroupDao")
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
    public List<SubsGroup> getSubsGroups(final int firstResult) {
        final String request = "from SubsGroup";
        return (List<SubsGroup>) hibernateTemplate.execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(request);
                query.setFirstResult(firstResult);
                return query.list();
            }
        });
    }

    @Override
    public List<SubsGroup> getSubsGroups(final int firstResult, final int maxResult) {
        final String request = "from SubsGroup";
        return (List<SubsGroup>) hibernateTemplate.execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(request);
                query.setFirstResult(firstResult);
                query.setMaxResults(maxResult);
                return query.list();
            }
        });
    }

    @Override
    public SubsGroup getSubsGroupById(Long id) {
        return hibernateTemplate.get(SubsGroup.class, id);
    }

    @Override
//    @Transactional(readOnly = true)
    public SubsGroup getSubsGroupWithSubstitutesById(Long id) {
        //HQL версия для одного запроса...
//        String request = "from SubsGroup sg join fetch sg.substitutes as substitute where sg.id = :id";
//        return (SubsGroup) hibernateTemplate.findByNamedParam(request, "id", id).get(0);

        //Транзакционная версия с 2-мя запросами...
        SubsGroup group = hibernateTemplate.get(SubsGroup.class, id);
//        System.out.println(group.getSubstitutes().size());
        return group;
    }

    @Override
    public Long getTotalRowsCount() {
        return ((List<Long>) hibernateTemplate.findByNamedQuery("SubsGroup.findAllSubsGroupsCount")).get(0);
    }
}

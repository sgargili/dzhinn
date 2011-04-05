package imf.core.dao.impl;

import java.util.List;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import imf.core.dao.UnitsGroupDao;
import imf.core.entity.UnitsGroup;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 17.11.2010
 * Time: 15:55:25
 * To change this template use File | Settings | File Templates.
 */
@Repository("unitsGroupDao")
public class UnitsGroupDaoImpl implements UnitsGroupDao {
    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public UnitsGroup saveUnitsGroup(UnitsGroup unitsGroup) {
        unitsGroup.setId((Long) hibernateTemplate.save(unitsGroup));
        return unitsGroup;
    }

    @Override
    public void saveOrUpdateUnitsGroup(UnitsGroup unitsGroup) {
        hibernateTemplate.saveOrUpdate(unitsGroup);
    }

    @Override
    public void updateUnitsGroup(UnitsGroup unitsGroup) {
        hibernateTemplate.update(unitsGroup);
    }

    @Override
    public void deleteUnitsGroup(UnitsGroup unitsGroup) {
        hibernateTemplate.delete(unitsGroup);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deleteUnitsGroupById(final Long id) {
        final String request = "delete from UnitsGroup ug where ug.id = :id";
        hibernateTemplate.execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(request);
                query.setLong("id", id);
                return query.executeUpdate();
            }
        });
    }

    @Override
    public List<UnitsGroup> getAllUnitsGroups() {
        return hibernateTemplate.loadAll(UnitsGroup.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UnitsGroup> getUnitsGroups(final int firstResult) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(UnitsGroup.class);
        criteria.setFirstResult(firstResult);
        return criteria.list();

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UnitsGroup> getUnitsGroups(final int firstResult, final int maxResult) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(UnitsGroup.class);
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResult);
        return criteria.list();
    }

    @Override
    public UnitsGroup getUnitsGroupById(Long id) {
        return hibernateTemplate.get(UnitsGroup.class, id);
    }

    @Override
    public UnitsGroup getUnitsGroupWithUnitsById(Long id) {
        String request = "from UnitsGroup ug join fetch ug.unitOfMeasures as unit where ug.id = :id";
        return (UnitsGroup) hibernateTemplate.findByNamedParam(request, "id", id).get(0);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Long getTotalRowsCount() {
        return ((List<Long>) hibernateTemplate.findByNamedQuery("UnitsGroup.findAllUnitsGroupsCount")).get(0);
    }
}

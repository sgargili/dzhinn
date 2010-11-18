package imf.core.dao.impl;

import imf.core.dao.UnitGroupDao;
import imf.core.entity.UnitGroup;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 17.11.2010
 * Time: 15:55:25
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Service("unitGroupDao")
public class UnitGroupDaoImpl implements UnitGroupDao {
    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public UnitGroup saveUnitGroup(UnitGroup unitGroup) {
        unitGroup.setId((Long) hibernateTemplate.save(unitGroup));
        return unitGroup;
    }

    @Override
    public void saveOrUpdateUnitGroup(UnitGroup unitGroup) {
        hibernateTemplate.saveOrUpdate(unitGroup);
    }

    @Override
    public void updateUnitGroup(UnitGroup unitGroup) {
        hibernateTemplate.update(unitGroup);
    }

    @Override
    public void deleteUnitGroup(UnitGroup unitGroup) {
        hibernateTemplate.delete(unitGroup);
    }

    @Override
    public void deleteUnitGroupById(final Long id) {
        final String request = "delete from UnitGroup ug where ug.id = :id";
        hibernateTemplate.execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(request);
                query.setLong("id", id);
                return query.executeUpdate();
            }
        });
    }

    @Override
    public List<UnitGroup> getAllUnitGroups() {
        return hibernateTemplate.loadAll(UnitGroup.class);
    }

    @Override
    public List<UnitGroup> getUnitGroups(int firstResult) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(UnitGroup.class);
        criteria.setFirstResult(firstResult);
        return criteria.list();

    }

    @Override
    public List<UnitGroup> getUnitGroups(final int firstResult, final int maxResult) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(UnitGroup.class);
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResult);
        return criteria.list();
    }

    @Override
    public UnitGroup getUnitGroupById(Long id) {
        return hibernateTemplate.get(UnitGroup.class, id);
    }
}

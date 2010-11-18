package imf.core.dao.impl;

import imf.core.dao.UnitOfMeasureDao;
import imf.core.entity.UnitGroup;
import imf.core.entity.UnitOfMeasure;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;

/**
 * User: Andrey Popov
 * Date: 18.11.2010
 * Time: 11:12:42
 */
public class UnitOfMeasureDaoImpl implements UnitOfMeasureDao {

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public UnitOfMeasure saveUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        unitOfMeasure.setId((Long) hibernateTemplate.save(unitOfMeasure));
        return null;
    }

    @Override
    public void saveOrUpdateUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        hibernateTemplate.saveOrUpdate(unitOfMeasure);
    }

    @Override
    public void updateUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        hibernateTemplate.update(unitOfMeasure);
    }

    @Override
    public void deleteUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        hibernateTemplate.delete(unitOfMeasure);
    }

    @Override
    public void deleteUnitOfMeasureById(final Long id) {
        final String request = "delete from UnitOfMeasure um where um.id = :id";
        hibernateTemplate.execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(request);
                query.setLong("id", id);
                return query.executeUpdate();
            }
        });
    }

    @Override
    public List<UnitOfMeasure> getAllUnitOfMeasures() {
        return hibernateTemplate.loadAll(UnitOfMeasure.class);
    }

    @Override
    public List<UnitOfMeasure> getUnitOfMeasures(int firstResult) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(UnitOfMeasure.class);
        criteria.setFirstResult(firstResult);
        return criteria.list();
    }

    @Override
    public List<UnitOfMeasure> getUnitOfMeasures(int firstResult, int maxResult) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(UnitOfMeasure.class);
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResult);
        return criteria.list();
    }

    @Override
    public UnitOfMeasure getUnitOfMeasureById(Long id) {
        return hibernateTemplate.get(UnitOfMeasure.class, id);
    }
}

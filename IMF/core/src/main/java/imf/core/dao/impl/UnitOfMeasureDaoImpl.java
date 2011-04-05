package imf.core.dao.impl;

import java.util.List;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import imf.core.dao.UnitOfMeasureDao;
import imf.core.entity.UnitOfMeasure;
import imf.core.entity.UnitsGroup;

/**
 * User: Andrey Popov
 * Date: 18.11.2010
 * Time: 11:12:42
 */
@Repository("unitOfMeasureDao")
public class UnitOfMeasureDaoImpl implements UnitOfMeasureDao {

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public UnitOfMeasure saveUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        unitOfMeasure.setId((Long) hibernateTemplate.save(unitOfMeasure));
        return unitOfMeasure;
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
    @SuppressWarnings("unchecked")
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
    @SuppressWarnings("unchecked")
    public List<UnitOfMeasure> getUnitOfMeasures(int firstResult) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(UnitOfMeasure.class);
        criteria.setFirstResult(firstResult);
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UnitOfMeasure> getUnitOfMeasures(int firstResult, int maxResult) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(UnitOfMeasure.class);
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResult);
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UnitOfMeasure> getUnitOfMeasuresByUnitsGroup(UnitsGroup ug) {
        String request = "from UnitOfMeasure um where um.unitsGroup = :ug";
        return (List<UnitOfMeasure>) hibernateTemplate.findByNamedParam(request, "ug", ug);
    }

    @Override
    public UnitOfMeasure getUnitOfMeasureById(Long id) {
        return hibernateTemplate.get(UnitOfMeasure.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Long getTotalRows() {
        return ((List<Long>) hibernateTemplate.findByNamedQuery("UnitOfMeasure.findAllUnitsOfMeasureCount")).get(0);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Long getTotalRowsByGroupId(Long id) {
        return ((List<Long>) hibernateTemplate.findByNamedQueryAndNamedParam("UnitOfMeasure.findAllUnitsOfMeasureCountById", "id", id)).get(0);
    }
}

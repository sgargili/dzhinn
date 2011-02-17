package imf.core.dao.impl;

import imf.core.dao.SubstituteDao;
import imf.core.entity.SubsGroup;
import imf.core.entity.Substitute;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Developed by: Andrey Popov
 * Date (time): 17.02.11 (10:46)
 */
@Repository
@Service("substituteDao")
public class SubstituteDaoImpl implements SubstituteDao {
    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public Substitute saveSubstitute(Substitute substitute) {
        substitute.setId((Long) hibernateTemplate.save(substitute));
        return substitute;
    }

    @Override
    public void saveOrUpdateSubstitute(Substitute substitute) {
        hibernateTemplate.saveOrUpdate(substitute);
    }

    @Override
    public void updateSubstitute(Substitute substitute) {
        hibernateTemplate.update(substitute);
    }

    @Override
    public void deleteSubstitute(Substitute substitute) {
        hibernateTemplate.delete(substitute);
    }

    @Override
    public void deleteSubstituteById(Long id) {
        String deleteQuery = "delete from Substitute sub where sub.id = :id";
        Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(deleteQuery);
        query.setLong("id", id);
        query.executeUpdate();
    }

    @Override
    public List<Substitute> getAllSubstitutes() {
        return hibernateTemplate.loadAll(Substitute.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public List<Substitute> getSubstitutes(int firstResult) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Substitute.class);
        criteria.setFirstResult(firstResult);
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Substitute> getSubstitutes(int firstResult, int maxResult) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Substitute.class);
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResult);
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public List<Substitute> getSubstitutesBySubsGroup(SubsGroup subsGroup) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Substitute.class);
        //TODO Переделать бы, а то не очень абстрактно все это...
        criteria.add(Restrictions.eq("subsGroup", subsGroup));
        return criteria.list();
    }

    @Override
    public Substitute getSubstituteById(Long id) {
        return hibernateTemplate.get(Substitute.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Long getTotalRows() {
        return ((List<Long>) hibernateTemplate.findByNamedQuery("Substitute.findAllSubstitutesCount")).get(0);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Long getTotalRowsByGroupId(Long id) {
        return ((List<Long>) hibernateTemplate.findByNamedQueryAndNamedParam("Substitute.findAllSubstitutesCountById", "id", id)).get(0);
    }
}

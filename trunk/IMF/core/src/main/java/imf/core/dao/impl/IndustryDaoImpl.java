package imf.core.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import imf.core.dao.IndustryDao;
import imf.core.entity.Industry;

/**
 * Developed by: Andrey Popov
 * Date (time): 15.03.11 (16:13)
 */
@Repository("industryDao")
public class IndustryDaoImpl implements IndustryDao {

    private Logger log = LoggerFactory.getLogger(IndustryDaoImpl.class);

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public Industry saveIndustry(Industry industry) {
        industry.setId((Long) hibernateTemplate.save(industry));
        return industry;
    }

    @Override
    public void saveOrUpdateIndustry(Industry industry) {
        hibernateTemplate.saveOrUpdate(industry);
    }

    @Override
    public void updateIndustry(Industry industry) {
        hibernateTemplate.update(industry);
    }

    @Override
    public void deleteIndustry(Industry industry) {
        hibernateTemplate.delete(industry);
    }

    @Override
    public List<Industry> getAllIndustries() {
        return hibernateTemplate.loadAll(Industry.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Industry> getIndustries(Integer firstResult) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Industry.class);
        criteria.setFirstResult(firstResult);
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Industry> getIndustries(Integer firstResult, Integer maxResult) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Industry.class);
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResult);
        return criteria.list();
    }

    @Override
    public Boolean isIndustryPresentByName(String industryName) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Industry.class);
        criteria.add(Restrictions.eq("name", industryName));
        return criteria.list().size() > 0;
    }

    @Override
    public Industry getIndustryById(Long id) {
        return hibernateTemplate.get(Industry.class, id);
    }

    @Override
    public Long getAllIndustriesCount() {
        return (Long) hibernateTemplate.getSessionFactory().getCurrentSession().
                getNamedQuery("Industry.findAllIndustriesCount").
                uniqueResult();
    }
}

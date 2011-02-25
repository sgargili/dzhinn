package hbt.dao.impl;

import java.util.List;

import hbt.dao.TemplateDao;
import hbt.model.Template;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Developed by: Andrey Popov
 * Date (time): 25.02.11 (11:45)
 */
@Repository
@Service("templateDao")
public class TemplateDaoImpl implements TemplateDao {
    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
    @Transactional
    public Template getTemplateById(Long id) {
        Template template;
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Template.class);
        criteria.add(Restrictions.eq("id", id));
        criteria.setFetchMode("groups", FetchMode.JOIN);
//        criteria.createAlias("groups", "group");
        criteria.setFetchMode("groups.attributes", FetchMode.JOIN);
        //        criteria.setFetchMode("group.attributes", FetchMode.JOIN);
        template =  (Template) criteria.uniqueResult();
        return template;
    }
}
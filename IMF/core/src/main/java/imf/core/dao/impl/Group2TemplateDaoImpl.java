package imf.core.dao.impl;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import imf.core.dao.Group2TemplateDao;
import imf.core.entity.Group2Template;

/**
 * Developed by: Andrey Popov
 * Date (time): 11.03.11 (16:08)
 */
@Repository("group2TemplateDao")
public class Group2TemplateDaoImpl implements Group2TemplateDao {
    private Logger log = LoggerFactory.getLogger(Group2TemplateDaoImpl.class);

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public void addGroup2Template(Group2Template group2Template) {
        hibernateTemplate.save(group2Template);
    }

    @Override
    public void updateGroup2Template(Group2Template group2Template) {
        hibernateTemplate.update(group2Template);
    }

    @Override
    public void deleteGroup2Template(Group2Template group2Template) {
        hibernateTemplate.delete(group2Template);
    }
}

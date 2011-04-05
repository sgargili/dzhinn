package imf.core.dao.impl;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import imf.core.dao.Attribute2Group2TemplateDao;
import imf.core.entity.Attribute2Group2Template;

/**
 * Developed by: Andrey Popov
 * Date (time): 11.03.11 (16:27)
 */

@Repository("attribute2Group2TemplateDao")
public class Attribute2Group2TemplateDaoImpl implements Attribute2Group2TemplateDao {
    private Logger log = LoggerFactory.getLogger(Attribute2Group2TemplateDaoImpl.class);

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public void addAttribute2Group2Template(Attribute2Group2Template attribute2Group2Template) {
        hibernateTemplate.save(attribute2Group2Template);
    }

    @Override
    public void updateAttribute2Group2Template(Attribute2Group2Template attribute2Group2Template) {
        hibernateTemplate.update(attribute2Group2Template);
    }

    @Override
    public void deleteAttribute2Group2Template(Attribute2Group2Template attribute2Group2Template) {
        hibernateTemplate.delete(attribute2Group2Template);
    }
}

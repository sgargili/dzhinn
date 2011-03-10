package imf.core.dao.impl;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import imf.core.dao.Attribute2GroupDao;
import imf.core.entity.Attribute2Group;

/**
 * Developed by: Andrey Popov
 * Date (time): 10.03.11 (17:53)
 */
@Repository
@Service("attribute2GroupDao")
public class Attribute2GroupDaoImpl implements Attribute2GroupDao {

    private Logger log = LoggerFactory.getLogger(Attribute2GroupDaoImpl.class);

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public void addAttribute2Group(Attribute2Group attribute2Group) {
        hibernateTemplate.save(attribute2Group);
    }

    @Override
    public void updateAttribute2Group(Attribute2Group attribute2Group) {
        hibernateTemplate.update(attribute2Group);
    }

    @Override
    public void deleteAttribute2Group(Attribute2Group attribute2Group) {
        hibernateTemplate.delete(attribute2Group);
    }
}

package mvc.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import mvc.dao.LinkDao;
import mvc.model.Data;
import mvc.model.Link;

import java.util.List;

/**
 * User: Andrey Popov
 * Date: 15.12.10
 * Time: 13:00
 */
@Repository
@Service("linkDao")
public class LinkDaoImpl implements LinkDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public List<Link> getAllLinks() {
        return (List<Link>) hibernateTemplate.find("from Link");
    }

    public List<Link> getLinksByType(String type) {
        return (List<Link>) hibernateTemplate.findByNamedParam("from Link link where link.type = :type", "type", type);
    }

    public List<Link> getLinksByUrl(String url) {
        return (List<Link>) hibernateTemplate.findByNamedParam("from Link link where link.url like :url", "url", url);
    }
}

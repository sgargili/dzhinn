package ira.dao.impl;

import ira.dao.LinkDao;
import ira.entity.Link;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: PAV
 * Date: 27.10.2010
 * Time: 23:42:37
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Service("linkDao")
public class LinkDaoImpl implements LinkDao {

    private HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public void saveLink(Link link) {
        hibernateTemplate.save(link);
    }

    @Override
    public void saveOrUpdate(Link link) {
        hibernateTemplate.saveOrUpdate(link);
    }

    @Override
    public void deleteLink(Long id) {
        Link link = new Link(id);
        hibernateTemplate.delete(link);
    }

    @Override
    public void updateLink(Link link) {
        hibernateTemplate.update(link);
    }

    @Override
    public Link getLinkById(Long id) {
        return hibernateTemplate.get(Link.class, id);
    }

    @Override
    public List<Link> getAllLink() {
        return hibernateTemplate.loadAll(Link.class);
    }

    @Override
    public List<Link> getAllLink(int start) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Link.class);
        criteria.setFirstResult(start);
        return (List<Link>) criteria.list();
    }

    @Override
    public List<Link> getAllLink(int start, int limit) {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Link.class);
        criteria.setFirstResult(start);
        criteria.setMaxResults(limit);
        return (List<Link>) criteria.list();
    }

    @Override
    public List<Link> getLinkByType(String type) {
        return (List<Link>) hibernateTemplate.findByNamedParam("from Link link where link.type = :type", "type", type);
    }

    @Override
    public List<Link> getLinkByUrl(String url) {
        return (List<Link>) hibernateTemplate.findByNamedParam("from Link link where link.url = :url", "url", url);
    }
}

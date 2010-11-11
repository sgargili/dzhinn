package dao.impl;

import dao.ProcessDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pojo.Process;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 11.11.2010
 * Time: 12:14:32
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Service("processDao")
public class ProcessDaoImpl implements ProcessDao {

    private HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public void saveProcess(Process process) {
        hibernateTemplate.save(process);
    }

    @Override
    public void updateProcess(Process process) {
        hibernateTemplate.update(process);
    }

    @Override
    public void updateProcessStatusById(final String status, final int id) {
        final String request = "update process p set p.status = :status where p.id = :id";
        hibernateTemplate.execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createSQLQuery(request);
                query.setString("status", status);
                query.setInteger("id", id);
                return query.executeUpdate();
            }
        });
    }

    @Override
    public Process getProcessById(int id) {
        return hibernateTemplate.get(Process.class, id);
    }

    @Override
    public String getProcessStatusById(int id) {
        return hibernateTemplate.get(Process.class, id).getStatus();
    }
}

package ira.dao;

import ira.entity.Link;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: PAV
 * Date: 27.10.2010
 * Time: 23:36:53
 * To change this template use File | Settings | File Templates.
 */
public interface LinkDao {
    void saveLink(Link link);

    void saveOrUpdate(Link link);

    void deleteLink(Long id);

    void updateLink(Link link);

    Link getLinkById(Long id);

    List<Link> getAllLink();

    List<Link> getAllLink(int start);

    List<Link> getAllLink(int start, int limit);

    List<Link> getLinkByType(String type);

    List<Link> getLinkByUrl(String url);
}

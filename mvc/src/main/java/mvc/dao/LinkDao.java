package mvc.dao;

import mvc.model.Link;

import java.util.List;

/**
 * User: Andrey Popov
 * Date: 15.12.10
 * Time: 12:58
 */
public interface LinkDao {
    List<Link> getAllLinks();

    List<Link> getLinksByType(String type);

    List<Link> getLinksByUrl(String url);
}

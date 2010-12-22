package mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import mvc.dao.LinkDao;
import mvc.dto.LinkRequest;
import mvc.dto.LinkResponce;
import mvc.service.LinkService;

/**
 * User: Andrey Popov
 * Date: 15.12.10
 * Time: 13:13
 */
@Repository
@Service("linkService")
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkDao linkDao;

    private LinkResponce linkResponce = new LinkResponce();

    public LinkResponce getLinkResponce(LinkRequest linkRequest) {
        if (linkRequest.getRequestType() == 0) {
            linkResponce.setLinks(linkDao.getLinksByType(linkRequest.getType()));
        } else if (linkRequest.getRequestType() == 1) {
            linkResponce.setLinks(linkDao.getLinksByUrl(linkRequest.getUrl()));
        }
        return linkResponce;
    }
}

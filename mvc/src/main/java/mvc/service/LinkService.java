package mvc.service;

import mvc.dto.LinkRequest;
import mvc.dto.LinkResponce;

/**
 * User: Andrey Popov
 * Date: 15.12.10
 * Time: 13:05
 */
public interface LinkService {
    LinkResponce getLinkResponce(LinkRequest linkRequest);
}

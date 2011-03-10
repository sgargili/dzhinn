package imf.core.service;

import imf.core.dto.web.request.GroupRequest;

/**
 * Developed by: Andrey Popov
 * Date (time): 10.03.11 (17:56)
 */

public interface Attribute2GroupService {
    void addAttribute2Group(GroupRequest groupRequest);

    void updateAttribute2Group(GroupRequest groupRequest);

    void deleteAttribute2Group(GroupRequest groupRequest);
}

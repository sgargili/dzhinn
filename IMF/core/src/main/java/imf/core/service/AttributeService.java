package imf.core.service;

import imf.core.dto.web.response.AttributeResponse;

/**
 * Developed by: Andrey Popov
 * Date (time): 21.02.11 (12:49)
 */

public interface AttributeService {
    AttributeResponse getAttributesByGroupId(Long groupId);

    AttributeResponse getAttributesByGroupId(Long groupId, Integer firstResult);

    AttributeResponse getAttributesByGroupId(Long groupId, Integer firstResult, Integer maxResult);
}

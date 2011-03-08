package imf.core.service;

import imf.core.dto.web.request.AttributeRequest;
import imf.core.dto.web.response.AttributeResponse;
import imf.core.entity.Attribute;

/**
 * Developed by: Andrey Popov
 * Date (time): 21.02.11 (12:49)
 */

public interface AttributeService {

    Attribute addAttribute(AttributeRequest attributeRequest);

    Boolean isAttributePresentByName(String attributeName);

    AttributeResponse getAttributesByName(String attributeName);

    AttributeResponse getAttributesByName(String attributeName, Integer firstResult);

    AttributeResponse getAttributesByName(String attributeName, Integer firstResult, Integer maxResult);

    AttributeResponse getAttributesByGroupId(Long groupId);

    AttributeResponse getAttributesByGroupId(Long groupId, Integer firstResult);

    AttributeResponse getAttributesByGroupId(Long groupId, Integer firstResult, Integer maxResult);
}

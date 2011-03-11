package imf.core.dto.web.request;

import java.util.ArrayList;
import java.util.List;

/**
 * Developed by: Andrey Popov
 * Date (time): 10.03.11 (13:09)
 */

public class GroupRequest extends BaseRequest {
    private Integer weight;
    private List<AttributeRequest> attributeRequests = new ArrayList<AttributeRequest>();

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public List<AttributeRequest> getAttributeRequests() {
        return attributeRequests;
    }

    public void setAttributeRequests(List<AttributeRequest> attributeRequests) {
        this.attributeRequests = attributeRequests;
    }

    public void addAttributeRequests(AttributeRequest attributeRequest) {
        this.attributeRequests.add(attributeRequest);
    }


}

package imf.core.dto.web.request;

import java.util.ArrayList;
import java.util.List;

/**
 * Developed by: Andrey Popov
 * Date (time): 11.03.11 (16:30)
 */

public class TemplateRequest extends BaseRequest {
    private List<GroupRequest> groupRequests = new ArrayList<GroupRequest>();

    public List<GroupRequest> getGroupRequests() {
        return groupRequests;
    }

    public void setGroupRequests(List<GroupRequest> groupRequests) {
        this.groupRequests = groupRequests;
    }

    public void addGroupRequest(GroupRequest groupRequests) {
        this.groupRequests.add(groupRequests);
    }
}

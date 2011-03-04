package imf.core.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Developed by: Andrey Popov
 * Date (time): 04.03.11 (16:30)
 */


@Embeddable
public class Group2TemplateId implements java.io.Serializable {

    private long groupId;
    private long templateId;

    public Group2TemplateId() {
    }

    @Column(name = "group_id", nullable = false)
    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    @Column(name = "template_id", nullable = false)
    public long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(long templateId) {
        this.templateId = templateId;
    }
}




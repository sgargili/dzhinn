package imf.core.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Developed by: Andrey Popov
 * Date (time): 11.03.11 (16:18)
 */
@Embeddable
public class Attribute2Group2TemplateId implements java.io.Serializable {


    private long attributeId;
    private long groupId;
    private long templateId;

    public Attribute2Group2TemplateId() {
    }

    public Attribute2Group2TemplateId(long attributeId, long groupId) {
        this.attributeId = attributeId;
        this.groupId = groupId;
    }

    public Attribute2Group2TemplateId(long attributeId, long templateid, long groupId) {
        this.attributeId = attributeId;
        this.templateId = templateid;
        this.groupId = groupId;
    }

    @Column(name = "attribute_id", nullable = false)
    public long getAttributeId() {
        return this.attributeId;
    }

    public void setAttributeId(long attributeId) {
        this.attributeId = attributeId;
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

    public void setTemplateId(long templateid) {
        this.templateId = templateid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attribute2Group2TemplateId that = (Attribute2Group2TemplateId) o;

        if (attributeId != that.attributeId) return false;
        if (groupId != that.groupId) return false;
        if (templateId != that.templateId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (attributeId ^ (attributeId >>> 32));
        result = 31 * result + (int) (groupId ^ (groupId >>> 32));
        result = 31 * result + (int) (templateId ^ (templateId >>> 32));
        return result;
    }
}



package imf.core.entity;

import javax.persistence.*;

/**
 * Developed by: Andrey Popov
 * Date (time): 11.03.11 (16:18)
 */
@Entity
@Table(name = "attribute_2_group_2_template", catalog = "imf")
public class Attribute2Group2Template {
    private Attribute2Group2TemplateId attribute2Group2TemplateId;
    private Boolean require;
    private Boolean composite;
    private String comment;

    public Attribute2Group2Template() {
    }

    public Attribute2Group2Template(Attribute2Group2TemplateId attribute2Group2TemplateId) {
        this.attribute2Group2TemplateId = attribute2Group2TemplateId;
    }

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "attributeId", column = @Column(name = "attribute_id", nullable = false)),
            @AttributeOverride(name = "groupId", column = @Column(name = "group_id", nullable = false)),
            @AttributeOverride(name = "templateId", column = @Column(name = "template_id", nullable = false))
    })
    public Attribute2Group2TemplateId getAttribute2Group2TemplateId() {
        return attribute2Group2TemplateId;
    }

    public void setAttribute2Group2TemplateId(Attribute2Group2TemplateId attribute2Group2TemplateId) {
        this.attribute2Group2TemplateId = attribute2Group2TemplateId;
    }

    @Column(name = "required", nullable = false)
    public Boolean getRequire() {
        return require;
    }

    public void setRequire(Boolean require) {
        this.require = require;
    }

    @Column(name = "composite", nullable = false)
    public Boolean getComposite() {
        return composite;
    }

    public void setComposite(Boolean composite) {
        this.composite = composite;
    }

    @Column(name = "comment", length = 1024)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

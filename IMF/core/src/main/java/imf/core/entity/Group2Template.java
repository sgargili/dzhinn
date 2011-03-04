package imf.core.entity;

import javax.persistence.*;

/**
 * Developed by: Andrey Popov
 * Date (time): 04.03.11 (16:32)
 */

@Entity
@Table(name = "group_2_template", catalog = "imf")
public class Group2Template {

    private Group2TemplateId id;
    private Integer weight;
    private String comment;

    public Group2Template() {
    }


    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "groupId", column = @Column(name = "group_id", nullable = false)),
            @AttributeOverride(name = "templateId", column = @Column(name = "template_id", nullable = false))
    })
    public Group2TemplateId getId() {
        return id;
    }

    public void setId(Group2TemplateId id) {
        this.id = id;
    }

    @Column(name = "weight", nullable = false)
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Column(name = "comment", length = 1024)
    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

package hbt.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "`group`")
public class Group implements java.io.Serializable {


    private Long id;
    private String name;
    private String comment;
    //    private List<Attribute2Group> attribute2Groups;
    private Set<Attribute> attributes;

    private List<Template> templates = new ArrayList(0);

    public Group() {
    }

    public Group(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 512)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "comment", length = 1024)
    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    //    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "group")
//    public List<Attribute2Group> getAttribute2Groups() {
//        return this.attribute2Groups;
//    }
//
//    public void setAttribute2Groups(List<Attribute2Group> attribute2Groups) {
//        this.attribute2Groups = attribute2Groups;
//    }
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "attribute_2_group", joinColumns = {
            @JoinColumn(name = "group_id", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "attribute_id", nullable = false, updatable = false)})
    public Set<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<Attribute> attributes) {
        this.attributes = attributes;
    }


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "group_2_template", joinColumns = {
            @JoinColumn(name = "group_id", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "template_id", nullable = false, updatable = false)
    })
    public List<Template> getTemplates() {
        return this.templates;
    }

    public void setTemplates(List<Template> templates) {
        this.templates = templates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (id != null ? !id.equals(group.id) : group.id != null) return false;
        if (name != null ? !name.equals(group.name) : group.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}



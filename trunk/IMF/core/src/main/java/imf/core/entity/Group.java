package imf.core.entity;


import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "group", catalog = "imf")
public class Group implements java.io.Serializable {


    private Long id;
    private String name;
    private String comment;
    private Set<Template> templates;
    private Set<Attribute> attributes;

    //Transient fields....
    private Integer weight;
    private String comment4Group;

    public Group() {
    }


    public Group(String name) {
        this.name = name;
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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "group_2_template", catalog = "imf", joinColumns = {
            @JoinColumn(name = "group_id", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "template_id", nullable = false, updatable = false)})
    public Set<Template> getTemplates() {
        return this.templates;
    }

    public void setTemplates(Set<Template> templates) {
        this.templates = templates;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "attribute_2_group", catalog = "imf", joinColumns = {
            @JoinColumn(name = "group_id", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "attribute_id", nullable = false, updatable = false)})
    public Set<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<Attribute> attributes) {
        this.attributes = attributes;
    }

    @Transient
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Transient
    public String getComment4Group() {
        return comment4Group;
    }

    public void setComment4Group(String comment4Group) {
        this.comment4Group = comment4Group;
    }
}



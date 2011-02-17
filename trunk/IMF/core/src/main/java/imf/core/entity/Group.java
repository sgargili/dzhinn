package imf.core.entity;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "group", catalog = "imf")
public class Group implements java.io.Serializable {


    private Long id;
    private String name;
    private String comment;
    private List<Template> templates = new ArrayList(0);
    private List<Attribute2Group> attribute2Groups = new ArrayList(0);

    public Group() {
    }


    public Group(String name) {
        this.name = name;
    }

    public Group(String name, String comment, List<Template> templates, List<Attribute2Group> attribute2Groups) {
        this.name = name;
        this.comment = comment;
        this.templates = templates;
        this.attribute2Groups = attribute2Groups;
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
    public List<Template> getTemplates() {
        return this.templates;
    }

    public void setTemplates(List<Template> templates) {
        this.templates = templates;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "group")
    public List<Attribute2Group> getAttribute2Groups() {
        return this.attribute2Groups;
    }

    public void setAttribute2Groups(List<Attribute2Group> attribute2Groups) {
        this.attribute2Groups = attribute2Groups;
    }


}



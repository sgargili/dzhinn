package imf.core.entity;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
@Table(name = "template", catalog = "imf")
public class Template implements java.io.Serializable {


    private Long id;
    private String name;
    private String comment;
    private List<Group> groups = new ArrayList(0);
//    private Set bisinessModels = new HashSet(0);

    public Template() {
    }


    public Template(String name) {
        this.name = name;
    }

//    public Template(String name, String comment, Set groups, Set bisinessModels) {
//        this.name = name;
//        this.comment = comment;
//        this.groups = groups;
//        this.bisinessModels = bisinessModels;
//    }

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
            @JoinColumn(name = "template_id", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "group_id", nullable = false, updatable = false)})
    public List<Group> getGroups() {
        return this.groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "template")
//    public Set getBisinessModels() {
//        return this.bisinessModels;
//    }
//
//    public void setBisinessModels(Set bisinessModels) {
//        this.bisinessModels = bisinessModels;
//    }


}



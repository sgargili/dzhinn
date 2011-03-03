package imf.core.entity;


import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "template", catalog = "imf")
public class Template implements java.io.Serializable {


    private Long id;
    private String name;
    private String comment;
    private Set<Group> groups;
//    private Set bisinessModels = new HashSet(0);

    public Template() {
    }


    public Template(String name) {
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
            @JoinColumn(name = "template_id", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "group_id", nullable = false, updatable = false)})
    public Set<Group> getGroups() {
        return this.groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

}



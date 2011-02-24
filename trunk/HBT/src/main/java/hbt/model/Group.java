package hbt.model;

import java.util.List;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "`group`")
public class Group implements java.io.Serializable {


    private Long id;
    private String name;
    private String comment;
    private List<Attribute2Group> attribute2Groups;

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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "group")
    public List<Attribute2Group> getAttribute2Groups() {
        return this.attribute2Groups;
    }

    public void setAttribute2Groups(List<Attribute2Group> attribute2Groups) {
        this.attribute2Groups = attribute2Groups;
    }


}



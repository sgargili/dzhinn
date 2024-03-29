package imf.core.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "author", catalog = "imf")
public class Author implements java.io.Serializable {


    private Long id;
    private String name;
    private String comment;
    private Set articles = new HashSet(0);

    public Author() {
    }


    public Author(String name) {
        this.name = name;
    }

    public Author(String name, String comment, Set articles) {
        this.name = name;
        this.comment = comment;
        this.articles = articles;
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "author")
    public Set getArticles() {
        return this.articles;
    }

    public void setArticles(Set articles) {
        this.articles = articles;
    }


}



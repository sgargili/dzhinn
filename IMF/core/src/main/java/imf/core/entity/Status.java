package imf.core.entity;
// Generated 16.11.2010 22:43:01 by Hibernate Tools 3.2.1.GA


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

/**
 * Status generated by hbm2java
 */
@Entity
@Table(name = "status"
        , catalog = "imf"
)
public class Status implements java.io.Serializable {


    private Long id;
    private String name;
    private Set articles = new HashSet(0);

    public Status() {
    }


    public Status(String name) {
        this.name = name;
    }

    public Status(String name, Set articles) {
        this.name = name;
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

    @Column(name = "name", nullable = false, length = 16)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "status")
    public Set getArticles() {
        return this.articles;
    }

    public void setArticles(Set articles) {
        this.articles = articles;
    }


}



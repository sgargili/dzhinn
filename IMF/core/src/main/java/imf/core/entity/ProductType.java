package imf.core.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 */
@Entity
@Table(name = "product_type", schema = "imf")
public class ProductType implements java.io.Serializable {

    private long id;
    private String name;
    private String comment;
    private Set<Category> categories = new HashSet<Category>(0);

    public ProductType() {
    }

    public ProductType(long id) {
        this.id = id;
    }

    public ProductType(long id, String name, String comment, Set<Category> categories) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.categories = categories;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", length = 512)
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
    @JoinTable(name = "product_type_2_category", schema = "imf", joinColumns = {
        @JoinColumn(name = "product_type_id", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "category_id", nullable = false, updatable = false)})
    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}

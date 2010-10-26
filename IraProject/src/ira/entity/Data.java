package ira.entity;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: PAV
 * Date: 26.10.2010
 * Time: 22:46:21
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "data")
public class Data {
    public Data() {
    }

    public Data(Long id) {
        this.id = id;
    }

    private Long id;


    @javax.persistence.Column(name = "id", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String article;

    @javax.persistence.Column(name = "article", nullable = true, insertable = true, updatable = true, length = 512, precision = 0)
    @Basic
    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    private String attribute;

    @javax.persistence.Column(name = "attribute", nullable = true, insertable = true, updatable = true, length = 65535, precision = 0)
    @Basic
    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    private String value;

    @javax.persistence.Column(name = "value", nullable = true, insertable = true, updatable = true, length = 65535, precision = 0)
    @Basic
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Data data = (Data) o;

        if (article != null ? !article.equals(data.article) : data.article != null) return false;
        if (attribute != null ? !attribute.equals(data.attribute) : data.attribute != null) return false;
        if (id != null ? !id.equals(data.id) : data.id != null) return false;
        if (value != null ? !value.equals(data.value) : data.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (article != null ? article.hashCode() : 0);
        result = 31 * result + (attribute != null ? attribute.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}

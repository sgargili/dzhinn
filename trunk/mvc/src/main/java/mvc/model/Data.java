package mvc.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * User: Andrey Popov
 * Date: 14.12.10
 * Time: 16:15
 */
@Entity
public class Data {
    private Long id;

    @Column(name = "id")
    @Id
    public Long getId() {
        return id;
    }
    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
    }

    private String article;

    @Column(name = "article")
    @Basic
    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    private String attribute;

    @Column(name = "attribute")
    @Basic
    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    private String value;

    @Column(name = "value")
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

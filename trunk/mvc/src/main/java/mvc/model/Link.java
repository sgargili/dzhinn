package mvc.model;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * User: Andrey Popov
 * Date: 14.12.10
 * Time: 16:15
 */
@javax.persistence.Entity
public class Link {
    private Long id;

    @javax.persistence.Column(name = "id")
    @javax.persistence.Id
    public Long getId() {
        return id;
    }

    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
    }

    private String type;

    @javax.persistence.Column(name = "type")
    @javax.persistence.Basic
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String url;

    @javax.persistence.Column(name = "url")
    @javax.persistence.Basic
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (id != null ? !id.equals(link.id) : link.id != null) return false;
        if (type != null ? !type.equals(link.type) : link.type != null) return false;
        if (url != null ? !url.equals(link.url) : link.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}

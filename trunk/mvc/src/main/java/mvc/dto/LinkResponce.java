package mvc.dto;

import mvc.model.Link;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * User: Andrey Popov
 * Date: 15.12.10
 * Time: 13:06
 */
@XmlRootElement(name = "linkResponce", namespace = "http://www.persons.pav/link")
public class LinkResponce {
    private List<Link> links;

    public LinkResponce() {
    }

    public LinkResponce(List<Link> links) {
        this.links = links;
    }

    public List<Link> getLinks() {
        return links;
    }

    @XmlElement(name = "link")
    public void setLinks(List<Link> links) {
        this.links = links;
    }
}

package mvc.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: Andrey Popov
 * Date: 15.12.10
 * Time: 13:06
 */
@XmlRootElement(name = "linkRequest", namespace = "http://www.persons.pav/link")
public class LinkRequest {

    private int requestType;
    private String type;
    private String url;

    public LinkRequest() {
    }

    public LinkRequest(int requestType, String type, String url) {
        this.requestType = requestType;
        this.type = type;
        this.url = url;
    }

    public int getRequestType() {
        return requestType;
    }

    @XmlElement(namespace = "http://www.persons.pav/link")
    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

    public String getType() {
        return type;
    }

    @XmlElement(namespace = "http://www.persons.pav/link")
    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    @XmlElement(namespace = "http://www.persons.pav/link")
    public void setUrl(String url) {
        this.url = url;
    }
}

package sws.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

/**
 * User: Andrey Popov
 * Date: 14.12.10
 * Time: 16:36
 */

@XmlRootElement(name = "dataRequest", namespace = "http://www.persons.pav/data")
public class DataRequest {

    public static int ARTICLE_REQUEST_TYPE = 0;
    public static int ATTRIBUTE_REQUEST_TYPE = 1;

    //    @XmlElement(namespace = "http://www.persons.pav/data")
    private int requestType;
    //    @XmlElement(namespace = "http://www.persons.pav/data")
    private String article;
    //    @XmlElement(namespace = "http://www.persons.pav/data")
    private String attribute;

    public DataRequest() {
    }

    public DataRequest(int requestType, String article, String attribute) {
        this.requestType = requestType;
        this.article = article;
        this.attribute = attribute;
    }

    public int getRequestType() {
        return requestType;
    }

    @XmlElement(namespace = "http://www.persons.pav/data")
    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

    public String getArticle() {
        return article;
    }

    @XmlElement(namespace = "http://www.persons.pav/data")
    public void setArticle(String article) {
        this.article = article;
    }

    public String getAttribute() {
        return attribute;
    }

    @XmlElement(namespace = "http://www.persons.pav/data")
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}

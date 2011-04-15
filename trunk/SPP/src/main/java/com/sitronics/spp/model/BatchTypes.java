package com.sitronics.spp.model;

import java.util.List;

import javax.xml.bind.annotation.*;

import com.sitronics.spp.model.publicationrecords.Publication;
import com.sitronics.spp.model.type.Type;

/**
 * @author Andrey Popov creates on 14.04.11 (13:17)
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "BatchTypes")
public class BatchTypes {
    @XmlElementWrapper(name = "PublicationRecords")
    @XmlElement(name = "Publication")
    private List<Publication> publicationRecords;

    @XmlElement(name = "Type")
    private List<Type> types;
    @XmlElement(name = "Tag")
    private String tag;

    public BatchTypes() {
    }

    public List<Publication> getPublicationRecords() {
        return publicationRecords;
    }

    public void setPublicationRecords(List<Publication> publicationRecords) {
        this.publicationRecords = publicationRecords;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BatchTypes that = (BatchTypes) o;

        if (publicationRecords != null ? !publicationRecords.equals(that.publicationRecords) : that.publicationRecords != null)
            return false;
        if (tag != null ? !tag.equals(that.tag) : that.tag != null) return false;
        if (types != null ? !types.equals(that.types) : that.types != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = publicationRecords != null ? publicationRecords.hashCode() : 0;
        result = 31 * result + (types != null ? types.hashCode() : 0);
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        return result;
    }
}

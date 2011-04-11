package com.sitronics.spp.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Andrey Popov creates on 11.04.11 (15:26)
 */
@XmlRootElement(name = "Hello")
public class Pojo {
    private String id;
    private String name;

    public Pojo() {
    }

    public Pojo(String id) {
        this.id = id;
    }

    public Pojo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pojo pojo = (Pojo) o;

        if (id != null ? !id.equals(pojo.id) : pojo.id != null) return false;
        if (name != null ? !name.equals(pojo.name) : pojo.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

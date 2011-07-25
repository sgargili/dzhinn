package com.pav4it.imf;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * @author Andrey Popov creates on 20.07.11 (10:38)
 */
@Entity
@Table(name = "document")
public class Document extends BaseEntity {
//    @Column(name = "content")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] content;

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}

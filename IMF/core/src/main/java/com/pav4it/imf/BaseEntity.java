package com.pav4it.imf;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.sun.xml.internal.bind.CycleRecoverable;

/**
 * @author Andrey Popov creates on 19.07.11 (17:49)
 */
@MappedSuperclass
//Для XML сделаем уровень доступа - поле - для всех потомков...
@XmlAccessorType(XmlAccessType.FIELD)
//Реализуем интерфейс CycleRecoverable для того, чтобы Jaxb не говорил, что цикличность мешает серриализации...
public class BaseEntity implements CycleRecoverable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 512)
    private String name;

    @Column(name = "comment", nullable = false, length = 1024)
    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public Object onCycleDetected(Context context) {
        return null;
    }
}

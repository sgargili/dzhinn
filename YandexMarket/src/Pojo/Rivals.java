package Pojo;
// Generated 07.11.2009 18:22:22 by Hibernate Tools 3.2.1.GA

/**
 * Rivals generated by hbm2java
 */
public class Rivals implements java.io.Serializable {

    private Long id;
    private String name;

    public Rivals() {
    }

    public Rivals(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


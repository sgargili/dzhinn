package pojo;
// Generated 06.01.2010 13:28:43 by Hibernate Tools 3.2.1.GA

/**
 * Cookies generated by hbm2java
 */
public class Cookies implements java.io.Serializable {

    private Integer id;
    private String cookie;
    private Long time;

    public Cookies() {
    }

    public Cookies(String cookie, Long time) {
        this.cookie = cookie;
        this.time = time;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCookie() {
        return this.cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public Long getTime() {
        return this.time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}



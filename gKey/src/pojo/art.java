/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author APopov
 */
public class art {

    private String code, descr, sovp;

    public art() {
    }

    public art(String code, String descr, String sovp) {
        this.code = code;
        this.descr = descr;
        this.sovp = sovp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getSovp() {
        return sovp;
    }

    public void setSovp(String sovp) {
        this.sovp = sovp;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package processing.xstream;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PAV
 */
public class Article {
    private long id;
    private long classcat_id;
    private String code;
    private String status;
    private List image = new ArrayList();

    public List getImage() {
        return image;
    }

    public void setImage(List image) {
        this.image = image;
    }

    public long getClasscat_id() {
        return classcat_id;
    }

    public void setClasscat_id(long classcat_id) {
        this.classcat_id = classcat_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

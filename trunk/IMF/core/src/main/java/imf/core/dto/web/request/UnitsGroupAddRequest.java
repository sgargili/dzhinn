package imf.core.dto.web.request;

/**
 * Created by IntelliJ IDEA.
 * User: Администратор
 * Date: 30.01.11
 * Time: 16:57
 * To change this template use File | Settings | File Templates.
 */
public class UnitsGroupAddRequest {
    private Long id;
    private String name;
    private String comment;

    public UnitsGroupAddRequest() {
    }

    public UnitsGroupAddRequest(String name, String comment) {
        this.name = name;
        this.comment = comment;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

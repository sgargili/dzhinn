package imf.core.dto.web.request;

/**
 * User: Andrey Popov
 * Date: 30.01.11
 * Time: 16:57
 */

/**
 * Базовый класс описывающий объект запроса на добавление/обновление данных...
 */
public class BaseRequest {
    //Основа, которая находится в составе любой из сущностей данных...
    private Long id;
    private String name;
    private String comment;

    public BaseRequest() {
    }

    public BaseRequest(String name, String comment) {
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

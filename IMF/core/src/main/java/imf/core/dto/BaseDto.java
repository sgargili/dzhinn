package imf.core.dto;

/**
 * Developed by: Andrey Popov
 * Date (time): 15.02.11 (12:43)
 */


 /*Базовый класс Dto...*/
public class BaseDto {
    private Long id;
    private String name;
    private String comment;

    public BaseDto() {
    }

    public BaseDto(Long id, String name, String comment) {
        this.id = id;
        this.name = name;
        this.comment = comment;
    }

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
}

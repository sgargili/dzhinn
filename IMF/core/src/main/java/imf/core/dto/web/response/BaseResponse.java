package imf.core.dto.web.response;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Developed by: Andrey Popov
 * Date (time): 15.02.11 (12:21)
 */

//Доступ по-умолчанию на уравне полей...
@XmlAccessorType(XmlAccessType.FIELD)
public class BaseResponse {
    @XmlElement(nillable = false) //Если элемент null, то не отображать его...
    private Long totalRowsCount;
    @XmlTransient //Убрали отображение этого поля, но в дочерних классах покажем его под "нормальными" именами...
    private List dtos;

    public BaseResponse() {
    }

    public BaseResponse(Long totalRowsCount, List dtos) {
        this.totalRowsCount = totalRowsCount;
        this.dtos = dtos;
    }

    public Long getTotalRowsCount() {
        return totalRowsCount;
    }

    public void setTotalRowsCount(Long totalRowsCount) {
        this.totalRowsCount = totalRowsCount;
    }

    public List getDtos() {
        return dtos;
    }

    public void setDtos(List dtos) {
        this.dtos = dtos;
    }
}

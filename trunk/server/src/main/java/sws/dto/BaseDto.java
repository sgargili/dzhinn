package sws.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

/**
 * Developed by: Andrey Popov
 * Date (time): 23.03.11 (16:53)
 */

public class BaseDto {

    private List objects = new ArrayList();

    public BaseDto() {
    }

    @XmlTransient //Убрали отображение этого поля, но в дочерних классах покажем его под "нормальными" именами...
    public List getObjects() {
        return objects;
    }

    public void setObjects(List objects) {
        this.objects = objects;
    }

    public void addObject(Object o) {
        objects.add(o);
    }
}

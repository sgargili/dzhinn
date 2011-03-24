package sws.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import sws.model.User;

/**
 * Developed by: Andrey Popov
 * Date (time): 23.03.11 (17:02)
 */
@XmlRootElement(name = "users", namespace = "user")
public class UserDto extends BaseDto{
    @Override
    @XmlElementWrapper(name = "entities")
    @XmlElement(name = "user", type = User.class)
    public List getObjects() {
        return super.getObjects();
    }
}

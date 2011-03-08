package imf.core.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * Developed by: Администратор
 * Date (time): 06.03.11 (19:12)
 */

public class TemplateDto extends BaseDto {
    private List<GroupDto> groupDtos = new ArrayList<GroupDto>();

    @XmlElementWrapper(name = "groups")
    @XmlElement(name = "group", type = GroupDto.class)
    public List<GroupDto> getGroupDtos() {
        return groupDtos;
    }

    public void setGroupDtos(List<GroupDto> groupDtos) {
        this.groupDtos = groupDtos;
    }
    public void addGroupDtos(GroupDto groupDto) {
        this.groupDtos.add(groupDto);
    }
}

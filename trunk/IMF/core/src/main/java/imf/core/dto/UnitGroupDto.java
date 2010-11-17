package imf.core.dto;

import imf.core.entity.UnitGroup;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 17.11.2010
 * Time: 17:59:53
 * To change this template use File | Settings | File Templates.
 */
public class UnitGroupDto {
    private List<UnitGroup> unitGroup;

    public List<UnitGroup> getUnitGroup() {
        return unitGroup;
    }

    public void setUnitGroup(List<UnitGroup> unitGroup) {
        this.unitGroup = unitGroup;
    }
}

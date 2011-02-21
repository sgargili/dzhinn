package imf.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import imf.core.dao.AttributeDao;
import imf.core.dto.AttributeDto;
import imf.core.dto.web.response.AttributeResponse;
import imf.core.entity.Attribute;
import imf.core.entity.Group;
import imf.core.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Developed by: Andrey Popov
 * Date (time): 21.02.11 (12:50)
 */
 @Repository
@Service("attributeService")
public class AttributeServiceImpl implements AttributeService {
    @Autowired
    AttributeDao attributeDao;

    private List<AttributeDto> convertAttributeListToDto(List<Attribute> attributes) {
        List<AttributeDto> attributeDtos = new ArrayList<AttributeDto>();
        AttributeDto dto;
        for (Attribute attribute : attributes) {
            dto = new AttributeDto();
            dto.setComment(attribute.getComment());
            dto.setId(attribute.getId());
            dto.setName(attribute.getName());
            dto.setSubsGroup(attribute.getSubsGroup());
            dto.setUnitsGroup(attribute.getUnitsGroup());
            dto.setUnitOfMeasure(attribute.getUnitOfMeasure());
            dto.setAttribute2Groups(attribute.getAttribute2Groups());
            dto.setType(attribute.getType());
            dto.setTypeOfValues(attribute.getType());
            attributeDtos.add(dto);
        }
        return attributeDtos;
    }

    @Override
    @Transactional
    public AttributeResponse getAttributesByGroupId(Long groupId) {
        Group group = new Group();
        group.setId(groupId);
        AttributeResponse response = new AttributeResponse();
        response.setDtos(convertAttributeListToDto(attributeDao.getAllAttributesByGroup(group)));
        return response;
    }
}

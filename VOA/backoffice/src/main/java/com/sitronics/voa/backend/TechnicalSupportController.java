package com.sitronics.voa.backend;

import java.util.List;

import com.sitronics.voa.core.dto.TechnicalRecourseDto;
import com.sitronics.voa.core.dto.pages.TechnicalRecoursePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.sitronics.voa.core.dto.TechnicalSupportDto;
import com.sitronics.voa.core.service.TechnicalRecourseService;
import com.sitronics.voa.core.service.TechnicalSupportService;

/**
 * Created by IntelliJ IDEA. User: Moroz Vladimir Date: 14.10.2010 Time: 10:17:12
 */
@Controller
public class TechnicalSupportController {

	@Autowired
	TechnicalSupportService supportService;
	@Autowired
	TechnicalRecourseService recourseService;

	public void setSupportService(TechnicalSupportService supportService) {
		this.supportService = supportService;
	}

	public void setRecourseService(TechnicalRecourseService recourseService) {
		this.recourseService = recourseService;
	}

	@RequestMapping(value = "/getSupprotServices", method = RequestMethod.GET)
	@ResponseBody
	public List<TechnicalSupportDto> getSupprotServices(@RequestParam("regionId") Long regionId) {
		return supportService.getSupportsByRegion(regionId);
	}

    @RequestMapping(value = "/saveTechnicalRecourse", method = RequestMethod.POST)
	@ResponseBody
	public String saveMember(@RequestBody TechnicalRecourseDto technicalRecourseDto) {
		return recourseService.insert(technicalRecourseDto).getId().toString();
	}

    @RequestMapping(value = "/getTechnicalRecourses", method = RequestMethod.GET)
	@ResponseBody
	public TechnicalRecoursePage getTechnicalRecourses(@RequestParam("firstRow") Long firstRow, @RequestParam("listSize") Integer listSize,
		@RequestParam("sortColumn") String sortColumn, @RequestParam("sortOrder") String sortOrder) {
		return recourseService.getRecoursePage(firstRow, listSize, sortColumn, sortOrder);
	}
}


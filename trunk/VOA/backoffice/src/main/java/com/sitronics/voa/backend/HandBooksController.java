package com.sitronics.voa.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sitronics.voa.core.dto.CarBrandDto;
import com.sitronics.voa.core.dto.CarModelDto;
import com.sitronics.voa.core.dto.RegionDto;
import com.sitronics.voa.core.service.CarBrandService;
import com.sitronics.voa.core.service.CarModelService;
import com.sitronics.voa.core.service.RegionService;

@Controller
public class HandBooksController {

    @Autowired
    private RegionService regionService;
    @Autowired
    private CarBrandService brandService;
    @Autowired
    private CarModelService modelService;

    public void setRegionService(RegionService regionService) {
        this.regionService = regionService;
    }

    public void setBrandService(CarBrandService brandService) {
        this.brandService = brandService;
    }

    public void setModelService(CarModelService modelService) {
        this.modelService = modelService;
    }

    @RequestMapping(value = "/regions", method = RequestMethod.GET)
    @ResponseBody
    public List<RegionDto> getRegions() {
        System.out.println("Getting Regions Page");
        return regionService.getRegions();
    }

    @RequestMapping(value = "/brands", method = RequestMethod.GET)
    @ResponseBody
    public List<CarBrandDto> getCarBrands() {
        System.out.println("Getting Regions Page");
        return brandService.getBrands();
    }

    @RequestMapping(value = "/models", method = RequestMethod.GET)
    @ResponseBody
    public List<CarModelDto> getCarModels() {
        System.out.println("Getting CarModels Page");
        return modelService.getModels();
    }

    @RequestMapping(value = "/modelsByBrand", method = RequestMethod.GET)
    @ResponseBody
    public List<CarModelDto> getCarModelsByCarBrandId(@RequestParam("brandId") Long brandId) {
        System.out.println("Getting CarModels Page By CarBrandId");
        return modelService.getCarModelsByBrandId(brandId);
    }
}

package com.sitronics.filenet.controller;

/**
 * @author Andrey Popov creates on 05.07.11 (11:02)
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sitronics.filenet.core.model.ExcelClassDefinition;
import com.sitronics.filenet.core.service.ExcelService;
import com.sitronics.filenet.core.service.FileNetService;


@Controller
public class UploadController {
    @Autowired
    ExcelService excelService;
    @Autowired
    FileNetService fileNetService;

    @RequestMapping(value = "/uploadForm", method = RequestMethod.POST)
    @ResponseBody
    public String create(UploadItem uploadItem, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            return "{\"success\": false}";
        } else {
            List<ExcelClassDefinition> list = excelService.getExcelClassDefinitions((FileInputStream) uploadItem.getFileData().getInputStream());
            fileNetService.storeObjects2FileNet(list);
            return "{\"success\": true}";
        }
    }
}

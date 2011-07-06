package com.sitronics.filenet.core.service.impl;

import java.io.FileInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitronics.filenet.core.model.EntityDefinition;
import com.sitronics.filenet.core.service.ExcelService;
import com.sitronics.filenet.core.service.FileNetService;
import com.sitronics.filenet.core.service.JobService;

/**
 * @author Andrey Popov creates on 06.07.11 (17:16)
 */
@Service("jobService")
public class JobServiceImpl implements JobService {
    @Autowired
    ExcelService excelService;

    @Autowired
    FileNetService fileNetService;

    @Override
    public void doJob(FileInputStream fileInputStream) {
        List<EntityDefinition> entityDefinitions = excelService.getEntityDefinitionsFromExcel(fileInputStream);
        for (EntityDefinition entityDefinition : entityDefinitions) {
            fileNetService.storeEntityDefinition(entityDefinition);
        }
    }
}

package com.sitronics.spp.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sitronics.spp.service.FileService;

/**
 * @author Andrey Popov creates on 11.04.11 (17:34)
 */
@Service("fileService")
public class FileServiceImpl implements FileService {
    Logger logger = LoggerFactory.getLogger(XmlServiceImpl.class);

    @Resource
    private ArrayList<String> additionList;

    private File inputFolder;
    private File outputFolder;
    private List<File> files = new ArrayList<File>();
    private StringBuffer outFileName = new StringBuffer();

    public void copy(String inFolder, String outFolder) {
        inputFolder = new File(inFolder);
        if (inputFolder.isDirectory()) {
            files = (List<File>) FileUtils.listFiles(inputFolder, FileFileFilter.FILE, FalseFileFilter.FALSE);
            logger.info("Input file is Directory...");
        } else {
            logger.info("Input file is not Directory or is empty...");
        }
        for (String addition : additionList) {
            for (File file : files) {
                if (file.isFile()) {
                    outFileName.append(FilenameUtils.getBaseName(file.getName()))
                            .append("_")
                            .append(addition)
                            .append(".")
                            .append(FilenameUtils.getExtension(file.getName()));
                    try {
                        FileUtils.copyFile(file, new File(FilenameUtils.concat(outFolder, outFileName.toString())));
                    } catch (IOException e) {
                        logger.error("Error: ", e);
                    }
                }
            }
            outFileName.setLength(0);
        }
    }
}

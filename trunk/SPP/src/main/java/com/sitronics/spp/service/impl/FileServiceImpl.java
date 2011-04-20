package com.sitronics.spp.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sitronics.spp.service.FileService;

/**
 * @author Andrey Popov creates on 11.04.11 (17:34)
 */
@Service("fileService")
public class FileServiceImpl implements FileService {
    Logger logger = LoggerFactory.getLogger(XmlServiceImpl.class);

    @Resource
    private HashMap<String, String> additionList;

    private File inputFolder;
    private List<File> files = new ArrayList<File>();
    private StringBuffer outFileName = new StringBuffer();
    private SuffixFileFilter suffixFileFilter;

    public void copy(String inFolder, String outFolder, String fileExtension) {

        // Если расширение файла пустое или null то используем значение по-умолчанию.
        if (StringUtils.hasText(fileExtension)) {
            suffixFileFilter = new SuffixFileFilter(fileExtension);
        } else {
            logger.info("Used default file filter '.fcbat'");
            suffixFileFilter = new SuffixFileFilter(".fcbat");
        }

        // Берем коллекцию файлов во входной директории.
        inputFolder = new File(inFolder);
        if (inputFolder.isDirectory()) {
            // Берем только файлы в указаной входной директории с указанным расширением файлов и без поддиректорий.
            files = (List<File>) FileUtils.listFiles(inputFolder, suffixFileFilter, FalseFileFilter.FALSE);
            logger.info("Input file is Directory...");
        } else {
            logger.info("Input file is not Directory or is empty...");
        }

        // Бежим по 'регионам'...
        for (Map.Entry<String, String> entry : additionList.entrySet()) {
            // Бежим по файлам...
            for (File file : files) {
                if (file.isFile()) {
                    // Сборка имени файла...
                    outFileName.append(FilenameUtils.getBaseName(file.getName()))
                            .append("_")
                            .append(entry.getValue())
                            .append("_")
                            .append(entry.getKey())
                            .append(".")
                            .append(FilenameUtils.getExtension(file.getName()));
                    try {
                        FileUtils.copyFile(file, new File(FilenameUtils.concat(outFolder, outFileName.toString())));
                    } catch (IOException e) {
                        logger.error(e.getMessage());
                    }
                }
                // Опустошаем буфер...
                outFileName.setLength(0);
            }
        }
    }
}

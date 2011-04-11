package com.sitronics.spp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sitronics.spp.service.FileService;

/**
 * @author Andrey Popov creates on 11.04.11 (17:34)
 */
public class FileServiceImpl implements FileService {

    @Autowired
    private List<String> additionList;

    public void copy(String inFolder, String outFolder) {

    }
}

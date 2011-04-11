package com.sitronics.spp.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitronics.spp.service.FileService;

/**
 * @author Andrey Popov creates on 11.04.11 (17:34)
 */
@Service("fileService")
public class FileServiceImpl implements FileService {

    @Autowired(required = false)
    private ArrayList<String> additionList;

    public void copy(String inFolder, String outFolder) {
        for (String s : additionList) {
            System.out.println(s);
        }

    }
}

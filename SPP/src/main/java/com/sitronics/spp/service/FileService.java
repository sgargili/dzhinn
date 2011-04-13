package com.sitronics.spp.service;

/**
 * @author Andrey Popov creates on 11.04.11 (17:32)
 */
public interface FileService {

    /**
     * @param inFolder the String of name directory with input files.
     * @param outFolder the String of name of output directory.
     * @param fileExtension the String of name file extension for file filter.
     */
    void copy(String inFolder, String outFolder, String fileExtension);
}

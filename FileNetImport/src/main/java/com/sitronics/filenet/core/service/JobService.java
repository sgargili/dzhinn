package com.sitronics.filenet.core.service;

import java.io.FileInputStream;

/**
 * @author Andrey Popov creates on 06.07.11 (17:15)
 */
public interface JobService {
    void doJob(FileInputStream fileInputStream);
}

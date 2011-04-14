package com.sitronics.spp.service;

import com.sitronics.spp.model.BatchTypes;

/**
 * @author Andrey Popov creates on 11.04.11 (16:01)
 */
public interface XmlService {
    String marshal(BatchTypes batchTypes);

    BatchTypes unmarshal(String xmlData);
}

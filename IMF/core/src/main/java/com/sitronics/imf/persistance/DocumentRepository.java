package com.sitronics.imf.persistance;

import com.sitronics.imf.Document;

/**
 * @author Andrey Popov creates on 20.07.11 (10:46)
 */
public interface DocumentRepository {
    void store(Document document);

    Document getDocument(Long id);

    void remove(Document document);
}

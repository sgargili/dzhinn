package com.sitronics.imf.persistance;

import com.sitronics.imf.Document;

/**
 * @author Andrey Popov creates on 20.07.11 (18:22)
 */
public interface BaseRepository {
    void store(Object object);

    Object getEntity(Long id);

    void remove(Object object);
}

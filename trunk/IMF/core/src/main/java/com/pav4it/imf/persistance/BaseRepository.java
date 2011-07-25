package com.pav4it.imf.persistance;

import java.util.List;

/**
 * @author Andrey Popov creates on 20.07.11 (18:22)
 */
public interface BaseRepository {
    void store(Object object);

    Object getEntity(Long id);

    List getAllEntities(int firstResult, int maxResult);

    List getAllEntitiesByName(String name, int firstResult, int maxResult);

    void remove(Object object);
}

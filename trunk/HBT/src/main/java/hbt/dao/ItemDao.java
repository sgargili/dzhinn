package hbt.dao;

import java.util.List;

import hbt.model.Item;

/**
 * Developed by: Andrey Popov
 * Date (time): 25.02.11 (16:53)
 */

public interface ItemDao {
    Item getItemById(Integer id);

    List<Item> getItemsByProductId(Integer id);
}

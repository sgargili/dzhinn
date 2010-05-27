<?php

/**
 * Интерфейс TreeDAO.
 * Определение методов нативной работой с базой.
 *
 * @author APopov
 * @date: 2010-05-27
 */
interface TreeDAO {

    /**
     * Get Domain object by primry key
     *
     * @param String $id primary key
     * @Return Tree
     */
    public function load($id);

    /**
     * Get all records from table
     */
    public function queryAll();

    /**
     * Get all records from table ordered by field
     * @Param $orderColumn column name
     */
    public function queryAllOrderBy($orderColumn);

    /**
     * Delete record from table
     * @param tree primary key
     */
    public function delete($tid);

    /**
     * Insert record to table
     *
     * @param Tree tree
     */
    public function insert($tree);

    /**
     * Update record in table
     *
     * @param Tree tree
     */
    public function update($tree);

    /**
     * Delete all rows
     */
    public function clean();

    public function queryByName($value);

    public function deleteByName($value);
}
?>
<?php

/**
 * Интерфейс NodeDAO.
 * Определение методов нативной работой с базой.
 *
 * @author APopov
 * @date: 2010-05-27
 */
interface NodeDAO {

    /**
     * Get Domain object by primry key
     *
     * @param String $id primary key
     * @Return Node
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
     * @param node primary key
     */
    public function delete($nid);

    /**
     * Insert record to table
     *
     * @param Node node
     */
    public function insert($node);

    /**
     * Update record in table
     *
     * @param Node node
     */
    public function update($node);

    public function updateOnlyName($node);

    /**
     * 3 метода для работы с весами и расположением нод. Подробное описание
     * см. в классах Response и имплементации этого интерфейса.
     */
    public function updateOnlyPosition($node);

    public function updateFixedPositionUp($nodeNew, $nodeOld);

    public function updateFixedPositionDown($nodeNew, $nodeOld);

    /**
     * Delete all rows
     */
    public function clean();

    public function queryByTid($value);

    public function queryByName($value);

    public function queryByPid($value);

    public function queryByTidAndPid($tid, $pid);

    public function queryByWeight($value);

    public function deleteByTid($value);

    public function deleteByName($value);

    public function deleteByPid($value);

    public function deleteByWeight($value);
}
?>
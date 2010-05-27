<?php

/**
 * Имплементация интерфейса TreeDAO.
 * Предназначена для нативной работы слоя DAO с базой.
 *
 * @author APopov
 * @date: 2010-05-27
 */
class TreeMySqlDAO implements TreeDAO {

    /**
     * Get Domain object by primry key
     *
     * @param String $id primary key
     * @return TreeMySql
     */
    public function load($id) {
        $sql = 'SELECT * FROM tree WHERE tid = ?';
        $sqlQuery = new SqlQuery($sql);
        $sqlQuery->setNumber($id);
        return $this->getRow($sqlQuery);
    }

    /**
     * Get all records from table
     */
    public function queryAll() {
        $sql = 'SELECT * FROM tree';
        $sqlQuery = new SqlQuery($sql);
        return $this->getList($sqlQuery);
    }

    /**
     * Get all records from table ordered by field
     *
     * @param $orderColumn column name
     */
    public function queryAllOrderBy($orderColumn) {
        $sql = 'SELECT * FROM tree ORDER BY ' . $orderColumn;
        $sqlQuery = new SqlQuery($sql);
        return $this->getList($sqlQuery);
    }

    /**
     * Delete record from table
     * @param tree primary key
     */
    public function delete($tid) {
        $sql = 'DELETE FROM tree WHERE tid = ?';
        $sqlQuery = new SqlQuery($sql);
        $sqlQuery->setNumber($tid);
        return $this->executeUpdate($sqlQuery);
    }

    /**
     * Insert record to table
     *
     * @param TreeMySql tree
     */
    public function insert($tree) {
        $sql = 'INSERT INTO tree (name) VALUES (?)';
        $sqlQuery = new SqlQuery($sql);

        $sqlQuery->set($tree->getName());

        $id = $this->executeInsert($sqlQuery);
        $tree->setTid($id);
        return $id;
    }

    /**
     * Update record in table
     *
     * @param TreeMySql tree
     */
    public function update($tree) {
        $sql = 'UPDATE tree SET name = ? WHERE tid = ?';
        $sqlQuery = new SqlQuery($sql);

        $sqlQuery->set($tree->getName());

        $sqlQuery->setNumber($tree->getTid());
        return $this->executeUpdate($sqlQuery);
    }

    /**
     * Delete all rows
     */
    public function clean() {
        $sql = 'DELETE FROM tree';
        $sqlQuery = new SqlQuery($sql);
        return $this->executeUpdate($sqlQuery);
    }

    public function queryByName($value) {
        $sql = 'SELECT * FROM tree WHERE name = ?';
        $sqlQuery = new SqlQuery($sql);
        $sqlQuery->set($value);
        return $this->getList($sqlQuery);
    }

    public function deleteByName($value) {
        $sql = 'DELETE FROM tree WHERE name = ?';
        $sqlQuery = new SqlQuery($sql);
        $sqlQuery->set($value);
        return $this->executeUpdate($sqlQuery);
    }

    /**
     * Read row
     *
     * @return TreeMySql
     */
    protected function readRow($row) {
        $tree = new Tree();

        $tree->setTid($row['tid']);
        $tree->setName($row['name']);

        return $tree;
    }

    protected function getList($sqlQuery) {
        $tab = QueryExecutor::execute($sqlQuery);
        $ret = array();
        for ($i = 0; $i < count($tab); $i++) {
            $ret[$i] = $this->readRow($tab[$i]);
        }
        return $ret;
    }

    /**
     * Get row
     *
     * @return TreeMySql
     */
    protected function getRow($sqlQuery) {
        $tab = QueryExecutor::execute($sqlQuery);
        if (count($tab) == 0) {
            return null;
        }
        return $this->readRow($tab[0]);
    }

    /**
     * Execute sql query
     */
    protected function execute($sqlQuery) {
        return QueryExecutor::execute($sqlQuery);
    }

    /**
     * Execute sql query
     */
    protected function executeUpdate($sqlQuery) {
        return QueryExecutor::executeUpdate($sqlQuery);
    }

    /**
     * Query for one row and one column
     */
    protected function querySingleResult($sqlQuery) {
        return QueryExecutor::queryForString($sqlQuery);
    }

    /**
     * Insert row to table
     */
    protected function executeInsert($sqlQuery) {
        return QueryExecutor::executeInsert($sqlQuery);
    }

}
?>
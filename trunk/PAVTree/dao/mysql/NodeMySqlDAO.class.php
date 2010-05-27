<?php

/**
 * Имплементация интерфейса NodeDAO.
 * Предназначена для нативной работы слоя DAO с базой.
 *
 * @author APopov
 * @date: 2010-05-27
 */
class NodeMySqlDAO implements NodeDAO {

    /**
     * Get Domain object by primry key
     *
     * @param String $id primary key
     * @return NodeMySql
     */
    public function load($id) {
        $sql = 'SELECT * FROM node WHERE nid = ?';
        $sqlQuery = new SqlQuery($sql);
        $sqlQuery->setNumber($id);
        return $this->getRow($sqlQuery);
    }

    /**
     * Get all records from table
     */
    public function queryAll() {
        $sql = 'SELECT * FROM node';
        $sqlQuery = new SqlQuery($sql);
        return $this->getList($sqlQuery);
    }

    /**
     * Get all records from table ordered by field
     *
     * @param $orderColumn column name
     */
    public function queryAllOrderBy($orderColumn) {
        $sql = 'SELECT * FROM node ORDER BY ' . $orderColumn;
        $sqlQuery = new SqlQuery($sql);
        return $this->getList($sqlQuery);
    }

    /**
     * Delete record from table
     * @param node primary key
     */
    public function delete($nid) {
        $sql = 'DELETE FROM node WHERE nid = ?';
        $sqlQuery = new SqlQuery($sql);
        $sqlQuery->setNumber($nid);
        return $this->executeUpdate($sqlQuery);
    }

    /**
     * Insert record to table
     *
     * @param NodeMySql node
     */
    public function insert($node) {
        $sql = 'INSERT INTO node (tid, name, pid, weight) VALUES (?, ?, ?, ?)';
        $sqlQuery = new SqlQuery($sql);
        $sqlQuery->setNumber($node->getTid());
        $sqlQuery->set($node->getName());
        $sqlQuery->setNumber($node->getPid());
        $sqlQuery->setNumber($node->getWeight());
        $node->setNid($this->executeInsert($sqlQuery));
        return $node;
    }

    /**
     * Update record in table
     *
     * @param NodeMySql node
     */
    public function update($node) {
        $sql = 'UPDATE node SET tid = ?, name = ?, pid = ?, weight = ? WHERE nid = ?';
        $sqlQuery = new SqlQuery($sql);

        $sqlQuery->setNumber($node->getTid());
        $sqlQuery->set($node->getName());
        $sqlQuery->setNumber($node->getPid());
        $sqlQuery->setNumber($node->getWeight());
        $sqlQuery->setNumber($node->getNid());

        return $this->executeUpdate($sqlQuery);
    }

    public function updateOnlyName($node) {
        $sql = 'UPDATE node SET name = ? WHERE nid = ?';
        $sqlQuery = new SqlQuery($sql);

        $sqlQuery->set($node->getName());
        $sqlQuery->setNumber($node->getNid());

        return $this->executeUpdate($sqlQuery);
    }

    public function updateOnlyPosition($node) {
        $sql = 'UPDATE node SET tid = ?, pid = ?, weight = ? WHERE nid = ?';
        $sqlQuery = new SqlQuery($sql);

        $sqlQuery->setNumber($node->getTid());
        $sqlQuery->setNumber($node->getPid());
        $sqlQuery->setNumber($node->getWeight());
        $sqlQuery->setNumber($node->getNid());

        return $this->executeUpdate($sqlQuery);
    }

    /**
     * Метод который фиксит веса нод. Логика работы описана в классе Response.
     */
    public function updateFixedPositionUp($nodeNew, $nodeOld) {
        $sql = 'UPDATE node SET weight = weight + 1 WHERE nid!=? AND tid = ? AND pid = ? AND weight >= ? AND weight < ?';
        $sqlQuery = new SqlQuery($sql);
        $sqlQuery->setNumber($nodeNew->getNid());
        $sqlQuery->setNumber($nodeNew->getTid());
        $sqlQuery->setNumber($nodeNew->getPid());
        $sqlQuery->setNumber($nodeNew->getWeight());
        $sqlQuery->setNumber($nodeOld->getWeight());
        return $this->executeUpdate($sqlQuery);
    }

    /**
     * Метод который фиксит веса нод. Логика работы описана в классе Response.
     */
    public function updateFixedPositionDown($nodeNew, $nodeOld) {
        $sql = 'UPDATE node SET weight = weight - 1 WHERE nid!=? AND tid = ? AND pid = ? AND weight <= ? AND weight > ?';
        $sqlQuery = new SqlQuery($sql);
        $sqlQuery->setNumber($nodeNew->getNid());
        $sqlQuery->setNumber($nodeNew->getTid());
        $sqlQuery->setNumber($nodeNew->getPid());
        $sqlQuery->setNumber($nodeNew->getWeight());
        $sqlQuery->setNumber($nodeOld->getWeight());
        return $this->executeUpdate($sqlQuery);
    }

    /**
     * Delete all rows
     */
    public function clean() {
        $sql = 'DELETE FROM node';
        $sqlQuery = new SqlQuery($sql);
        return $this->executeUpdate($sqlQuery);
    }

    public function queryByTid($value) {
        $sql = 'SELECT * FROM node WHERE tid = ? ORDER BY pid, weight';
        $sqlQuery = new SqlQuery($sql);
        $sqlQuery->setNumber($value);
        return $this->getList($sqlQuery);
    }

    public function queryByName($value) {
        $sql = 'SELECT * FROM node WHERE name = ?';
        $sqlQuery = new SqlQuery($sql);
        $sqlQuery->set($value);
        return $this->getList($sqlQuery);
    }

    public function queryByPid($value) {
        $sql = 'SELECT * FROM node WHERE pid = ?';
        $sqlQuery = new SqlQuery($sql);
        $sqlQuery->setNumber($value);
        return $this->getList($sqlQuery);
    }

    public function queryByTidAndPid($tid, $pid) {
        $sql = 'SELECT * FROM node WHERE tid = ? AND pid = ?';
        $sqlQuery = new SqlQuery($sql);
        $sqlQuery->setNumber($tid);
        $sqlQuery->setNumber($pid);
        return $this->getList($sqlQuery);
    }

    public function queryByWeight($value) {
        $sql = 'SELECT * FROM node WHERE weight = ?';
        $sqlQuery = new SqlQuery($sql);
        $sqlQuery->setNumber($value);
        return $this->getList($sqlQuery);
    }

    public function deleteByTid($value) {
        $sql = 'DELETE FROM node WHERE tid = ?';
        $sqlQuery = new SqlQuery($sql);
        $sqlQuery->setNumber($value);
        return $this->executeUpdate($sqlQuery);
    }

    public function deleteByName($value) {
        $sql = 'DELETE FROM node WHERE name = ?';
        $sqlQuery = new SqlQuery($sql);
        $sqlQuery->set($value);
        return $this->executeUpdate($sqlQuery);
    }

    public function deleteByPid($value) {
        $sql = 'DELETE FROM node WHERE pid = ?';
        $sqlQuery = new SqlQuery($sql);
        $sqlQuery->setNumber($value);
        return $this->executeUpdate($sqlQuery);
    }

    public function deleteByWeight($value) {
        $sql = 'DELETE FROM node WHERE weight = ?';
        $sqlQuery = new SqlQuery($sql);
        $sqlQuery->setNumber($value);
        return $this->executeUpdate($sqlQuery);
    }

    /**
     * Read row
     *
     * @return NodeMySql
     */
    protected function readRow($row) {
        $node = new Node();

        $node->setNid($row['nid']);
        $node->setTid($row['tid']);
        $node->setName($row['name']);
        $node->setPid($row['pid']);
        $node->setWeight($row['weight']);

        return $node;
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
     * @return NodeMySql
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
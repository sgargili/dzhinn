<?php

/**
 * Класс Connection.
 *
 * @author APopov
 * @date: 2010-05-27
 */
class Connection {

    private $connection;

    public function Connection() {
        $this->connection = ConnectionFactory::getConnection();
    }

    public function close() {
        ConnectionFactory::close($this->connection);
    }

    public function executeQuery($sql) {
        return mysql_query($sql, $this->connection);
    }

}
?>
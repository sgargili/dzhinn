<?php

/**
 * Класс ConnectionFactory.
 * Фабрика раздающая статические объекты Connection.
 *
 * @author APopov
 * @date: 2010-05-27
 */
class ConnectionFactory {

    static public function getConnection() {
        $conn = mysql_connect(ConnectionProperty::getHost(), ConnectionProperty::getUser(), ConnectionProperty::getPassword());
        mysql_select_db(ConnectionProperty::getDatabase());
        mysql_query("SET NAMES " . ConnectionProperty::getEncoding());
        if (!$conn) {
            throw new Exception('could not connect to database');
        }
        return $conn;
    }

    static public function close($connection) {
        mysql_close($connection);
    }

}
?>
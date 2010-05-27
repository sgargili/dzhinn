<?php

/**
 * Класс ConnectionProperty.
 * Параметры соединения с базой.
 * Параметры инкапсулированы, доступны только для чтения.
 *
 * @author APopov
 * @date: 2010-05-27
 */
class ConnectionProperty {

    private static $host = 'localhost';
    private static $user = 'root';
    private static $password = 'Pass4root';
    private static $database = 'somedb';
    private static $encoding = 'CP1251';

    public static function getHost() {
        return ConnectionProperty::$host;
    }

    public static function getUser() {
        return ConnectionProperty::$user;
    }

    public static function getPassword() {
        return ConnectionProperty::$password;
    }

    public static function getDatabase() {
        return ConnectionProperty::$database;
    }

    public static function getEncoding() {
        return ConnectionProperty::$encoding;
    }

}
?>
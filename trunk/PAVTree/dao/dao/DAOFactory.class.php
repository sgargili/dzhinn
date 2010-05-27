<?php

/**
 * Класс DAOFactory.
 * Основная фабрика создающая классы DAO слоя.
 *
 * @author APopov
 * @date: 2010-05-27
 */
class DAOFactory {

    /**
     * @return NodeDAO
     */
    public static function getNodeDAO() {
        return new NodeMySqlExtDAO();
    }

    /**
     * @return TreeDAO
     */
    public static function getTreeDAO() {
        return new TreeMySqlExtDAO();
    }

}
?>
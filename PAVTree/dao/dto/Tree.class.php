<?php

/**
 * Класс Tree.
 * Объект проецируемый на строки таблицы tree.
 * 
 * @author APopov
 * @date: 2010-05-27
 */
class Tree {

    private $tid;
    private $name;

    function __construct() {

    }

    public function getTid() {
        return $this->tid;
    }

    public function setTid($tid) {
        $this->tid = $tid;
    }

    public function getName() {
        return $this->name;
    }

    public function setName($name) {
        $this->name = $name;
    }

}
?>
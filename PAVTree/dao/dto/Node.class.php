<?php

/**
 * Класс Node.
 * Объект проецируемый на строки таблицы node.
 *
 * @author APopov
 * @date: 2010-05-27
 */
class Node {

    private $nid;
    private $tid;
    private $name;
    private $pid;
    private $weight;

    function __construct() {

    }

    public function getNid() {
        return $this->nid;
    }

    public function setNid($nid) {
        $this->nid = $nid;
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

    public function getPid() {
        return $this->pid;
    }

    public function setPid($pid) {
        $this->pid = $pid;
    }

    public function getWeight() {
        return $this->weight;
    }

    public function setWeight($weight) {
        $this->weight = $weight;
    }

}
?>
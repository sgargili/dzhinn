<?php

/**
 *  ласс SqlQuery.
 * ќбъект выполн€ющий установку параметров запросов к базе.
 *
 * @author APopov
 * @date: 2010-05-27
 */
class SqlQuery {

    var $txt;
    var $params = array();
    var $idx = 0;

    function SqlQuery($txt) {
        $this->txt = $txt;
    }

    public function setString($value) {
        $value = mysql_escape_string($value);
        $this->params[$this->idx++] = "'" . $value . "'";
    }

    public function set($value) {
        $value = mysql_escape_string($value);
        $this->params[$this->idx++] = "'" . $value . "'";
    }

    public function setNumber($value) {
        if ($value == null) {
            $this->params[$this->idx++] = "null";
            return;
        }
        if (!is_numeric($value)) {
            throw new Exception($value . ' is not a number');
        }
        $this->params[$this->idx++] = "'" . $value . "'";
    }

    public function getQuery() {
        if ($this->idx == 0) {
            return $this->txt;
        }
        $p = explode("?", $this->txt);
        $sql = '';
        for ($i = 0; $i <= $this->idx; $i++) {
            if ($i >= count($this->params)) {
                $sql .= $p[$i];
            } else {
                $sql .= $p[$i] . $this->params[$i];
            }
        }
        return $sql;
    }

    private function replaceFirst($str, $old, $new) {
        $len = strlen($str);
        for ($i = 0; $i < $len; $i++) {
            if ($str[$i] == $old) {
                $str = substr($str, 0, $i) . $new . substr($str, $i + 1);
                return $str;
            }
        }
        return $str;
    }

}
?>
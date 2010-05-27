<?php

/**
 * Singleton класс Response с основной логикой.
 * Предназначен для создания ответов клиенту по работе с деревом.
 *
 * @author APopov
 * @date: 2010-05-27
 */
if (file_exists('../dao/include_dao.php')) {
    include_once('../dao/include_dao.php');
} else {
    include_once('dao/include_dao.php');
}
require_once('tools/XmlConvertor.class.php');

class Response {

    private static $__instance;

    public static function getInstance() {
        if (self::$__instance == NULL)
            self::$__instance = new Response;
        return self::$__instance;
    }

    /**
     * Проверка принадлежности ребенка к родителю.
     *
     * @return boolean
     */
    private function checkExistence($nid, $tid, $pid) {

        $nodes = DAOFactory::getNodeDAO()->queryByTidAndPid($tid, $pid);
        foreach ($nodes as $node) {
            if ($node->getNid() == $nid) {
                return true;
            }
        }
        return false;
    }

    /**
     * Определение типа сдвига ноды при реордеринге.
     *
     * Принцип: Есть ребенок (нода, которую мы перетаскиваем в дереве),
     * есть родитель (нода, в которую мы перетаскиваем), у ребенка есть вес,
     * причем чем больше вес, тем нода ниже по дереву. Родители так же могут
     * быть детьми.
     * Смотрим, является ли ребенок родным для родителя, если да, то
     * тогда узнаем изначальный вес ребенка и сравниваем с тем, что пришел в
     * запросе, если они равны, то ничего не предпринимаем, если изначальный
     * вес больше пришедшего, то тогда значит, что ребенок "взлетел",
     * обозначаем этот тип сдвига 1, если изначальный вес меньше пришедшего, то,
     * соответственно, ребенок "упал", обозначаем тип сдвига 0.
     * Если ребенок не родной для родителя, тогда считаем, что он "взлетел",
     * обозначая тип сдвига 1.
     *
     * @return (int) 1 или 0
     */
    private function checkMovedAction($nid, $tid, $pid, $weightNew, $weightOld) {
        if ($this->checkExistence($nid, $tid, $pid)) {
            if ($weightOld == $weightNew) {
                return 3;
            } else {
                return $weightOld > $weightNew ? 1 : 0;
            }
        } else {
            return 2;
        }
    }

    /**
     * Отдача всего дерева в XML виде.
     *
     * @return (string) xml Xml документ
     */
    public function getTreeNodes($tid) {

        header('Content-type: application/xml');

        $arr = DAOFactory::getNodeDAO()->queryByTid($tid);

        $converter = new xmlConvertor();
        $converter->setRootName("root");
        $converter->setEncoding("utf-8");

        $output = $converter->convert($arr);

        return $output;
    }

    /**
     * Добавление новой ноды в дерево.
     *
     * @return (int) nid Id новой ноды.
     */
    public function addTreeNode($tid, $name, $pid, $weight) {

        $node = new Node();
        $node->setTid($tid);
        $node->setName(iconv('UTF-8', 'Windows-1251', $name));
        $node->setPid($pid);
        $node->setWeight($weight);
        $node = DAOFactory::getNodeDAO()->insert($node);

        return (int) $node->getNid();
    }

    /**
     * Удаление ноды в дереве.
     *
     * @return (int) 1 или 0
     */
    public function deleteTreeNode($nid) {
        return DAOFactory::getNodeDAO()->delete($nid);
    }

    /**
     * Переименование ноды в дереве.
     *
     * @return (int) 1 или 0
     */
    public function updateTreeNodeName($nid, $tid, $name) {

        $node = new Node();
        $node->setNid($nid);
        $node->setTid($tid);
        $node->setName(iconv('UTF-8', 'Windows-1251', $name));

        return DAOFactory::getNodeDAO()->updateOnlyName($node);
    }

    /**
     * Реордеринг ноды.
     *
     * Принцип: Если ребенок "взлетел", то у всех детей, что тяжелее его сейчас,
     * но, были легче на момент "взлета", вес увеличивается на единицу, если
     * ребенок "упал", то у всех детей, что легче
     * его сейчас, но были тяжелее на момент "падения", вес уменьшается на
     * единицу, а если уж ребенка "подкинули" другие родители, то у всех детей
     * тяжелее его вес увеличивается на единицу...
     * Иными словами, мы меняем веса нод, находящихся внутри промежутка
     * изменения, если ноду перемещали в пределах одного родителя, и, -
     * увеличиваем веса всех более тяжелых нод чем перемещаемая, если нода
     * пришла от другого родителя.
     *
     * @return (int) 1 или 0 или Nothing to do...
     */
    public function updateTreeNodePosition($nid, $tid, $pid, $weight) {

        if ($pid == 'tree') {
            $pid = '0';
        }

        $nodeNew = new Node();
        $nodeNew->setNid($nid);
        $nodeNew->setTid($tid);
        $nodeNew->setPid($pid);
        $nodeNew->setWeight($weight);

        $nodeOld = DAOFactory::getNodeDAO()->load($nid);

        $cma = $this->checkMovedAction($nid, $tid, $pid, $weight, $nodeOld->getWeight());

        if ($cma == 1) {
            DAOFactory::getNodeDAO()->updateOnlyPosition($nodeNew);
            return DAOFactory::getNodeDAO()->updateFixedPositionUp($nodeNew, $nodeOld);
        } else if ($cma == 0) {
            DAOFactory::getNodeDAO()->updateOnlyPosition($nodeNew);
            return DAOFactory::getNodeDAO()->updateFixedPositionDown($nodeNew, $nodeOld);
        } else if ($cma == 2) {
            DAOFactory::getNodeDAO()->updateOnlyPosition($nodeNew);
            // Ограничим максимальный вес в 1000 кг. :)
            $nodeOld->setWeight('1000');
            return DAOFactory::getNodeDAO()->updateFixedPositionUp($nodeNew, $nodeOld);
        } else {
            return 'Nothing to do.';
        }
    }

}
?>

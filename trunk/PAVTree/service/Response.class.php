<?php

/**
 * Singleton ����� Response � �������� �������.
 * ������������ ��� �������� ������� ������� �� ������ � �������.
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
     * �������� �������������� ������� � ��������.
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
     * ����������� ���� ������ ���� ��� �����������.
     *
     * �������: ���� ������� (����, ������� �� ������������� � ������),
     * ���� �������� (����, � ������� �� �������������), � ������� ���� ���,
     * ������ ��� ������ ���, ��� ���� ���� �� ������. �������� ��� �� �����
     * ���� ������.
     * �������, �������� �� ������� ������ ��� ��������, ���� ��, ��
     * ����� ������ ����������� ��� ������� � ���������� � ���, ��� ������ �
     * �������, ���� ��� �����, �� ������ �� �������������, ���� �����������
     * ��� ������ ����������, �� ����� ������, ��� ������� "�������",
     * ���������� ���� ��� ������ 1, ���� ����������� ��� ������ ����������, ��,
     * ��������������, ������� "����", ���������� ��� ������ 0.
     * ���� ������� �� ������ ��� ��������, ����� �������, ��� �� "�������",
     * ��������� ��� ������ 1.
     *
     * @return (int) 1 ��� 0
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
     * ������ ����� ������ � XML ����.
     *
     * @return (string) xml Xml ��������
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
     * ���������� ����� ���� � ������.
     *
     * @return (int) nid Id ����� ����.
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
     * �������� ���� � ������.
     *
     * @return (int) 1 ��� 0
     */
    public function deleteTreeNode($nid) {
        return DAOFactory::getNodeDAO()->delete($nid);
    }

    /**
     * �������������� ���� � ������.
     *
     * @return (int) 1 ��� 0
     */
    public function updateTreeNodeName($nid, $tid, $name) {

        $node = new Node();
        $node->setNid($nid);
        $node->setTid($tid);
        $node->setName(iconv('UTF-8', 'Windows-1251', $name));

        return DAOFactory::getNodeDAO()->updateOnlyName($node);
    }

    /**
     * ���������� ����.
     *
     * �������: ���� ������� "�������", �� � ���� �����, ��� ������� ��� ������,
     * ��, ���� ����� �� ������ "������", ��� ������������� �� �������, ����
     * ������� "����", �� � ���� �����, ��� �����
     * ��� ������, �� ���� ������� �� ������ "�������", ��� ����������� ��
     * �������, � ���� �� ������� "���������" ������ ��������, �� � ���� �����
     * ������� ��� ��� ������������� �� �������...
     * ����� �������, �� ������ ���� ���, ����������� ������ ����������
     * ���������, ���� ���� ���������� � �������� ������ ��������, �, -
     * ����������� ���� ���� ����� ������� ��� ��� ������������, ���� ����
     * ������ �� ������� ��������.
     *
     * @return (int) 1 ��� 0 ��� Nothing to do...
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
            // ��������� ������������ ��� � 1000 ��. :)
            $nodeOld->setWeight('1000');
            return DAOFactory::getNodeDAO()->updateFixedPositionUp($nodeNew, $nodeOld);
        } else {
            return 'Nothing to do.';
        }
    }

}
?>

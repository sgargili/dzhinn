<?php

/**
 * А это, скажем так, серверная золушка, которая всегда знает что нужно сделать...
 *
 * @author APopov
 * @date: 2010-05-27
 */
require_once('Response.class.php');

$request = $_REQUEST['request'];
$nid = $_REQUEST['nid'];
$tid = $_REQUEST['tid'];
$name = $_REQUEST['name'];
$pid = $_REQUEST['pid'];
$weight = $_REQUEST['weight'];
$copy = $_REQUEST['copy'];

$response = Response::getInstance();

if ($request == 'getNodes') {
    echo $response->getTreeNodes($tid);
} else if ($request == 'addNode') {
    echo $response->addTreeNode($tid, $name, $pid, $weight);
} else if ($request == 'updateNodeName') {
    echo $response->updateTreeNodeName($nid, $tid, $name);
} else if ($request == 'updateNode') {
    if ($copy == 1) {
        echo $response->addTreeNode($tid, $name, $pid, $weight);
    } else {
        echo $response->updateTreeNodePosition($nid, $tid, $pid, $weight);
    }
} else if ($request == 'deleteNode') {
    echo $response->deleteTreeNode($nid);
} else {
    echo "<b>Я хоть и сказочный персонаж, но не телепат, скажите, что именно хотите?</b> :)";
}
?>

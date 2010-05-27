/**
 * JS. Инициализация дерева.
 *
 * @author APopov
 * @date: 2010-05-27
 */


// Создадим дерево.
$(document).ready(function(){
    // Задел ну будущее, можно менять деревья, функционал это поддерживает.
    var treeId = 4;
    $("div#tree").jstree({
        "xml_data" : {
            "ajax" : {
                "url" : "service/serverella.php?request=getNodes&tid=" + treeId
            }
        },
        "themes" : {
            "theme" : "default",
            "dots" : true,
            "icons" : true
        },
        "contextmenu": {
            items : {
                "create" : {
                    "label" : "Создать",
                    "action" : function (obj) {
                        this.create(obj);
                        $("#log-panel").append("Процесс создания ноды... ");
                    },
                    "separator_before" : false,
                    "separator_after" : true,
                    "icon" : false
                },
                "rename" : {
                    "label" : "Переименовать",
                    "action" : function (obj) {
                        this.rename(obj);
                        $("#log-panel").append("Процесс переименования ноды... ");
                    },
                    "separator_before" : false,
                    "separator_after" : true,
                    "icon" : false
                },
                "remove" : {
                    "label" : "Удалить",
                    "action" : function (obj) {
                        this.remove(obj);
                        $("#log-panel").append("Процесс удаления ноды... ");
                    },
                    "separator_before" : false,
                    "separator_after" : true,
                    "icon" : false
                },
                "ccp" : {
                    "separator_before" : true,
                    "icon" : false,
                    "separator_after" : false,
                    "label" : "Редактирование",
                    "action" : function (obj) {
                    },
                    "submenu" : {
                        "cut" : {
                            "separator_before" : false,
                            "separator_after" : false,
                            "label" : "Вырезать",
                            "action" : function (obj) {
                                this.cut(obj);
                                $("#log-panel").append("Процесс вырезания ноды... ");
                            }
                        },
                        "copy" : {
                            "separator_before" : false,
                            "icon": false,
                            "separator_after" : false,
                            "label" : "Скопировать",
                            "action" : function (obj) {
                                this.copy(obj);
                                $("#log-panel").append("Процесс копирования ноды... ");
                            }
                        },
                        "paste" : {
                            "separator_before" : false,
                            "icon" : false,
                            "separator_after": false,
                            "label" : "Вставить",
                            "action" : function (obj) {
                                this.paste(obj);
                                $("#log-panel").append("Процесс вставки ноды... ");
                            }
                        }
                    }
                }
            }
        },
        "plugins" : [
        "themes",
        "ui",
        "crrm",
        "dnd",
        "contextmenu",
        "xml_data"
        ]
    })
    // Вяжем эвенты на дерево...
    .bind("rename.jstree", function (event, data) {
        if(data.rslt.new_name!=data.rslt.old_name){
            $.post(
                "service/serverella.php",
                {
                    "request" : "updateNodeName",
                    "nid" : data.rslt.obj.attr("id"),
                    "tid" : treeId,
                    "name" : data.rslt.new_name
                },
                function (r) {
                    if(r!=1) {
                        $.jstree.rollback(data.rlbk);
                        $("#log-panel").append("Ошибка, нода не переименована.<br />");
                    } else{
                        $("#log-panel").append("Готово.<br />");
                    }
                }
                );
        } else {
            $("#log-panel").append("Имя ноды не изменилось.<br />");
        }
    })
    .bind("remove.jstree", function (event, data) {
        $.post(
            "service/serverella.php",
            {
                "request" : "deleteNode",
                "nid" : data.rslt.obj.attr("id")
            },
            function (r) {
                if(r!=1) {
                    $("#log-panel").append("Ошибка, нода не удалена.<br />");
                    $.jstree.rollback(data.rlbk);
                } else{
                    $("#log-panel").append("Готово.<br />");
                }
            }
            );
    })
    .bind("create.jstree", function (event, data) {
        $.post(
            "service/serverella.php",
            {
                "request" : "addNode",
                "tid" : treeId,
                "weight" : data.rslt.position,
                "name" : data.rslt.name,
                "pid" : data.rslt.parent == -1 ? 0 : data.rslt.parent.attr("id")
            },
            function (r) {
                if(r!='') {
                    $(data.rslt.obj).attr("id", r);
                    $("#log-panel").append("Готово.<br />");
                }
                else {
                    $.jstree.rollback(data.rlbk);
                    $("#log-panel").append("Ошибка, нода не создана.<br />");
                }
            }
            );
    })
    .bind("move_node.jstree", function (e, data) {
        $.post(
            "service/serverella.php",
            {
                "request" : "updateNode",
                "nid" : data.rslt.o.attr("id"),
                "tid" : treeId,
                "name" : data.rslt.name,
                "pid" : data.rslt.np.attr("id"),
                "weight" : data.rslt.cp,
                "copy" : data.rslt.cy ? 1 : 0
            },
            function (r) {
                // Проверяем, скопирована ли нода...
                if(data.rslt.cy){
                    if(r!='') {
                        $(data.rslt.obj).attr("id", r);
                        $("#log-panel").append("Готово.<br />");
                    }
                    else {
                        $.jstree.rollback(data.rlbk);
                        $("#log-panel").append("Ошибка, нода не создана.<br />");
                    }
                } else {
                    // Проверяем, возвратил ли сервер число...
                    if(!(/\d+/).test(r)){
                        $.jstree.rollback(data.rlbk);
                        $("#log-panel").append("Ошибка, нода не перемещена.<br />");
                    } else{
                        $("#log-panel").append("Готово.<br />");
                    }
                }
            }
            );
    });
}
);
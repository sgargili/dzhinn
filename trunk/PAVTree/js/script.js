/**
 * JS. ������������� ������.
 *
 * @author APopov
 * @date: 2010-05-27
 */


// �������� ������.
$(document).ready(function(){
    // ����� �� �������, ����� ������ �������, ���������� ��� ������������.
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
                    "label" : "�������",
                    "action" : function (obj) {
                        this.create(obj);
                        $("#log-panel").append("������� �������� ����... ");
                    },
                    "separator_before" : false,
                    "separator_after" : true,
                    "icon" : false
                },
                "rename" : {
                    "label" : "�������������",
                    "action" : function (obj) {
                        this.rename(obj);
                        $("#log-panel").append("������� �������������� ����... ");
                    },
                    "separator_before" : false,
                    "separator_after" : true,
                    "icon" : false
                },
                "remove" : {
                    "label" : "�������",
                    "action" : function (obj) {
                        this.remove(obj);
                        $("#log-panel").append("������� �������� ����... ");
                    },
                    "separator_before" : false,
                    "separator_after" : true,
                    "icon" : false
                },
                "ccp" : {
                    "separator_before" : true,
                    "icon" : false,
                    "separator_after" : false,
                    "label" : "��������������",
                    "action" : function (obj) {
                    },
                    "submenu" : {
                        "cut" : {
                            "separator_before" : false,
                            "separator_after" : false,
                            "label" : "��������",
                            "action" : function (obj) {
                                this.cut(obj);
                                $("#log-panel").append("������� ��������� ����... ");
                            }
                        },
                        "copy" : {
                            "separator_before" : false,
                            "icon": false,
                            "separator_after" : false,
                            "label" : "�����������",
                            "action" : function (obj) {
                                this.copy(obj);
                                $("#log-panel").append("������� ����������� ����... ");
                            }
                        },
                        "paste" : {
                            "separator_before" : false,
                            "icon" : false,
                            "separator_after": false,
                            "label" : "��������",
                            "action" : function (obj) {
                                this.paste(obj);
                                $("#log-panel").append("������� ������� ����... ");
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
    // ����� ������ �� ������...
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
                        $("#log-panel").append("������, ���� �� �������������.<br />");
                    } else{
                        $("#log-panel").append("������.<br />");
                    }
                }
                );
        } else {
            $("#log-panel").append("��� ���� �� ����������.<br />");
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
                    $("#log-panel").append("������, ���� �� �������.<br />");
                    $.jstree.rollback(data.rlbk);
                } else{
                    $("#log-panel").append("������.<br />");
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
                    $("#log-panel").append("������.<br />");
                }
                else {
                    $.jstree.rollback(data.rlbk);
                    $("#log-panel").append("������, ���� �� �������.<br />");
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
                // ���������, ����������� �� ����...
                if(data.rslt.cy){
                    if(r!='') {
                        $(data.rslt.obj).attr("id", r);
                        $("#log-panel").append("������.<br />");
                    }
                    else {
                        $.jstree.rollback(data.rlbk);
                        $("#log-panel").append("������, ���� �� �������.<br />");
                    }
                } else {
                    // ���������, ��������� �� ������ �����...
                    if(!(/\d+/).test(r)){
                        $.jstree.rollback(data.rlbk);
                        $("#log-panel").append("������, ���� �� ����������.<br />");
                    } else{
                        $("#log-panel").append("������.<br />");
                    }
                }
            }
            );
    });
}
);
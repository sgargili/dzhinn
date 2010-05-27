<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>Tools4Tree</title>
        <link rel="Stylesheet" href="css/style4tree.css" type="text/css"/>
        <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="js/jquery.jstree.min.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
    </head>

    <body>
        <div id="tree-panel">
            <div class="menu">
                <a href="#" title="Создать"
                   onclick='$("div#tree").jstree("create");
                       $("#log-panel").append("Процесс создания ноды... ");'>
                    <img src="css/pics/create.png" alt=""/>
                </a>
                <a href="#" title="Переименовать"
                   onclick='$("div#tree").jstree("rename");
                       $("#log-panel").append("Процесс переименования ноды... ");'>
                    <img src="css/pics/rename.png" alt=""/>
                </a>
                <a href="#" title="Удалить"
                   onclick='$("div#tree").jstree("remove");
                       $("#log-panel").append("Процесс удаления ноды... ");'>
                    <img src="css/pics/remove.png" alt=""/>
                </a>
                <a href="#" title="Копировать"
                   onclick='$("div#tree").jstree("copy");
                       $("#log-panel").append("Процесс копирования ноды... ");'>
                    <img src="css/pics/copy.png" alt=""/>
                </a>
                <a href="#" title="Вырезать"
                   onclick='$("div#tree").jstree("cut");
                       $("#log-panel").append("Процесс вырезания ноды... ");'>
                    <img src="css/pics/cut.png" alt=""/>
                </a>
                <a href="#" title="Вставить"
                   onclick='$("div#tree").jstree("paste");
                       $("#log-panel").append("Процесс вставки ноды... ");'>
                    <img src="css/pics/paste.png" alt=""/>
                </a>
            </div>
            <div id="tree"></div>
        </div>
        <div id="log-panel">
            Лог:<br/>
        </div>
    </body>

</html>
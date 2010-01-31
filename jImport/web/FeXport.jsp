<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Some Java Tools. (v. 2.0)</title>
        <link rel="stylesheet" type="text/css" href="css/ext-all.css" />
        <link rel="stylesheet" type="text/css" href="css/CenterLayout.css" />
        <link rel="stylesheet" type="text/css" href="css/layout-browser.css">
        <link type="text/css" href="css/ui-darkness/jquery-ui-1.8rc1.custom.css" rel="stylesheet" />
        <%--<script type="text/javascript" src="dojo/dojo/dojo.js" djConfig="parseOnLoad: true, isDebug: false"></script>--%>
        <script type="text/javascript" src="js/ext-base_1.js"></script>
        <script type="text/javascript" src="js/ext-all_1.js"></script>
        <script type='text/javascript' src='js/allJavaScript.js'> </script>
        <script type='text/javascript' src='dwr/engine.js'></script>
        <script type='text/javascript' src='dwr/util.js'></script>
        <script type='text/javascript' src='dwr/interface/Ajax.js'></script>
        <script type='text/javascript' src='dwr/interface/CsvProcessing.js'></script>
        <link id="themeStyles" rel="stylesheet" href="dojo/dijit/themes/tundra/tundra.css">
        <script type="text/javascript" src="js/jquery-1.4.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8rc1.custom.min.js"></script>
        <script type="text/javascript">
            var jq = jQuery.noConflict();
            jq(function() {
                jq("button[name*='button']").button();
            });
            jq(function() {
                jq("div[name*='acord']").accordion({
                    collapsible: true,
                    autoHeight: false,
                    navigation: true
                    
                });
            });
            jq(function() {
                jq("#ruEnOnly").button();
            });
            jq(function() {
                jq("#radioset").buttonset();
            });
        </script>
    </head>
    <body class="tundra" onload="dwr.engine.setActiveReverseAjax(true);">
        <div id="header">
            <table width="100%">
                <tr>
                    <td>
                        <h1>Fast Export and so on...</h1>
                    </td>
                    <td>

                    </td>
                </tr>
            </table>
        </div>
        <div dojoType="dojo.data.ItemFileReadStore" jsId="stateStore" url="data/owners.json">
        </div>
        <div style="display:none;">
            <div id="start-div" style="background-color:#e1e8ff; width:100%; height:100%">
                <div style="padding:50px; font-size:large; color:#000">
                    А-а-а, и так сойдет...
                </div>
                <img style="position:absolute; top:20%; left:20%" src="images/vovka.jpg"/>
            </div>
            <div id="expByProd">
                <div name="acord" id="expByProdInput">
                    <h3 style="color:orange"><a href="#">Экспорт</a></h3>
                    <table id="expProdTable" bgcolor=black cellspacing='1' cellpadding='1' border='0' width='100%'>
                        <tr bgcolor = #e1e1e1 align=left>
                            <td style="padding:7px">
                                <table>
                                    <tr>
                                        <td>
                                            <textarea id='Articles' style='width:350px; height:150px'></textarea>
                                        </td>
                                        <td>
                                        </td>
                                        <td>
                                            <table bgcolor=black cellspacing='1' cellpadding='1' border='0' width='100%'>
                                                <tr bgcolor = #cfcdcd align=left>
                                                    <td>
                                                        <center>
                                                            <table cellspacing='7' cellpadding='0'>
                                                                <tr>
                                                                    <td>
                                                                        <input id='ruEnOnly' type="checkbox"/>
                                                                    </td>
                                                                    <td>
                                                                        <label for="ruEnOnly">ru/en language only...</label>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                            <button name ="button" id="products_importByArticle_button" dojoType="dijit.form.Button" onclick="exportByProduct()">
                                                                &lt;&lt;&lt;Запуск&gt;&gt;&gt;
                                                            </button>
                                                            <button name ="button" id="cache_button" dojoType="dijit.form.Button" onclick="clearCache()">
                                                                &lt;&lt;&lt;Почистить кэш&gt;&gt;&gt;
                                                            </button>
                                                            <button name ="button" id="statistics_button" dojoType="dijit.form.Button" onclick="showStatistics()">
                                                                &lt;&lt;&lt;Статистика&gt;&gt;&gt;
                                                            </button>
                                                            <button name ="button" id="button" style="height:30px">
                                                                Button
                                                            </button>
                                                        </center>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </div>
                <br/>
                <div name="acord" id="expProdLogs">
                    <h1><a href="#">Логи сервера:</a></h1>
                    <ul id="ulexpProdLog" style="min-height:350px">
                    </ul>
                </div>
            </div>
            <div id="expMark">
                <div name="acord" id="expMarkInput">
                    <h3><a href="#">Экспорт маркетинга</a></h3>
                    <table id="expMarkTable" bgcolor=black cellspacing='1' cellpadding='1' border='0' width='100%'>
                        <tr bgcolor = #e1e1e1 align=left>
                            <td style="padding:7px">
                                <table>
                                    <tr>
                                        <td>
                                            <textarea id='ArticlesExpMark' style='width:350px; height:150px'></textarea>
                                        </td>
                                        <td>
                                        </td>
                                        <td>
                                            <table bgcolor=black cellspacing='1' cellpadding='1' border='0' width='100%'>
                                                <tr bgcolor = #cfcdcd align=left>
                                                    <td>
                                                        <center>
                                                            <button name ="button" id="products_importMark_button" onclick="exportMarketing()">
                                                                &lt;&lt;&lt;Запуск&gt;&gt;&gt;
                                                            </button>
                                                            <button name ="button" id="cache_Mark_button" onclick="clearCacheMark()">
                                                                &lt;&lt;&lt;Почистить кэш&gt;&gt;&gt;
                                                            </button>
                                                        </center>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </div>
                <br/>
                <div name="acord" id="expMarkLogs">
                    <h3><a href="#">Логи сервера:</a></h3>
                    <ul id="ulexpMarkLog" style="min-height:350px">
                    </ul>
                </div>
            </div>
            <div id="chat_id">
                <div name="acord">
                    <h3><a href="#">Чат</a></h3>
                    <div id="AllDialog_chat_id">
                        <p>
                            Текст:
                            <input id="text" onkeypress="dwr.util.onReturn(event, sendMessage)" style="width:450px"/>
                            <button name ="button" onclick="sendMessage()">Send
                            </button>
                            Ник:
                            <input id="nick_id" value="Введите ник..."/>
                        </p>
                    </div>

                </div>
                <br/>
                <div name="acord">
                    <h3><a href="#">Логи</a></h3>
                    <div id="chat_id_log">
                        <ul id="chat_id_ul" style="list-style-type:none; min-height:350px">Типа чат...</ul>
                    </div>
                </div>
            </div>
            <div id="statusChange">
                <div name="acord" id="statusChangeInput">
                    <h3><a href="#">Смена статуса</a></h3>
                    <table id="statusChangeTable" bgcolor=black cellspacing='1' cellpadding='1' border='0' width='100%'>
                        <tr bgcolor = #e1e1e1 align=left>
                            <td style="padding:7px">
                                <table>
                                    <tr>
                                        <td>
                                            <textarea id='ArticlesStatusChange' style='width:350px; height:150px'></textarea>
                                        </td>
                                        <td>
                                        </td>
                                        <td>
                                            <table bgcolor=black cellspacing='1' cellpadding='1' border='0' width='100%'>
                                                <tr bgcolor = #cfcdcd align=left>
                                                    <td>
                                                        <div id="radioset">
                                                            <input type="radio" name="status" id="statusOne" checked value="Research" />
                                                            <label for="statusOne">
                                                                Research
                                                            </label>
                                                            <input type="radio" name="status" id="statusTwo"
                                                                   value="Control" />
                                                            <label for="statusTwo">
                                                                Control
                                                            </label>
                                                            <input type="radio" name="status" id="statusThree"
                                                                   value="Done" />
                                                            <label for="statusThree">
                                                                Done
                                                            </label>
                                                        </div>
                                                        <center>
                                                            <button id="statusChange_button" name="button" onclick="changeStatus()">
                                                                &lt;&lt;&lt;Запуск&gt;&gt;&gt;
                                                            </button>
                                                        </center>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </div>
                <br/>
                <div name="acord" id="statusChangeLogs">
                    <h3><a href="#">Логи сервера:</a></h3>
                    <ul id="ulstatusChangeLog" style="min-height:350px">
                    </ul>
                </div>
            </div>
            <div id="ownerChange">
                <div name="acord" id="ownerChangeInput">
                    <h3><a href="#">Смена автора</a></h3>
                    <table id="ownerChangeTable" bgcolor=black cellspacing='1' cellpadding='1' border='0' width='100%'>
                        <tr bgcolor = #e1e1e1 align=left>
                            <td style="padding:7px">
                                <table>
                                    <tr>
                                        <td>
                                            <textarea id='ArticlesOwnerChange' style='width:350px; height:150px'></textarea>
                                        </td>
                                        <td>
                                        </td>
                                        <td>
                                            <table bgcolor=black cellspacing='1' cellpadding='1' border='0' width='100%'>
                                                <tr bgcolor = #cfcdcd align=left>
                                                    <td>
                                                        <table cellspacing='7' cellpadding='0'>
                                                            <tr>
                                                                <td>
                                                                    <input dojoType="dijit.form.FilteringSelect" store="stateStore" value="60511120540229999"
                                                                           searchAttr="name" id="owner"/>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                        <center>
                                                            <button id="ownerChange_button" name="button" onclick="changeOwner()">
                                                                &lt;&lt;&lt;Запуск&gt;&gt;&gt;
                                                            </button>
                                                        </center>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </div>
                <br/>
                <div name="acord" id="ownerChangeLogs">
                    <h3><a href="#">Логи сервера:</a></h3>
                    <ul id="ulownerChangeLog" style="min-height:350px">
                    </ul>
                </div>
            </div>
            <div id="addLink">
                <div name="acord" id="addLinkInput">
                    <h3><a href="#">Добавление ссылок. Вводить только артикли, айдишники артиклей не пройдут...</a></h1>
                        <table id="addLinkTable" bgcolor=black cellspacing='1' cellpadding='1' border='0' width='100%'>
                            <tr bgcolor = #e1e1e1 align=left>
                                <td style="padding:7px">
                                    <table>
                                        <tr>
                                            <td>
                                                <textarea id='ArticlesAddLink' style='width:700px; height:150px'></textarea>
                                            </td>
                                            <td>
                                            </td>
                                            <td>
                                                <table bgcolor=black cellspacing='1' cellpadding='1' border='0' width='100%'>
                                                    <tr bgcolor = #cfcdcd align=left>
                                                        <td>
                                                            <center>
                                                                <button id="addLink_button" name="button" onclick="addLink()">
                                                                    &lt;&lt;&lt;Запуск&gt;&gt;&gt;
                                                                </button>
                                                            </center>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                </div>
                <br/>
                <div name="acord" id="addLinkLogs">
                    <h3><a href="#">Логи сервера:</a></h3>
                    <ul id="uladdLinkLog" style="min-height:350px">
                    </ul>
                </div>
            </div>
            <div id="optSes">
                <div name="acord" id="optSesInput">
                    <h3><a href="#">Сброс сессии.</a></h3>
                    <table id="ownerChangeTable" bgcolor=black cellspacing='1' cellpadding='1' border='0' width='100%'>
                        <tr bgcolor = #e1e1e1 align=left>
                            <td style="padding:7px">
                                <table>
                                    <tr>
                                        <td>
                                            <table bgcolor=black cellspacing='1' cellpadding='1' border='0' width='100%'>
                                                <tr bgcolor = #cfcdcd align=left>
                                                    <td>
                                                        <center>
                                                            <button id="optSes_button" name="button" onclick="clearSession()">
                                                                &lt;&lt;&lt;Сброс&gt;&gt;&gt;
                                                            </button>
                                                        </center>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td>
                                            <div id="uloptSesLog"></div>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            <div id ="eCsv">
                <div id="AllDialog_eCsv">
                    <table id="TableeCsv" bgcolor=black align ="center" cellspacing='1' cellpadding='1' border='0' width='100%'>
                        <tr bgcolor = #e1e1e1 align=left>
                            <td>
                                <table>
                                    <tr>
                                        <td>
                                            <table>
                                                <tr>
                                                    <td>
                                                        <font color="black" size="1">Encoding:</font>
                                                    </td>
                                                    <td>
                                                        <select id="eCsvEncoding" dojoType="dijit.form.FilteringSelect" style="width:100px">
                                                            <option value="WINDOWS-1251">ANSI
                                                            <option value="UTF-8">UTF-8
                                                        </select>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td>
                                            <table>
                                                <tr>
                                                    <td>
                                                        <font color="black" size="1">Only separator(CSV):</font>
                                                    </td>
                                                    <td>
                                                        <input type="checkbox" id="eCsvSeparator" dojoType="dijit.form.CheckBox" checked="true">
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td>
                                            <table>
                                                <tr>
                                                    <td>
                                                        <font color="black" size="1">Compress to Zip:</font>
                                                    </td>
                                                    <td>
                                                        <input type="checkbox" id="eCsvZip" dojoType="dijit.form.CheckBox">
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td>
                                            <table>
                                                <tr>
                                                    <td>
                                                        <font color="black" size="1">Engine:</font>
                                                    </td>
                                                    <td>
                                                        <select id="eCsvEngine" dojoType="dijit.form.FilteringSelect" style="width:120px">
                                                            <option value="Apache POI">Apache POI
                                                            <option value="Jexcel">Jexcel
                                                        </select>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td>
                                            <font color="black" size="1">Upload XLS or CSV File:</font>
                                        </td>
                                        <td>
                                            <input type="file" id="uploadFileeCsv"/>
                                        </td>
                                        <td>
                                            <button onclick="UploadeCsv()" name="button">Convert</button>
                                        </td>
                                        <td>
                                            <div id="eCsvLoadingProcess">
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr bgcolor = #cfcdcd align=left>
                            <td>
                                <table>
                                    <tr>
                                        <td>
                                            <font color="black" size="1">Fix It4Profit CSV File:</font>
                                        </td>
                                        <td>
                                            <input type="file" id="uploadit4profitCsv"/>
                                        </td>
                                        <td>
                                            <button onclick="FixProfitCsv()" name="button">Fix</button>
                                        </td>
                                        <td>
                                            <div id="it4profitCsvLoadingProcess">
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                    <%--<div id="Updating" align="right"></div>--%>
                </div>
            </div>
            <div id="vExp-details">
                <div class="details-info"><b>Экспорт</b>. Формат - список <b>артиклей</b> или <b>айдишников артиклей</b> (но не в перемешку).</div>
            </div>
            <div id="eCsv-details">
                <div class="details-info"><b>Преобразование форматов файлов</b>...</div>
            </div>
            <div id="vStat-details">
                <div class="details-info"><b>Смена авторов и статусов</b>. Формат - список <b>артиклей</b> или <b>айдишников артиклей</b>(но не в перемешку).</div>
            </div>
            <div id="vLink-details">
                <div class="details-info"><b>Добавление ссылок к артиклям</b>. Формат - список <b>артиклей, типов ссылок и ссылок</b>(разделитель между артиклем, типом и ссылкой - <b>табуляция</b>).</div>
            </div>
            <div id="oSes-details">
                <div class="details-info"><b>Сброс сессии. Применять только когда не срабатывает какая-либо процедура по работе с Value4IT</b>...</div>
            </div>
            <div id="eChat-details">
                <div class="details-info"><b>Простенький Ajax чат</b>...</div>
            </div>
        </div>
    </body>
</html>
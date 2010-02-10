<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.FactoryDAO"%>
<%@page import="Pojo.Users"%>
<%
            Users user;
            user = FactoryDAO.getInstance().getUsersDAO().getUserByIp(request.getRemoteHost());
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <%--<meta http-equiv="X-UA-Compatible" content="IE=7" />--%>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Some Java Tools. (v.2.1)</title>
        <link rel="stylesheet" type="text/css" href="css/ext-all.css" />
        <link rel="stylesheet" type="text/css" href="css/CenterLayout.css" />
        <link rel="stylesheet" type="text/css" href="css/layout-browser.css"/>
        <%--<script type="text/javascript" src="dojo/dojo/dojo.js" djConfig="parseOnLoad: true, isDebug: false"></script>--%>
        <script type="text/javascript" src="js/ext-base.js"></script>
        <script type="text/javascript" src="js/ext-all.js"></script>
        <script type='text/javascript' src='js/allJavaScript.js'> </script>
        <script type='text/javascript' src='dwr/engine.js'></script>
        <script type='text/javascript' src='dwr/util.js'></script>
        <script type='text/javascript' src='dwr/interface/Ajax.js'></script>
        <script type='text/javascript' src='dwr/interface/CsvProcessing.js'></script>
        <%--<link id="themeStyles" rel="stylesheet" href="dojo/dijit/themes/tundra/tundra.css"/>--%>
        <%--<script src="js/IE82.js" type="text/javascript"></script>--%>
    </head>
    <body onload="dwr.engine.setActiveReverseAjax(true);">
        <div id="header">
            <table width="100%">
                <tr>
                    <td width="30%">
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
                <%--<img style="position:absolute; top:20%; left:20%" src="images/vovka.jpg"/>--%>
            </div>
            <div id="expByProd">
                <div id="expByProdInput">
                    <%--<h1 style="color:orange">Экспорт</h1>--%>
                    <table id="expProdTable" bgcolor=black cellspacing='0' cellpadding='0' border='0' width='100%'>
                        <tr bgcolor = #e1e1e1 align=left>
                            <td style="padding:7px"> 
                                <table>
                                    <tr>
                                        <td>
                                            <textarea id='Articles' style='width:350px; height:150px;'></textarea>
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
                                                                        <input id='ruEnOnly' dojoType='dijit.form.CheckBox'/>
                                                                    </td>
                                                                    <td>
                                                                        <label for="ruEnOnly">ru/en language only...</label>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                            <button id="products_importByArticle_button" dojoType="dijit.form.Button">
                                                                &lt;&lt;&lt;Запуск&gt;&gt;&gt;
                                                            </button>
                                                            <button id="cache_button" dojoType="dijit.form.Button" onclick="clearCache()">
                                                                &lt;&lt;&lt;Почистить кэш&gt;&gt;&gt;
                                                            </button>
                                                            <button id="statistics_button" dojoType="dijit.form.Button" onclick="showStatistics()">
                                                                &lt;&lt;&lt;Статистика&gt;&gt;&gt;
                                                            </button>
                                                        </center>
                                                        <%--<div id="tableTT">222</div>--%>
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
                <div id="expProdLogs" style="background-color: #e1e1e1;">
                    <br/>
                    <div id="ulexpProdLog" style="min-height:350px">
                    </div>
                    <br/>
                </div>
            </div>
            <div id="expMark">
                <div id="expMarkInput">
                    <%--<h1 style="color:orange">Экспорт маркетинга</h1>--%>
                    <table id="expMarkTable" bgcolor=black cellspacing='0' cellpadding='0' border='0' width='100%'>
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
                                                            <button id="products_importMark_button" dojoType="dijit.form.Button" onclick="exportMarketing()">
                                                                &lt;&lt;&lt;Запуск&gt;&gt;&gt;
                                                            </button>
                                                            <button id="cache_Mark_button" dojoType="dijit.form.Button" onclick="clearCacheMark()">
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
                <div id="expMarkLogs" style="background-color: #e1e1e1">
                    <br/>
                    <div id="ulexpMarkLog" style="min-height:350px">
                    </div>
                    <br/>
                </div>
            </div>
            <div id="chat_id">
                <div dojoType="dijit.TooltipDialog" id="AllDialog_chat_id">
                    <p>
                        Текст:
                        <input id="text" onkeypress="dwr.util.onReturn(event, sendMessage)" style="width:550px"/>
                        <input id="chat_btn" type="button" value="Send" onclick="sendMessage()"/>
                        Ник:
                        <input id="nick_id" value="<% try {
                out.print(user.getNick());
            } catch (Exception ex) {
                out.print("Введите ник...");
            }%>"/>
                    </p>
                </div>
                <br/>
                <div dojoType="dijit.TooltipDialog" id="chat_id_log">
                    <ul id="chat_id_ul" style="list-style-type:none;min-height:490px">Типа чат...</ul>
                </div>
            </div>
            <div id="statusChange">
                <div id="statusChangeInput">
                    <table id="statusChangeTable" bgcolor=black cellspacing='0' cellpadding='0' border='0' width='100%'>
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
                                                        <table cellspacing='7' cellpadding='0'>
                                                            <tr>
                                                                <td>
                                                                    <input type="radio" dojoType="dijit.form.RadioButton" name="status" id="statusOne" checked value="Research" />
                                                                    <label for="statusOne">
                                                                        Research
                                                                    </label>
                                                                </td>
                                                                <td>
                                                                    <input type="radio" dojoType="dijit.form.RadioButton" name="status" id="statusTwo"
                                                                           value="Control" />
                                                                    <label for="statusTwo">
                                                                        Control
                                                                    </label>
                                                                </td>
                                                                <td>
                                                                    <input type="radio" dojoType="dijit.form.RadioButton" name="status" id="statusThree"
                                                                           value="Done" />
                                                                    <label for="statusThree">
                                                                        Done
                                                                    </label>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                        <center>
                                                            <button id="statusChange_button" dojoType="dijit.form.Button" onclick="changeStatus()">
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
                <div id="statusChangeLogs" style="background-color: #e1e1e1">
                    <br/>
                    <div id="ulstatusChangeLog" style="min-height:350px">
                    </div>
                    <br/>
                </div>
            </div>
            <div id="ownerChange">
                <div id="ownerChangeInput">
                    <table id="ownerChangeTable" bgcolor=black cellspacing='0' cellpadding='0' border='0' width='100%'>
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
                                                            <button id="ownerChange_button" dojoType="dijit.form.Button" onclick="changeOwner()">
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
                <div id="ownerChangeLogs" style="background-color: #e1e1e1">
                    <br/>
                    <div id="ulownerChangeLog" style="min-height:350px">
                    </div>
                    <br/>
                </div>
            </div>
            <div id="addLink">
                <div id="addLinkInput">
                    <%--<h1 style="color:orange">Добавление ссылок. Вводить только артикли, айдишники артиклей не пройдут...</h1>--%>
                    <table id="addLinkTable" bgcolor=black cellspacing='0' cellpadding='0' border='0' width='100%'>
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
                                                            <button id="addLink_button" dojoType="dijit.form.Button" onclick="addLink()">
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
                <div id="addLinkLogs" style="background-color: #e1e1e1">
                    <br/>
                    <div id="uladdLinkLog" style="min-height:350px">
                    </div>
                    <br/>
                </div>
            </div>
            <div id="optSes">
                <div id="optSesInput">
                    <%--<h1 style="color:orange">Сброс сессии.</h1>--%>
                    <table id="ownerChangeTable" bgcolor=black cellspacing='0' cellpadding='0' border='0' width='100%'>
                        <tr bgcolor = #e1e1e1 align=left>
                            <td style="padding:7px">
                                <table>
                                    <tr>
                                        <td>
                                            <table bgcolor=black cellspacing='1' cellpadding='1' border='0' width='100%'>
                                                <tr bgcolor = #cfcdcd align=left>
                                                    <td>
                                                        <center>
                                                            <button id="optSes_button" dojoType="dijit.form.Button" onclick="clearSession()">
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
                <div dojoType="dijit.TooltipDialog" id="AllDialog_eCsv">
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
                                            <button onclick="UploadeCsv()" dojoType="dijit.form.Button">Convert</button>
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
                                            <button onclick="FixProfitCsv()" dojoType="dijit.form.Button">Fix</button>
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
                    <h1 id="Updating" align="right"></h1>
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
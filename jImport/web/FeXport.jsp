<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Some Java Tools. (v. 1.0)</title>
        <link rel="stylesheet" type="text/css" href="css/ext-all.css" />
        <link rel="stylesheet" type="text/css" href="css/CenterLayout.css" />
        <link rel="stylesheet" type="text/css" href="css/layout-browser.css">
        <%--<link rel="stylesheet" type="text/css" href="css/FileInput.css">--%>
        <script type="text/javascript" src="dojo/dojo/dojo.js" djConfig="parseOnLoad: true, isDebug: false"></script>
        <script type="text/javascript" src="js/ext-base_1.js"></script>
        <script type="text/javascript" src="js/ext-all_1.js"></script>
        <script type="text/javascript" src="js/CenterLayout_1.js"></script>
        <script type="text/javascript" src="js/RowLayout_1.js"></script>
        <script type="text/javascript" src="js/basic_1.js"></script>
        <script type="text/javascript" src="js/custom_1.js"></script>
        <script type="text/javascript" src="js/combination_1.js"></script>
        <script type="text/javascript" src="js/layout-browser_1.js"></script>
        <script type='text/javascript' src='js/Xport_1.js'> </script>
        <%--<script type="text/javascript" src="js/progress-bar_1.js"></script>--%>
        <script type='text/javascript' src='dwr/engine.js'></script>
        <script type='text/javascript' src='dwr/util.js'></script>
        <script type='text/javascript' src='dwr/interface/Ajax.js'></script>
        <script type='text/javascript' src='dwr/interface/CsvProcessing.js'></script>
        <link id="themeStyles" rel="stylesheet" href="dojo/dijit/themes/tundra/tundra.css">
        <link id="themeStyles" rel="stylesheet" href="css/Xport.css">
    </head>
    <body class="tundra" onload="dwr.engine.setActiveReverseAjax(true);">
        <div id="header">
            <table width="100%">
                <tr>
                    <td>
                        <h1>Fast Export</h1>
                    </td>
                    <td>

                    </td>
                </tr>
            </table>
        </div>
        <div style="display:none;">
            <div id="start-div" style="background-color:#e1e8ff; width:100%; height:100%">
                <div style="padding:50px; font-size:large; color:#000">
                    А-а-а, и так сойдет...
                </div>
                <img style="position:absolute; top:20%; left:20%" src="images/vovka.jpg"/>
            </div>
            <div id="expByProd">
                <div dojoType="dijit.TooltipDialog" id="expByProdInput">
                    <h1 style="color:orange">Экспорт</h1>
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
                                                                        <input id='ruEnOnly' dojoType='dijit.form.CheckBox'/>
                                                                    </td>
                                                                    <td>
                                                                        <label for="ruEnOnly">ru/en language only...</label>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                            <button id="products_importByArticle_button" dojoType="dijit.form.Button" onclick="exportByProduct()">
                                                                &lt;&lt;&lt;Запуск&gt;&gt;&gt;
                                                            </button>
                                                            <button id="cache_button" dojoType="dijit.form.Button" onclick="clearCache()">
                                                                &lt;&lt;&lt;Почистить кэш&gt;&gt;&gt;
                                                            </button>
                                                            <button id="statistics_button" dojoType="dijit.form.Button" onclick="showStatistics()">
                                                                &lt;&lt;&lt;Статистика&gt;&gt;&gt;
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
                <div dojoType="dijit.TooltipDialog" id="expProdLogs" style="text-align:left; overflow:visible scroll">
                    <h1 style="color:orange; text-decoration:underline">Логи сервера:</h1>
                    <br/>
                    <ul id="ulexpProdLog" style="min-height:350px">
                    </ul>
                </div>
            </div>
            <div id="expMark">
                <div dojoType="dijit.TooltipDialog" id="expMarkInput">
                    <h1 style="color:orange">Экспорт маркетинга</h1>
                    <table id="expMarkTable" bgcolor=black cellspacing='1' cellpadding='1' border='0' width='100%'>
                        <tr bgcolor = #e1e1e1 align=left>
                            <td style="padding:7px">
                                <table>
                                    <tr>
                                        <td>
                                            <textarea id='ArticlesExpMark' style='width:550px; height:150px'></textarea>
                                        </td>
                                        <td>
                                        </td>
                                        <td>
                                            <table bgcolor=black cellspacing='1' cellpadding='1' border='0' width='100%'>
                                                <tr bgcolor = #cfcdcd align=left>
                                                    <td>
                                                        <%--          <table cellspacing='7' cellpadding='0'>
                                                                      <tr>
                                                                          <td>
                                                                              <input id='ruEnOnlyExpMark' dojoType='dijit.form.CheckBox'/>
                                                                          </td>
                                                                          <td>
                                                                              <label for="ruEnOnlyExpMark">ru/en language only...</label>
                                                                          </td>
                                                                      </tr>
                                                                  </table>--%>
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
                <div dojoType="dijit.TooltipDialog" id="expMarkLogs" style="text-align:left; overflow:visible scroll">
                    <h1 style="color:orange; text-decoration:underline">Логи сервера:</h1>
                    <br/>
                    <ul id="ulexpMarkLog" style="min-height:350px">
                    </ul>
                </div>
            </div>
            <div id="statusChange">
                <div dojoType="dijit.TooltipDialog" id="statusChangeInput">
                    <h1 style="color:orange">Смена статуса</h1>
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
                <div dojoType="dijit.TooltipDialog" id="statusChangeLogs" style="text-align:left; overflow:visible scroll">
                    <h1 style="color:orange; text-decoration:underline">Логи сервера:</h1>
                    <br/>
                    <ul id="ulstatusChangeLog" style="min-height:350px">
                    </ul>
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
                <h2 class="details-info">Экспорт в системе Content Factory</h2>
            </div>
            <div id="eCsv-details">
                <h2 class="details-info">Преобразование форматов файлов...</h2>
            </div>
        </div>
    </body>
</html>
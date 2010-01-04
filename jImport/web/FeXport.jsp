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
        <script type="text/javascript" src="js/progress-bar_1.js"></script>
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
        <div id="treeUpdateStatus" style="display:none">
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
                                            <textarea id='Articles' style='width:550px; height:150px'></textarea>
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
                                                                    <input id='ruEnOnly' dojoType='dijit.form.CheckBox'/>
                                                                </td>
                                                                <td>
                                                                    <label for="ruEnOnly">ru/en language only...</label>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                        <center>
                                                            <button id="products_importByArticle_button" dojoType="dijit.form.Button" onclick="exportByProduct()">
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
                <div dojoType="dijit.TooltipDialog" id="expProdLogs" style="text-align:left; overflow:visible scroll">
                    <h1 style="color:orange; text-decoration:underline">Логи сервера:</h1>
                    <br/>
                    <ul id="ulexpProdLog" style="min-height:350px">
                    </ul>
                </div>
            </div>
            <div id="expMark">
                <div dojoType="dijit.TooltipDialog" id="AllDialogproducts_import">
                    <h1 style="color:orange">Импорт по всем артиклям.</h1>
                    <table id="Tableproducts_import" bgcolor=black cellspacing='1' cellpadding='1' border='0' width='100%'>
                        <tr bgcolor = #cfcdcd align=left>
                            <td>
                                <table>
                                    <tr>
                                        <td>
                                            <font color="white" size="2">Обновить все продукты:</font>
                                        </td>
                                        <td>
                                            <button id="products_import_button" dojoType="dijit.form.Button" onclick="ImportAllProducts()">
                                                &lt;&lt;&lt;Запуск&gt;&gt;&gt;
                                            </button>
                                        </td>
                                        <td>
                                            <font color="white" size="2">Autoname:</font>
                                        </td>
                                        <td>
                                            <input id='productsAn' dojoType='dijit.form.CheckBox' checked/>
                                        </td>
                                        <td>
                                            <font color="white" size="2">Card:</font>
                                        </td>
                                        <td>
                                            <input id='productsCd' dojoType='dijit.form.CheckBox' checked/>
                                        </td>
                                        <td>
                                            <font color="white" size="2">Логи сервера:</font>
                                        </td>
                                        <td>
                                            <input id='productsSLC' dojoType='dijit.form.CheckBox' onclick="ProductsServerLogView()"/>
                                        </td>
                                        <td>
                                        </td>
                                        <td>
                                            <font color="white" size="2">Статус обновления:</font>
                                        </td>
                                        <td>
                                        </td>
                                        <td>
                                            <font color="green" size="2" id="productsUpdateStatus"></font>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </div>
                <div dojoType="dijit.TooltipDialog" id="logs_products_import" style="text-align:left; visibility:hidden; overflow:visible scroll">
                    <h1 style="color:orange; text-decoration:underline">Логи сервера:</h1>
                    <ul id="ulProductsLog" style="min-height:250px">
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
                                                        <font color="black" size="2">Encoding:</font>
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
                                                        <font color="black" size="2">Only separator(CSV):</font>
                                                    </td>
                                                    <td>
                                                        <input type="checkbox" id="eCsvSeparator" dojoType="dijit.form.CheckBox">
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td>
                                            <table>
                                                <tr>
                                                    <td>
                                                        <font color="black" size="2">Compress to Zip:</font>
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
                                                        <font color="black" size="2">Engine:</font>
                                                    </td>
                                                    <td>
                                                        <select id="eCsvEngine" dojoType="dijit.form.FilteringSelect" style="width:120px">
                                                            <option value="Jexcel">Jexcel
                                                            <option value="Apache POI">Apache POI
                                                        </select>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td>
                                            <font color="black" size="2">Upload XLS or CSV File:</font>
                                        </td>
                                        <td>
                                            <input type="file" id="uploadFileeCsv"/>
                                        </td>
                                        <td>
                                            <button onclick="UploadeCsv()">Convert</button>
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
                                            <font color="black" size="2">Fix It4Profit CSV File:</font>
                                        </td>
                                        <td>
                                            <input type="file" id="uploadit4profitCsv"/>
                                        </td>
                                        <td>
                                            <button onclick="FixProfitCsv()">Fix</button>
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
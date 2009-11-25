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
        <script type="text/javascript" src="js/ext-base.js"></script>
        <script type="text/javascript" src="js/ext-all.js"></script>
        <script type="text/javascript" src="js/CenterLayout.js"></script>
        <script type="text/javascript" src="js/RowLayout.js"></script>
        <script type="text/javascript" src="js/basic.js"></script>
        <script type="text/javascript" src="js/custom.js"></script>
        <script type="text/javascript" src="js/combination.js"></script>
        <script type="text/javascript" src="js/layout-browser.js"></script>
        <script type='text/javascript' src='js/Xport.js'> </script>
        <script type="text/javascript" src="js/progress-bar.js"></script>
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
                        <h1>Набор утилит для работы с шопом StoneAxe.ru</h1>
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
            <div id="trees_import">
                <div dojoType="dijit.TooltipDialog" id="AllDialog_trees_import">
                    <h1 style="color:orange">Импорт дерева.</h1>
                    <table id="Tableetrees_import" bgcolor=black cellspacing='1' cellpadding='1' border='0' width='100%'>
                        <tr bgcolor = #cfcdcd align=left>
                            <td>
                                <table>
                                    <tr>
                                        <td>
                                            <font color="white" size="2">Обновить дерево:</font>
                                        </td>
                                        <td>
                                            <button id="trees_import_button" dojoType="dijit.form.Button" onclick="ImportTree()">
                                                &lt;&lt;&lt;Запуск&gt;&gt;&gt;
                                            </button>
                                        </td>
                                        <td>
                                            <font color="white" size="2">Логи сервера:</font>
                                        </td>
                                        <td>
                                            <input id='treeSLC' value='All' dojoType='dijit.form.CheckBox' onClick="TreeServerLogView()"/>
                                        </td>
                                        <td>
                                        </td>
                                        <td>
                                            <font color="white" size="2">Статус обновления:</font>
                                        </td>
                                        <td>
                                        </td>
                                        <td>
                                            <font color="green" size="2" id="treeUpdateStatus"></font>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </div>
                <br/>
                <div dojoType="dijit.TooltipDialog" id="logs_trees_import" style="text-align:left; visibility:hidden; overflow:visible scroll">
                    <h1 style="color:orange; text-decoration:underline">Логи сервера:</h1>
                    <ul id="ulTreesLog" style="min-height:250px">
                    </ul>
                </div>
            </div>
            <div id="products_import">
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
                <br/>
                <div dojoType="dijit.TooltipDialog" id="products_importByArticle">
                    <h1 style="color:orange">Импорт по артиклям.</h1>
                    <table id="Tableproducts_import" bgcolor=black cellspacing='1' cellpadding='1' border='0' width='100%'>
                        <tr bgcolor = #cfcdcd align=left>
                            <td style="padding:7px">
                                <table>
                                    <tr>
                                        <td>
                                            <textarea id='Articles' style='width:450px; height:150px'></textarea>
                                        </td>
                                        <td>
                                            <table bgcolor=black cellspacing='1' cellpadding='1' border='0' width='100%'>
                                                <tr bgcolor = #cfcdcd align=left>
                                                    <td>
                                                        <table>
                                                            <tr>
                                                                <td>
                                                                    <font color="white" size="2">Autoname:</font>
                                                                </td>
                                                                <td>
                                                                    <input id='productsByArticleAn' dojoType='dijit.form.CheckBox' checked/>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                    <font color="white" size="2">Card:</font>
                                                                </td>
                                                                <td>
                                                                    <input id='productsByArticleCd' dojoType='dijit.form.CheckBox' checked/>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                        <button id="products_importByArticle_button" dojoType="dijit.form.Button">
                                                            &lt;&lt;&lt;Запуск&gt;&gt;&gt;
                                                        </button>
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
                <div dojoType="dijit.TooltipDialog" id="logs_products_import" style="text-align:left; visibility:hidden; overflow:visible scroll">
                    <h1 style="color:orange; text-decoration:underline">Логи сервера:</h1>
                    <ul id="ulProductsLog" style="min-height:250px">
                    </ul>
                </div>
            </div>
            <div id="images_import">

            </div>
            <div id="add_import">
                <div dojoType="dijit.TooltipDialog" id="AllDialog_add_import">
                    <p>
                        Введите чё-нить:
                        <input id="text" onkeypress="dwr.util.onReturn(event, sendMessage)"/>
                        <input type="button" value="Send" onclick="sendMessage()"/>
                    </p>
                </div>
                <br/>
                <div dojoType="dijit.TooltipDialog" id="AllDialog_add_import_log">
                    <ul id="xxxsss" style="list-style-type:none;">Типа чат...</ul>
                </div>
            </div>
            <div id="Yandex_Comporator" style="background-color:#e1e8ff; width:100%; height:100%">
                <div dojoType="dijit.TooltipDialog" id="AllDialog_Yandex">
                    <table id="TableYandex" bgcolor=black cellspacing='1' cellpadding='1' border='0' width='100%'>
                        <tr bgcolor = #cfcdcd align=left>
                            <td>
                                <table>
                                    <tr>
                                        <td>
                                            <font color="white" size="2">Тип загрузки:</font>
                                        </td>
                                        <td>
                                            <select id="yandexType" dojoType="dijit.form.FilteringSelect" style="width:170px" onchange="ShowYandexFile()">
                                                <option value="file">Загрузить из файла
                                                <option value="base">Загрузить из базы
                                            </select>
                                        </td>
                                        <td style="display:inline" id="tduploadYandexFile">
                                            <input type="file" id="uploadYandexFile"/>
                                        </td>
                                        <td>
                                            <button onclick="">Загрузить/Обновить</button>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>          
            <div id="www">
                <input type="button" onclick="Manufacturer()" value="Посмареть всех!"/>
                <input id="manId" type="text"/><input id="manName" type="text"><input type="button" onclick="ManufacturerAdd()" value="Добавить нового!"/>
                <div id = "Manufac">
                </div>
            </div>
            <div id="EEE">
                <div dojoType="dijit.TooltipDialog" id="AllDialog_Supp">
                    <table id="TableSuppl" bgcolor=black align=center cellspacing='1' cellpadding='1' border='0' width='10%'>
                        <tr bgcolor = #cfcdcd align=center>
                            <td> 
                                <table>
                                    <tr>
                                        <td>
                                            <font color="white" size="2">Supplier:</font>
                                        </td>
                                        <td>
                                            <div id="SupplSelect"></div>
                                        </td>
                                        <td>
                                            <font color="white" size="2">Article:</font>
                                        </td>
                                        <td>
                                            <input id="SupplArticle" dojoType=dijit.form.TextBox type="text"/>
                                        </td>
                                        <td>
                                            <button onclick="searchAllSuppliers()">Search</button>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                            <td>
                                <table>
                                    <tr>
                                        <td>
                                            <input id="SupplNew" dojoType=dijit.form.TextBox type="text"/>
                                        </td>
                                        <td>
                                            <button onclick="addNewSupplier()">Add New Supplier</button>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                            <td>
                                <table>
                                    <tr>
                                        <td>
                                            <font color="white" size="2">Add Price File:</font>
                                        </td>
                                        <td>
                                            <input type="file" id="uploadFile"/>
                                        </td>
                                        <td>
                                            <button onclick="uploadFile()">Upload</button>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </div>
                <br/>
                <div dojoType="dijit.TooltipDialog" id="AllDialog_Suppliers_Out_All">
                    <p align="center" id="AllDialog_Suppliers_Out">
                        You shoud specify Supplier and press 'Search' button.
                    </p>
                </div>
            </div>
            <div id ="eCsv">
                <div dojoType="dijit.TooltipDialog" id="AllDialog_eCsv">
                    <table id="TableeCsv" bgcolor=black align ="center" cellspacing='1' cellpadding='1' border='0' width='100%'>
                        <tr bgcolor = #cfcdcd align=left>
                            <td>
                                <table>
                                    <tr>
                                        <td>
                                            <table>
                                                <tr>
                                                    <td>
                                                        <font color="white" size="2">Encoding:</font>
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
                                                        <font color="white" size="2">Only separator(CSV):</font>
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
                                                        <font color="white" size="2">Compress to Zip:</font>
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
                                                        <font color="white" size="2">Engine:</font>
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
                                            <font color="white" size="2">Upload XLS or CSV File:</font>
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
                                            <font color="white" size="2">Fix It4Profit CSV File:</font>
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
            <div id="Stoneaxe-details">
                <h2 class="details-info">Импорт контента из системы Content Factory</h2>
            </div>
            <div id="eCsv-details">
                <h2 class="details-info">Преобразование форматов файлов...</h2>
            </div>
            <div id="Yandex-details">
                <h2>Система управления сравнения цен Yandex Market.</h2>
            </div>
        </div>
    </body>
</html>

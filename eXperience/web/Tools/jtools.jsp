<%-- 
    Document   : jtools
    Created on : 22.08.2009, 16:51:48
    Author     : Admin4DB2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" import = "java.text.DateFormat" import = "java.util.Date" import = "processing.SupplierAll"%>
<%
            //DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            df.setLenient(true);
            Date date = new java.util.Date();
            String formattedDate = df.format(date);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Some Tools</title>
        <!-- ** CSS ** -->
        <!-- base library -->
        <link rel="stylesheet" type="text/css" href="css/ext-all.css" />

        <!-- overrides to base library -->
        <link rel="stylesheet" type="text/css" href="css/CenterLayout.css" />

        <!-- page specific -->
        <link rel="stylesheet" type="text/css" href="css/layout-browser.css">

        <!-- ** Javascript ** -->
        <script type="text/javascript" src="../dojo/dojo/dojo.js" djConfig="parseOnLoad: true, isDebug: false"></script>

        <!-- ExtJS library: base/adapter -->
        <script type="text/javascript" src="js/ext-base.js"></script>

        <!-- ExtJS library: all widgets -->
        <script type="text/javascript" src="js/ext-all.js"></script>

        <!-- overrides to base library -->

        <!-- extensions -->
        <script type="text/javascript" src="js/CenterLayout.js"></script>
        <script type="text/javascript" src="js/RowLayout.js"></script>

        <!-- page specific -->
        <script type="text/javascript" src="js/basic.js"></script>
        <script type="text/javascript" src="js/custom.js"></script>
        <script type="text/javascript" src="js/combination.js"></script>
        <script type="text/javascript" src="js/layout-browser.js"></script>
        <script type='text/javascript' src='js/Xport.js'> </script>
        <script type='text/javascript' src='../dwr/engine.js'></script>
        <script type='text/javascript' src='../dwr/util.js'></script>
        <script type='text/javascript' src='../dwr/interface/DemoNew.js'></script>
        <script type='text/javascript' src='../dwr/interface/DemoN.js'></script>
        <script type='text/javascript' src='../dwr/interface/ClrCache.js'></script>
        <script type='text/javascript' src='../dwr/interface/Export.js'></script>
        <script type='text/javascript' src='../dwr/interface/ManufacturerAll.js'></script>
        <script type='text/javascript' src='../dwr/interface/UploadDownload.js'></script>
        <script type='text/javascript' src='../dwr/interface/SupplierAll.js'></script>
        <script type='text/javascript' src='../dwr/interface/Nix.js'></script>

        <link id="themeStyles" rel="stylesheet" href="../dojo/dijit/themes/tundra/tundra.css">
        <link id="themeStyles" rel="stylesheet" href="css/Xport.css">

    </head>
    <body class="tundra">
        <div id="header">
            <table width="100%">
                <tr>
                    <td>
                        <h1>Shop Tools...</h1>
                    </td>
                    <td>

                    </td>
                </tr>
            </table>
        </div>
        <div style="display:none;">

            <!-- Start page content -->
            <div id="start-div" style="background-color:#e1e8ff; width:100%; height:100%">
                <img style="position:absolute; top:20%; left:20%" src="/eXperience/Tools/images/vovka.jpg"/>
            </div>
            <div id="Yandex_Comporator" style="background-color:#e1e8ff; width:100%; height:100%">
                <div dojoType="dijit.TooltipDialog" id="AllDialog_Yandex" execute="alert(dojo.toJson(arguments[0], false))">
                    <input dojoType=dijit.form.TextBox type="text" id="user" name="User" />
                    <input id="date1" dojoType="dijit.form.DateTextBox" onchange="sss()" value="<%out.println(formattedDate);%>" constraints="{min:'2004-01-01',max:'2006-12-31'}"/>
                    <input name="Date" type="hidden" dojoType=dijit.form.TextBox id="Date" value="<%out.println(formattedDate);%>"/>

                    <button dojoType="dijit.form.Button" type="submit" onclick="this.submit;">
                        &lt;&lt;&lt;Загрузить файл&gt;&gt;&gt;
                    </button>
                    <p class="tundra">
                        <input dojoType="dojox.form.FileInput" id="default2" name="inputFile" />
                    </p>
                </div>
            </div>          
            <div id="Yandex-details">
                <h2>Система управления сравнения цен Yandex Market.</h2>
            </div>
            <div id="nixGrabPT">
                <div dojoType="dijit.TooltipDialog" id="nixGrabPT_PT">
                    <table id="TablenixPT" bgcolor=black cellspacing='1' cellpadding='1' border='0' width='100%'>
                        <tr bgcolor = #cfcdcd>
                            <td>
                                <table>
                                    <tr>
                                        <td>
                                            <button onclick="Watch_All_PT_Nix()">Watch All PT</button>
                                        </td>
                                        <td>
                                            <button>Update Pt/Links</button>
                                        </td>
                                        <td align=right>
                                            <font color="white" size="2">Updating Process:</font>
                                        </td>
                                        <td>
                                            <div id="nixGrabPT_Process">
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </div>
                <br>
                <div dojoType="dijit.TooltipDialog" id="TablenixPT_Out_All">
                    <p align="center" id="TablenixPT_Out">
                        Just press 'Watch All PT' button.
                    </p>
                </div>
            </div>
            <div id="nixGrabCont">

            </div>
            <div id="nixGrabOut">

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
            <div id="Matching">
                <div dojoType="dijit.TooltipDialog" id="AllDialog_Match" execute="alert(dojo.toJson(arguments[0], false))">
                    <table id="TableMatch" bgcolor=black align=center cellspacing='1' cellpadding='1' border=0 width=100%>
                        <tr bgcolor = #cfcdcd align=center>
                            <td>
                                <table>
                                    <tr>
                                        <td>
                                            <div id="SupplSelectMatch">
                                            </div>
                                            <input type="hidden" id="HiddenSupplier" value="www"/>
                                        </td>
                                        <td>
                                            <font color="white" size="2">Add Matching:</font>
                                        </td>
                                        <td>
                                            <input type="file" id="uploadFileMatch"/>
                                            <button onclick="uploadFileMatch()">Upload</button>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            <div id="ManPT">
                <div dojoType="dijit.TooltipDialog" id="AllDialog_ManPT">
                    <table id="TableManPT" bgcolor=black align=center cellspacing='1' cellpadding='1' border='0' width='100%'>
                        <tr bgcolor = #cfcdcd align=center>
                            <td>
                                <table>
                                    <tr>
                                        <td>
                                            <font color="white" size="2">Manufacturer:</font>
                                        </td>
                                        <td>
                                            <div id="ManSelect"></div>
                                        </td>
                                        <td>
                                            <font color="white" size="2">Product Type:</font>
                                        </td>
                                        <td>
                                            <div id="PTSelect"></div>
                                        </td>
                                        <td>
                                            <button onclick="searchAllSuppliers()">Search</button>
                                            <button onclick="ManufacturerAllAdd()">Update</button>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                            <td>
                                <table>
                                    <tr>
                                        <td>
                                            <font color="white" size="2">Upload Man./PT:</font>
                                        </td>
                                        <td>
                                            <input  id="ManPTCheck" dojoType="dijit.form.CheckBox" checked=true>
                                        </td>
                                        <td>
                                            <font color="white" size="2">Add IT4 File:</font>
                                        </td>
                                        <td>
                                            <input type="file" id="uploadFileManPT"/>
                                        </td>
                                        <td>
                                            <button onclick="UploadManPT()">Upload</button>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                    <h1 id="Updating" align="right"></h1>
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
                                            <font color="white" size="2">Encoding:</font>
                                            <select id="eCsvEncoding">
                                                <option value="WINDOWS-1251">ANSI
                                                <option value="UTF-8">UTF-8
                                            </select>
                                        </td>
                                        <td>
                                            <font color="white" size="2">Upload XLS or CSV File:</font>
                                        </td>
                                        <td>
                                            <input type="file" id="uploadFileeCsv"/>
                                        </td>
                                        <td>
                                            <button onclick="UploadeCsv()">Upload</button>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                    <h1 id="Updating" align="right"></h1>
                </div>
            </div>
            <div id="Price_Concentrator-details">
                <h2>Small Price Concentrator.</h2>
                <p>Система расчета цен для шопов относительно цен поставщиков.</p>
                <p><b>Пункты:</b></p>
                <div id="infoDiv">

                    1. <b>Suppliers & Prices</b> - Заливка поставщиков и их прайсов.<br/>
                    2. <b>Manufacturers & Product Types</b> - Заливка производителей и продукт типов.<br/>
                    3. <b>Matching</b> - Заливка матчинга артиклей.<br/>
                    4. <b>Price Rules</b> - Установка правил расчета цен.<br/>
                    5. <b>Output</b> - Отправка данных на шоп.



                </div>
            </div>
            <div id="Magento-details">
                <h2>Magento</h2>
            </div>
            <div id="A2Zmall-details">
                <h2>A2ZMall</h2>
            </div>
            <div id="Nix-details">
                <h2>Грабилка сайта Nix.ru</h2>
            </div>
            <div id="Euromall-details">
                <h2>Euromall</h2>
            </div>
            <div id="eCsv-details">
                <h2 class="details-info">Пертрубации форматов файлов...</h2>
            </div>
        </div>
    </body>
</html>

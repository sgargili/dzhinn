<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
    "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

        <title>Tools for Value4IT</title>

        <script type="text/javascript" src="dojo/dojo/dojo.js" djConfig="parseOnLoad: true, isDebug: false"></script>
        <script type='text/javascript' src='Xport.js'> </script>
        <script type='text/javascript' src='dwr/engine.js'></script>
        <script type='text/javascript' src='dwr/util.js'></script>
        <script type='text/javascript' src='dwr/interface/DemoNew.js'></script>
        <script type='text/javascript' src='dwr/interface/DemoN.js'></script>
        <script type='text/javascript' src='dwr/interface/ClrCache.js'></script>
        <script type='text/javascript' src='dwr/interface/Export.js'></script>

        <link id="themeStyles" rel="stylesheet" href="dojo/dijit/themes/tundra/tundra.css">
        <link id="themeStyles" rel="stylesheet" href="Xport.css">

    </head>
    <body class="tundra">
    <center>
        <div id="Wfont">Fast Export Tool</div>
    </center>
    <br/><br/>
    <div dojoType="dijit.TooltipDialog" id="AllDialog" execute="Export(dojo.toJson(arguments[0], false))">

        <table width=100% ><tr valign=top>
                <td width=70%><textarea title="Введите значения Article или ArticleID" id='TextArea' name='TextArea'  style='width:100%; height:350px' onchange="dojo.byId('SubmitString').value = dojo.byId('TextArea').value;"></textarea></td>
                <td width=1%>&#160;</td>
                <td width=29% align=center>
                    <div dojoType="dijit.TitlePane" title="Данные для экспорта!" style="width: 350px;" jsId="pane1">
                        <table align=center width=100%>
                            <tr align=left>
                                <td><input type='radio' name='DataType' id='ArticleID' value='ArticleID' dojoType='dijit.form.RadioButton' checked>
                                    <label for='ArticleID' title="Хуячит как барбос!"><b>ArticleID</b>&nbsp;(Шустро!)</label>
                                </td>
                                <td><input type='radio' name='DataType' id='Article' value='Article' dojoType='dijit.form.RadioButton'>
                                    <label for='Article' title="А этот не как барбос, но тоже шустрее чем Валуев4IT..."><b>Article</b>&nbsp;(По-медленее...)</label>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div dojoType="dijit.TitlePane" title="Языки" style="width: 350px;" jsId="pane2" open="false">
                        <div align=center>
                            <input  id="LangAll" value="All" dojoType="dijit.form.CheckBox" checked=true onclick="SwitchLanguages">
                            <label for="LangAll">По умолчанию</label>
                        </div>
                        <br>
                        <table width=100%>
                            <tr>
                                <td align=left>
                                    <input  id="Lang1" value="English" dojoType="dijit.form.CheckBox" disabled=true checked=true>
                                    <label for="Lang1">English</label>
                                </td>
                                <td align=left>
                                    <input  id="Lang2" value="Russian" dojoType="dijit.form.CheckBox" disabled=true checked=true>
                                    <label for="Lang2">Russian</label>
                                </td>
                            </tr>
                            <tr>
                                <td align=left>
                                    <input  id="Lang3" value="Bulgarian" dojoType="dijit.form.CheckBox" disabled=true checked=true>
                                    <label for="Lang3">Bulgarian&nbsp;&nbsp;&nbsp;</label>
                                </td>
                                <td align=left>
                                    <input  id="Lang4" value="Croatian" dojoType="dijit.form.CheckBox" disabled=true checked=true>
                                    <label for="Lang4">Croatian</label>
                                </td>
                            </tr>
                            <tr>
                                <td align=left>
                                    <input  id="Lang5" value="Polish" dojoType="dijit.form.CheckBox" disabled=true checked=true>
                                    <label for="Lang5">Polish</label>
                                </td>
                                <td align=left>
                                    <input  id="Lang6" value="Slovenian" dojoType="dijit.form.CheckBox"disabled=true checked=true>
                                    <label for="Lang6">Slovenian</label>
                                </td>
                            </tr>
                        </table>

                    </div>
                    <div dojoType="dijit.TitlePane" title="Статус" style="width: 350px;" jsId="pane3" open="false">
                        <table width=100%>
                            <tr>
                                <td align=left>
                                    <input  id="Status1" value="Done" dojoType="dijit.form.CheckBox" checked=true>
                                    <label for="Status1">Done</label>
                                </td>
                                <td align=left>
                                    <input  id="Status2" value="Control" dojoType="dijit.form.CheckBox">
                                    <label for="Status2">Control</label>
                                </td>
                            </tr>
                            <tr>
                                <td align=left>
                                    <input  id="Status3" value="Research" dojoType="dijit.form.CheckBox">
                                    <label for="Status3">Research&nbsp;&nbsp;&nbsp;</label>
                                </td>
                                <td align=left>
                                    <input id="StatusAll" value="All" dojoType="dijit.form.CheckBox" onclick="SwitchStatus()">
                                    <label for="StatusAll">Да пох...</label>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <input dojoType=dijit.form.TextBox  id="AllLanguages" name="Language" type="hidden" value="All">
                    <input dojoType=dijit.form.TextBox  id="AllStatus" name="Status" type="hidden">
                    <input dojoType=dijit.form.TextBox  id="SubmitString" name="SubmitString" type="hidden">
                    <input dojoType=dijit.form.TextBox  id="ReqMethod" name="ReqMethod" type="hidden">
                    <table>
                        <tr>
                            <td>
                                <button dojoType=dijit.form.Button type="submit" onclick="LangStatStringBuilder(); dojo.byId('ReqMethod').value='Export_Marketing'; this.submit;">
                                    <b>&lt;&lt;&lt; Export Marketing &gt;&gt;&gt;</b>
                                </button>
                            </td>
                            <td>
                                <button dojoType=dijit.form.Button type="submit" onclick="LangStatStringBuilder(); dojo.byId('ReqMethod').value='Export'; this.submit;">
                                    <b>&lt;&lt;&lt; Export by Product &gt;&gt;&gt;</b>
                                </button>
                            </td>
                        </tr>
                    </table>
            </tr>
        </table>
    </div>
    <table>
        <tr align="left">
            <td>
                <button dojoType="dijit.form.Button">
                    <b>&lt;&lt;&lt;Export Statistics&gt;&gt;&gt;</b>
                </button>
            </td>
            <td>
                <button dojoType="dijit.form.Button" onclick="ClrC()">
                    <b>&lt;&lt;&lt;Clear Cache&gt;&gt;&gt;</b>
                </button>
            </td>
            <td>
                <div id="Clc" style="background:#eeffdd; padding-left:4px; padding-right:4px;"></div>
            </td>
        </tr>
    </table>
    <br><br><br>
    <center>
        <div dojoType="dijit.TooltipDialog" id="OutputField" style="visibility: hidden">
            <div id="ShowField"></div>
        </div>
    </center>
</body>
</html>

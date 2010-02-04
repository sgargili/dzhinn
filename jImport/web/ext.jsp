<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>ProgressBar</title>

        <link rel="stylesheet" type="text/css" href="css/ext-all.css" />
        <script type="text/javascript">var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));</script><script type="text/javascript">try{var pageTracker = _gat._getTracker("UA-1396058-1");pageTracker._initData();pageTracker._trackPageview();} catch(err) {}</script>
        <!-- LIBS -->
        <script type="text/javascript" src="js/ext-base.js"></script>
        <!-- ENDLIBS -->

        <script type="text/javascript" src="js/ext-all.js"></script>
        <script type="text/javascript" src="js/progress-bar.js"></script>
        <script type='text/javascript' src='dwr/engine.js'></script>
        <script type='text/javascript' src='dwr/util.js'></script>
        <script type='text/javascript' src='dwr/interface/Ajax.js'></script>
        <script type='text/javascript' src='dwr/interface/CsvProcessing.js'></script>

    </head>
    <body onload="dwr.engine.setActiveReverseAjax(true)">
        <p>
            <b>Additional Options</b><br />
            Rendered on page load, left-aligned text and % width:
            <button id="btn2">Show</button><br />
            <input id="text"/>
            <button id="btn4" onclick="setCount()">set</button><br />
            
        <div id="p2" style="width:50%;"></div>
    </p>
    <%--<p>
        <b>Waiting Bar</b><br />
        Wait for a long operation to complete (example will stop after 5 secs):
        <button id="btn3">Show</button><br />

    <div id="p3"></div>
    <span class="status" id="p3text">Ready</span>
</p>--%>
</body>
</html>
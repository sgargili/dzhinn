<%--
  Created by IntelliJ IDEA.
  User: Andrey Popov
  Date: 08.11.2010
  Time: 16:22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple jsp page</title>
</head>
<body>

<script type="text/javascript" language="JavaScript">
    function stateChange() {
        if (ajax.readyState === 4) {
            if (ajax.status === 200) {
                /* INSERT STUFF TO DO ON FAILURE */
                alert(ajax.responseText);
            } else {
                /* INSERT STUFF TO DO ON SUCCESS */
                alert(ajax.responseText);
            }
        }
    }

    function ajax_request() {
        try {
            return new XMLHttpRequest();
        } catch(e) {
        }
        try {
            return new ActiveXObject("Msxml2.XMLHTTP.6.0");
        } catch (e) {
        }
        try {
            return new ActiveXObject("Msxml2.XMLHTTP.3.0");
        } catch (e) {
        }
        try {
            return new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
        }
        try {
            return new ActiveXObject("Microsoft.XMLHTTP");
        } catch (e) {
        }
        return null;
    }

    var ajax = new ajax_request();
    if (ajax !== null) {
        //ajax.setRequestHeader("Accept", "application/xml");
        var params = "id=1";
        ajax.open("post", "rest/getShopById.html");
        ajax.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        ajax.setRequestHeader("Content-length", params.length);
        ajax.setRequestHeader("Connection", "close");
//        ajax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
        ajax.setRequestHeader("Accept", "application/json");
        ajax.onreadystatechange = stateChange;
        ajax.send(params);
    } else {
        alert("Лажа...");
    }
</script>
</body>
</html>
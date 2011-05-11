<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>
<head>
    <title>Hello</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>"/>
</head>
<body>
<div id="header" style="background:#80FF00;width:100%">
        <tiles:insertAttribute name="header"/>
</div>
<div id="body" style="background:#80FF00;width:100%">
    <tiles:insertAttribute name="body"/>
</div>
<div id="footer"style="background:#80FF00;width:100%">
    <tiles:insertAttribute name="footer"/>
</div>
</body>
</html>

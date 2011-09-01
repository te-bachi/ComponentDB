<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><tiles:insertAttribute name="title" /></title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link rel="stylesheet" type="text/css" href="/styles.css">
    </head>
    <body>
        <tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="menu" />
        <tiles:insertAttribute name="breadcrumbs" />
        <tiles:insertAttribute name="category" />
        <tiles:insertAttribute name="filter" />
        <tiles:insertAttribute name="result" />
        <tiles:insertAttribute name="component" />
        <tiles:insertAttribute name="footer" />
    </body>
</html>
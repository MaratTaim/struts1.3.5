<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="/News.do?dispatch=<bean:message key="label.list" />" ><bean:message key="info.list" /></a><br>
        <a href="/News.do?dispatch=<bean:message key="label.add" />" ><bean:message key="info.add" /></a>
    </body>
</html>

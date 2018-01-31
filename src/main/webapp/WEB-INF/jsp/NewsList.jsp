<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="nested" uri="http://jakarta.apache.org/struts/tags-nested" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html:html>
<head>
    <link href="<c:url value='../../css/main.css'/>" rel="stylesheet" type="text/css"/>
    <title>News List</title>

    <script>
        function testForm(f)
        {
            var errDay = true;
            for (var days = f.delete, j = 0, J = days.length; j < J; j++) if (days [j].checked) {errDay = false; break}
            if (errDay) {alert ('<bean:message key="select.delete"/>'); return false}
            return true;
        }
    </script>
</head>
<body>

<html:form action="/News.do" method="POST">

<nested:iterate id="list" property="newsList" indexId="indX">
<center>
<table>

    <tr>
        <html:errors/>

        <th style="width: 496px; text-align: left"><bean:write name="list" property="title"/></th>
        <td style="width: 157px; text-align: right"><bean:write name="list" property="date"/></td>
    </tr>
    <tr>
        <td style="width: 519px;">
            <p><bean:write name="list" property="brief"/></p>
        </td>
    </tr>
    <tr>
        <td></td>
        <td style="width: 39px; text-align: right;">
            <a href="?id=${list.id}&dispatch=<bean:message key="label.view"/>"><bean:message key="label.view"/></a>
            <a href="?id=${list.id}&dispatch=<bean:message key="label.edit"/>"><bean:message key="label.edit"/></a>
            <html:checkbox name="list" property="delete" value="${list.id}"/>
        </td>
    </tr>
    <tr></tr>
    </nested:iterate>
    <tr>
        <td></td>
        <td style="text-align: right"><html:submit property="dispatch" onclick="return testForm(this.form)">
            <bean:message key="label.delete"/>
        </html:submit></td>
    </tr>
    </html:form>
</table>
</center>
</body>
</html:html>
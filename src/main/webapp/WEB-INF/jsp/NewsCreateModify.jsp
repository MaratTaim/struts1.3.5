<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<html:html>
<head>
    <link href="<c:url value='../../css/main.css'/>" rel="stylesheet" type="text/css"/>
    <title>Add News</title>
</head>
<body>
<html:form action="/News.do" method="POST">

    <input type="hidden" name="id" value="${news.id}"/>
    <table style="text-align: left">
        <tr>
            <th><bean:message key="info.title"/></th>
            <td><html:text styleClass="coll" property="newsMessage.title" maxlength="100"/>
                <html:errors property="titleErr"/></td>
        </tr>
        <tr>
            <th><bean:message key="info.date"/></th>
            <td><html:text styleClass="coll" property="newsMessage.date" maxlength="10" />
                <html:errors property="dateErr"/></td>
        </tr>
        <tr>
            <th><bean:message key="info.brief"/></th>
            <td><html:textarea styleClass="coll" property="newsMessage.brief" />
                <html:errors property="briefErr"/></td>
        </tr>
        <tr>
            <th><bean:message key="info.content"/></th>
            <td><html:textarea styleClass="coll" property="newsMessage.content" />
                <html:errors property="contentErr"/></td>
        </tr>
        <tr  style="text-align: right">
            <th><html:hidden property="newsMessage.id"/>
            <input type="hidden" name="page" value="add"/></th>
            <td><html:submit styleClass="button" property = "dispatch">
                <bean:message key="label.save"/>
            </html:submit>
                <input class="button" type="button" onclick="history.back();" value="<bean:message key="label.cancel"/>"/></td>
        </tr>
    </table>
</html:form>

</body>
</html:html>

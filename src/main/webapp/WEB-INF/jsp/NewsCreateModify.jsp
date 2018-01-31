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
                <span style="color: red"><html:errors property="titleErr"/></span></td>
        </tr>
        <tr>
            <th><bean:message key="info.date"/></th>
            <td><html:text styleClass="coll" property="newsMessage.date" maxlength="10" />
                <span style="color: red"><html:errors property="dateErr"/></span></td>
        </tr>
        <tr>
            <th><bean:message key="info.brief"/></th>
            <td><html:textarea styleClass="coll" property="newsMessage.brief" />
                <span style="color: red"><html:errors property="briefErr"/></span></td>
        </tr>
        <tr>
            <th><bean:message key="info.content"/></th>
            <td><html:textarea styleClass="coll" property="newsMessage.content" />
                <span style="color: red"><html:errors property="contentErr"/></span></td>
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

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="h" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>

<html:html>
<head>
    <script>
        function testForm(f)
        {
            var errDay = true;
            if (errDay) {confirm('<bean:message key="news.delete"/>'); return true}
            return true;
        }
    </script>
    <link href="<c:url value='../../css/main.css'/>" rel="stylesheet" type="text/css"/>
    <title>New View</title>
</head>
<body>
<h:form action="/News.do" method="POST">
    <h:errors/>
    <input type="hidden" name="id" value="${news.id}"/>
    <table style="text-align: left" >
        <tr>
            <th class="view">News Title: </th>
            <td class="view"><c:out value='${news.title}'/></td>
        </tr>
        <tr>
            <th class="view">News Date: </th>
            <td class="view"><c:out value='${news.date}'/></td>
        </tr>
        <tr>
            <th class="view">Brief: </th>
            <td class="view"><c:out value='${news.brief}'/></td>
        </tr>
        <tr>
            <th class="view">Content: </th>
            <td class="view"><c:out value='${news.content}'/></td>
        </tr>
        <tr>
            <th></th>
            <td style="text-align: right"><h:submit property = "dispatch">
                <bean:message key="label.edit"/>
            </h:submit>
                <h:submit property = "dispatch" onclick="return testForm(this.form);">
                    <bean:message key="label.delete"/>
                </h:submit></td>
        </tr>
    </table>
</h:form>
</body>
</html:html>

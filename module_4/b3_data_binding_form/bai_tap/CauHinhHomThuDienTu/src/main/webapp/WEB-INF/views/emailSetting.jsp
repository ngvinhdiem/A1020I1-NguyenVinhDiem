<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form:form method="post" action="/settingEmail" modelAttribute="email">
    <table>
        <tr>
            <td>Language:</td>
            <td>
                <form:select path="language">
                    <form:options items="${listLanguage}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Page Size:</td>
            <td>
                Show
                <form:select path="pageSize">
                    <form:options items="${listPageSize}"/>
                </form:select>
                emails per page
            </td>
        </tr>
        <tr>
            <td>Spams filter:</td>
            <td>show <form:checkbox path="spamsFilters"/> emails per page</td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr><td><input type="submit" value="Update"/></td></tr>
    </table>
</form:form>
</body>
</html>
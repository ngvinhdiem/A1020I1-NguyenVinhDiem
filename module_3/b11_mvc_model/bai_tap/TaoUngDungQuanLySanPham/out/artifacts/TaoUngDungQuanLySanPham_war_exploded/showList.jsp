<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show List</title>
</head>
<body>
<h1>Input index to show detail:</h1>
<form action="/product">
    <input type="text" name="indexShowDetail">
    <lable>
        <input type="submit">
    </lable>
</form>
<table>
    <tr>
        <th>Index:</th>
        <th>Name:</th>
    </tr>
    <c:forEach var="product" items="${productListServlet}" varStatus="loop">
        <tr>
            <td><c:out value="${loop.index +1}"/></td>
            <td><c:out value="${product.name}"/></td>
        </tr>
    </c:forEach>
</table>
<a href="/">Back to menu</a>
</body>
</html>
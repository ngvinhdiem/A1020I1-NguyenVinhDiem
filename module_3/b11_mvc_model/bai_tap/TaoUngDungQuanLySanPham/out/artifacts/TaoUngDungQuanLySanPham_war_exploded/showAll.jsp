<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Show All</title>
</head>
<body>
<table border="1px">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Product description</th>
        <th>Manufacturer</th>
    </tr>
    <c:forEach var="product" items="${productListServlet}">
        <tr>
            <td><c:out value="${product.id}"/></td>
            <td><c:out value="${product.name}"/></td>
            <td><c:out value="${product.price}"/></td>
            <td><c:out value="${product.description}"/></td>
            <td><c:out value="${product.producer}"/></td>
        </tr>
    </c:forEach>
</table>
<a href="/">Back to menu</a>
</body>
</html>
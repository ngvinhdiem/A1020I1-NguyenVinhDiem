<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
<form action="/product">
    <h1>Input index to delete product :</h1>
    <input type="text" name="indexDelete">
    <lable>
        <input type="submit" value="submit">
    </lable>
</form>
<div id="table">
    <table border="1px">
        <tr>
            <th>Index</th>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Description</th>
            <th>Producer</th>
        </tr>
        <c:forEach var="product" items="${productListServlet}" varStatus="loop">
            <tr>
                <td><c:out value="${loop.index + 1}"/></td>
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.name}"/></td>
                <td><c:out value="${product.price}"/></td>
                <td><c:out value="${product.description}"/></td>
                <td><c:out value="${product.producer}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
<a href="/">Back to menu</a>
</body>
</html>
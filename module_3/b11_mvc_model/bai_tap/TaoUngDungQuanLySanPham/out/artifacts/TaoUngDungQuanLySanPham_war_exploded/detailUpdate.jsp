<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail Update</title>
</head>
<body>
<form action="/product?actionUser=update" method="post">
    <h1>
        ID:
        <lable>
            <input type="text" name="id" value="${updateProduct.id}" >
        </lable>
    </h1>

    <h1>
        Name of product:
        <lable>
            <input type="text" name="name" value="${updateProduct.name}">
        </lable>
    </h1>
    <h1>
        Price:
        <lable>
            <input type="text" name="price" value="${updateProduct.price}">
        </lable>
    </h1>
    <h1>
        Product Description:
        <lable>
            <input type="text" name="description" value="${updateProduct.description}">
        </lable>
    </h1>
    <h1>
        Producer:
        <lable>
            <input type="text" name="producer" value="${updateProduct.producer}">
        </lable>
    </h1>
    <input type="submit" value="submit">
</form>
<a href="/">Back to menu</a>
</body>
</html>
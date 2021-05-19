<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Product</title>
</head>
<body>
<form action="/product?actionUser=create" method="post">
    <h2>
        Name
        <lable>
            <input type="text" name="name">
        </lable>
    </h2>
    <h2>
        Price:
        <lable>
            <input type="text" name="price">
        </lable>
    </h2>
    <h2>
        Description:
        <lable>
            <input type="text" name="description">
        </lable>
    </h2>
    <h2>
        Producer:
        <lable>
            <input type="text" name="producer">
        </lable>
    </h2>
    <input type="submit" value="submit">
</form>
<a href="/">Back to menu</a>
</body>
</html>
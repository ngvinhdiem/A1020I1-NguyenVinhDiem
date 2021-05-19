<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
<form action="/product?actionUser=search" method="post">
    <input type="text" name="search"/>
    <input type="submit">
</form>
<h1>ID:</h1>
<c:out value="${productDetail.id}"/>
<h1>Name:</h1>
<span>
        <c:out value="${productDetail.name}"/>
    </span>
<h1>price:</h1>
<span>
        <c:out value="${productDetail.price}"/>
    </span>
<h1>Description:</h1>
<span>
        <c:out value="${productDetail.description}"/>
    </span>
<h1>Producer:</h1>
<span>
        <c:out value="${productDetail.producer}"/>
    </span>
<br>
<a href="/">Back to menu</a>
</body>
</html>
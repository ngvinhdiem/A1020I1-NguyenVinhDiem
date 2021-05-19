<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show Detail</title>
</head>
<body>
<h1>ID:</h1>
<span>
        <c:out value="${productShowDetail.id}"/>
    </span>
<h1>Name:</h1>
<span>
        <c:out value="${productShowDetail.name}"/>
    </span>
<h1>price:</h1>
<span>
        <c:out value="${productShowDetail.price}"/>
    </span>
<h1>Description:</h1>
<span>
        <c:out value="${productShowDetail.description}"/>
    </span>
<h1>Producer:</h1>
<span>
        <c:out value="${productShowDetail.producer}"/>
    </span>
<br>
<a href="/">home</a>
</body>
</html>
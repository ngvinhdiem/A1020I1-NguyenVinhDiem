<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Input country to search user:</h1>
<form action="/users?action=ctsearch" method="post">
    <input type="text" name="ct"/>
    <input type="submit">
</form>
<h1>ID:</h1>
<c:out value="${selectedUser.id}"/>
<h1>Name:</h1>
<span>
        <c:out value="${selectedUser.name}"/>
    </span>
<h1>Email:</h1>
<span>
        <c:out value="${selectedUser.email}"/>
    </span>
<h1>Country:</h1>
<span>
        <c:out value="${selectedUser.country}"/>
    </span>

<h3>
    <a href="/">Back to menu</a>
</h3>
</body>
</html>

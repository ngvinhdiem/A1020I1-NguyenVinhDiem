
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<a href="/create">Create condiment</a>
<table>
  <tr>
    <th>Condiment</th>
  </tr>
  <c:forEach items="${condimentList}" var="condiment">
    <tr>
      <td>${condiment}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
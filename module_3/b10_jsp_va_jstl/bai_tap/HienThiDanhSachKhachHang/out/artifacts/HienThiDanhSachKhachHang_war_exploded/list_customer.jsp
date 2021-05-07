
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
<%--    <tr>Danh sach khach hang</tr>--%>

    <tr>
        <th>Ten</th>
        <th>Ngay sinh</th>
        <th>Dia chi</th>
        <th>Anh</th>
    </tr>

    <c:forEach var="customer"  items="${customerListServlet}" >
        <tr>
            <td><c:out value="${customer.name}"/></td>
            <td><c:out value="${customer.dob}"/></td>
            <td><c:out value="${customer.address}"/></td>
            <td><img src="${customer.image}" style="width: 50px; height: 50px;"/></td>
        </tr>

    </c:forEach>





</table>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 5/25/2021
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>
    <%@include file="../body/header.jsp" %>
</header>

<div class = "row">
    <aside class="col-sm-3">
        <div class="poly-cart">
            <div class="card-header">
                <span class="glyphicon glyphicon-th-list"></span>
                <strong>Customer</strong>
            </div>
            <div class="list-group">
                <a href="furama?action=add-customer" class="list-group-item">Add New Customer</a>
                <a href="furama?action=list-customers" class="list-group-item">List All Customers</a>

            </div>
        </div>
    </aside>
<%--    <article class="col-sm-9">--%>
<%--        <div align="center">--%>
<%--            <table border="1" cellpadding="5">--%>
<%--                <caption><h2>List of Customers</h2></caption>--%>
<%--                <form method="post">--%>
<%--                    <input type="text" name="search" placeholder="search country">--%>
<%--                    <input name="search" type="submit" value="Search"><br>--%>
<%--                </form>--%>
<%--                <h3><a href="users?action=sort">Sort by Name</a></h3>--%>
<%--                <tr>--%>
<%--                    <td>Id</td>--%>
<%--                    <td>Type Id</td>--%>
<%--                    <td>Name</td>--%>
<%--                    <td>Birthday</td>--%>
<%--                    <td>Gender</td>--%>
<%--                    <td>Id Card</td>--%>
<%--                    <td>Phone</td>--%>
<%--                    <td>Email</td>--%>
<%--                    <td>Address</td>--%>
<%--                    <td>Actions</td>--%>
<%--                </tr>--%>

<%--                <c:forEach var="customer" items="${customerList}">--%>
<%--                    <tr>--%>
<%--                        <td><c:out value="${customer.customerId}"/></td>--%>
<%--                        <td><c:out value="${customer.customerTypeId}"/></td>--%>
<%--                        <td><c:out value="${customer.customerName}"/></td>--%>
<%--                        <td><c:out value="${customer.customerBirthday}"/></td>--%>
<%--                        <td><c:out value="${customer.customerGender}"/></td>--%>
<%--                        <td><c:out value="${customer.customerIdCard}"/></td>--%>
<%--                        <td><c:out value="${customer.customerPhone}"/></td>--%>
<%--                        <td><c:out value="${customer.customerEmail}"/></td>--%>
<%--                        <td><c:out value="${customer.customerAddress}"/></td>--%>
<%--                        <td>--%>
<%--                            <a href="users?action=edit&id=${customer.customerId}">Edit | </a>--%>
<%--                            <a href="users?action=delete&id=${customer.customerId}">Delete</a>--%>
<%--                        </td>--%>
<%--                    </tr>--%>
<%--                </c:forEach>--%>
<%--            </table>--%>
<%--        </div>--%>
<%--    </article>--%>

<%--    <article class="col-sm-9">--%>
<%--        <div style="float:left;" class="col-sm-4 poly-prod">--%>
<%--            <div class="card card-default">--%>
<%--                <div class="card-header">--%>
<%--                    <h4 class="card-title">--%>
<%--                        Nokia--%>
<%--                    </h4>--%>
<%--                </div>--%>
<%--                <div class="card-body">--%>
<%--                    <img src="images/computer.jpg" width="152" /></div>--%>
<%--                <div class="card-footer">--%>
<%--                    $ 100.25--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div style="float:left;" class="col-sm-4 poly-prod">--%>
<%--            <div class="card card-default">--%>
<%--                <div class="card-header">--%>
<%--                    <h4 class="card-title">--%>
<%--                        Nokia--%>
<%--                    </h4>--%>
<%--                </div>--%>
<%--                <div class="card-body">--%>
<%--                    <img src="images/computer.jpg" width="152" /></div>--%>
<%--                <div class="card-footer">--%>
<%--                    $ 100.25--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div style="float:left;" class="col-sm-4  poly-prod">--%>
<%--            <div class="card card-default">--%>
<%--                <div class="card-header">--%>
<%--                    <h4 class="card-title">--%>
<%--                        Nokia--%>
<%--                    </h4>--%>
<%--                </div>--%>
<%--                <div class="card-body">--%>
<%--                    <img src="images/computer.jpg" width="152" /></div>--%>
<%--                <div class="card-footer">--%>
<%--                    $ 100.25--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div style="float:left;" class="col-sm-4 poly-prod">--%>
<%--            <div class="card card-default">--%>
<%--                <div class="card-header">--%>
<%--                    <h4 class="card-title">--%>
<%--                        Nokia--%>
<%--                    </h4>--%>
<%--                </div>--%>
<%--                <div class="card-body">--%>
<%--                    <img src="images/computer.jpg" width="152" /></div>--%>
<%--                <div class="card-footer">--%>
<%--                    $ 100.25--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div style="float:left;" class="col-sm-4 poly-prod">--%>
<%--            <div class="card card-default">--%>
<%--                <div class="card-header">--%>
<%--                    <h4 class="card-title">--%>
<%--                        Nokia--%>
<%--                    </h4>--%>
<%--                </div>--%>
<%--                <div class="card-body">--%>
<%--                    <img src="images/computer.jpg" width="152" /></div>--%>
<%--                <div class="card-footer">--%>
<%--                    $ 100.25--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div style="float:left;" class="col-sm-4 poly-prod">--%>
<%--            <div class="card card-default">--%>
<%--                <div class="card-header">--%>
<%--                    <h4 class="card-title">--%>
<%--                        Nokia--%>
<%--                    </h4>--%>
<%--                </div>--%>
<%--                <div class="card-body">--%>
<%--                    <img src="images/computer.jpg" width="152" /></div>--%>
<%--                <div class="card-footer">--%>
<%--                    $ 100.25--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--    </article>--%>

</div>


<footer>
    <%@include file="../body/footer.jsp" %>
</footer>

<%--<div style="position: fixed;bottom: 0;text-align: center; width:100%; background-color: #ff0;">--%>
<%--    <jsp:include page="../body/footer.jsp"></jsp:include>--%>
<%--</div>--%>
</body>
</html>

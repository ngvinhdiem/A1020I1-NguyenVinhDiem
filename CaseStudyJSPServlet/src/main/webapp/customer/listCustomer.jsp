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
    <link rel="stylesheet" href="../bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.min.css" />
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
    <article class="col-sm-9">

        <div align="center">
            <br><h3>List of Customers</h3><br>
            <form method="post">
                <label>
                    <input type="text" name="search" placeholder="Search By Name">
                    <input type="submit" value="Search"><br>
                </label>

            </form>
            <table id="tableCustomer" class="table table-striped table-bordered" style="width:90%">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Type</th>
                    <th>Name</th>
                    <th>Birthday</th>
                    <th>Gender</th>
                    <th>Id Card</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="customer" items="${customerList}">
                    <tr>
                        <td><c:out value="${customer.customerId}"/></td>
                        <td><c:out value="${customer.customerTypeId}"/></td>
                        <td><c:out value="${customer.customerName}"/></td>
                        <td><c:out value="${customer.customerBirthday}"/></td>
                        <td><c:out value="${customer.customerGender}"/></td>
                        <td><c:out value="${customer.customerIdCard}"/></td>
                        <td><c:out value="${customer.customerPhone}"/></td>
                        <td><c:out value="${customer.customerEmail}"/></td>
                        <td><c:out value="${customer.customerAddress}"/></td>
                        <td>
                            <a href="furama?action=edit-customer&id=${customer.customerId}">Edit | </a>
                            <a href="furama?action=delete-customer&id=${customer.customerId}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </article>


</div>


<footer>
    <%@include file="../body/footer.jsp" %>
</footer>


<script src="../jquery/jquery-3.5.1.min.js"></script>
<script src="../datatables/js/jquery.dataTables.min.js"></script>
<script src="../datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function() {
        $('#tableCustomer').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 3
        } );
    } );
</script>
</body>
</html>

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
    <aside class="col-sm-2">
        <div class="poly-cart">
            <div class="card-header">
                <span class="glyphicon glyphicon-th-list"></span>
                <strong>Employee</strong>
            </div>
            <div class="list-group">
                <a href="furama?action=add-employee" class="list-group-item">Add New Employee</a>
                <a href="furama?action=list-employees" class="list-group-item">List All Employees</a>
            </div>
        </div>
    </aside>
    <article class="col-sm-10">

        <div align="center">
            <br><h3>List of Employees</h3><br>
            <form method="post">
                <label>
                    <input type="text" name="search" placeholder="Search By Name">
                    <input type="submit" value="Search"><br>
                </label>

            </form>
            <table id="tableEmployee" class="table table-striped table-bordered" style="width:90%">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Birthday</th>
                    <th>Id Card</th>
                    <th>Salary</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Position Id</th>
                    <th>Education Degree Id</th>
                    <th>Division Id</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="employee" items="${employeeList}">
                    <tr>
                        <td><c:out value="${employee.employeeId}"/></td>
                        <td><c:out value="${employee.employeeName}"/></td>
                        <td><c:out value="${employee.employeeBirthday}"/></td>
                        <td><c:out value="${employee.employeeIdCard}"/></td>
                        <td><c:out value="${employee.employeeSalary}"/></td>
                        <td><c:out value="${employee.employeePhone}"/></td>
                        <td><c:out value="${employee.employeeEmail}"/></td>
                        <td><c:out value="${employee.employeeAddress}"/></td>
                        <td><c:out value="${employee.employeePositionId}"/></td>
                        <td><c:out value="${employee.educationDegreeId}"/></td>
                        <td><c:out value="${employee.divisionId}"/></td>
                        <td>
                            <a href="furama?action=edit-employee&id=${employee.employeeId}">Edit | </a>
                            <a href="furama?action=delete-employee&id=${employee.employeeId}">Delete</a>
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
        $('#tableEmployee').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 3
        } );
    } );
</script>
</body>
</html>

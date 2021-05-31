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
                <strong>Contract</strong>
            </div>
            <div class="list-group">
                <a href="furama?action=add-contract" class="list-group-item">Add New Contract</a>
                <a href="furama?action=list-contracts" class="list-group-item">List All Contracts</a>
            </div>
        </div>
    </aside>
    <article class="col-sm-10">

        <div align="center">
            <br><h3>List of Contracts</h3><br>

            <table id="tableCustomer" class="table table-striped table-bordered" style="width:90%">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Start Date:</th>
                    <th>End Date:</th>
                    <th>Deposit</th>
                    <th>Total Money:</th>
                    <th>Employee Id:</th>
                    <th>Customer Id:</th>
                    <th>Service Id:</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="contract" items="${contractList}">
                    <tr>
                        <td><c:out value="${contract.contractId}"/></td>
                        <td><c:out value="${contract.contractStartDate}"/></td>
                        <td><c:out value="${contract.contractEndDate}"/></td>
                        <td><c:out value="${contract.contractDeposit}"/></td>
                        <td><c:out value="${contract.contractTotalMoney}"/></td>
                        <td><c:out value="${contract.employeeId}"/></td>
                        <td><c:out value="${contract.customerId}"/></td>
                        <td><c:out value="${contract.serviceId}"/></td>
                        <td>
                            <a href="furama?action=edit-contract&id=${contract.contractId}">Edit | </a>
                            <a href="furama?action=delete-contract&id=${contract.contractId}">Delete</a>
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

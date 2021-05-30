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
                <strong>Service</strong>
            </div>
            <div class="list-group">
                <a href="furama?action=add-service" class="list-group-item">Add New Service</a>
                <a href="furama?action=list-services" class="list-group-item">List All Services</a>
            </div>
        </div>
    </aside>
    <article class="col-sm-9">

        <div align="center">
            <br><h3>List of services</h3><br>
            <form method="post" >
                <label>
                    <input type="text" name="search" placeholder="Search By Name">
                    <input type="submit" value="Search"><br>
                </label>

            </form>
            <table id="tableService" class="table table-striped table-bordered" style="width:90%">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Area</th>
                    <th>Cost</th>
                    <th>Max People</th>
                    <th>Rent Type ID</th>
                    <th>Service Type ID</th>
                    <th>Standard Room</th>
                    <th>Description Other Convenience</th>
                    <th>Pool Area</th>
                    <th>Number Of Floors</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="service" items="${serviceList}">
                    <tr>
                        <td><c:out value="${service.serviceId}"/></td>
                        <td><c:out value="${service.serviceName}"/></td>
                        <td><c:out value="${service.serviceArea}"/></td>
                        <td><c:out value="${service.serviceCost}"/></td>
                        <td><c:out value="${service.serviceMaxPeople}"/></td>
                        <td><c:out value="${service.rentTypeId}"/></td>
                        <td><c:out value="${service.serviceTypeId}"/></td>
                        <td><c:out value="${service.standardRoom}"/></td>
                        <td><c:out value="${service.descriptionOtherConvenience}"/></td>
                        <td><c:out value="${service.poolArea}"/></td>
                        <td><c:out value="${service.numberOfFloors}"/></td>
                        <td>
                            <a href="furama?action=edit-service&id=${service.serviceId}">Edit | </a>
                            <a href="furama?action=delete-service&id=${service.serviceId}">Delete</a>
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
        $('#tableService').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 3
        } );
    } );
</script>
</body>
</html>

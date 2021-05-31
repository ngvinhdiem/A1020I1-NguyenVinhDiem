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
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src=https://code.jquery.com/jquery-1.12.4.js></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
            <form method="post">
                <table border="1" cellpadding="5">
                    <br>  <h3>Add New Contract</h3> <br>
                    <tr>
                        <th>Contract Start Date:</th>
                        <td>
                            <input type="date" name="startDate" size="45">
                        </td>
                    </tr>
                    <tr>
                        <th>Contract End Date:</th>
                        <td>
                            <input type="date" name="endDate" size="45">
                        </td>
                    </tr>
                    <tr>
                        <th>Contract Deposit:</th>
                        <td>
                            <input type="text" name="deposit" size="45"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Contract Total Money:</th>
                        <td>
                            <input type="text" name="totalMoney" size="45"/>
                        </td>
                    </tr>

                    <tr>
                        <th>Employee ID:</th>
                        <td>
                            <select class="form-control form-select"  name="employeeId">
                        <c:forEach var="employee" items="${employeeList}">
                                <option value="${employee.employeeId}"><c:out value="${employee.employeeId}"/></option>
                        </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Customer ID:</th>
                        <td>
                            <select class="form-control form-select"  name="customerId">
                                <c:forEach var="customer" items="${customerList}">
                                    <option value="${customer.customerId}"><c:out value="${customer.customerId}"/></option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Service ID:</th>
                        <td>
                            <select class="form-control form-select"  name="serviceId">
                                <c:forEach var="service" items="${serviceList}">
                                    <option value="${service.serviceId}"><c:out value="${service.serviceId}"/></option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Add"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </article>


</div>


<footer>
    <%@include file="../body/footer.jsp" %>
</footer>

</body>
</html>

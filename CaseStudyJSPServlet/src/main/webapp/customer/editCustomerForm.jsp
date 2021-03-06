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
                <strong>Customer</strong>
            </div>
            <div class="list-group">
                <a href="furama?action=add-customer" class="list-group-item">Add New Customer</a>
                <a href="furama?action=list-customers" class="list-group-item">List All Customers</a>

            </div>
        </div>
    </aside>
    <article class="col-sm-10">
        <div align="center">
            <form method="post">
                <table border="1" cellpadding="5">
                    <br><h3>Edit Customer</h3>
                    <tr>
                        <th>Id:</th>
                        <td>
                            <c:out value='${customer.customerId}' />

                        </td>
                    </tr>
                    <tr>
                        <th>Type :</th>
                        <td>
                            <select class="form-control form-select" name="type">
                                <option value="1" + ${type1}  >Member</option>
                                <option value="2"+ ${type2}>Silver</option>
                                <option value="3" + ${type3}>Gold</option>
                                <option value="4"+ ${type4}>Platinum</option>
                                <option value="5"+ ${type5}>Diamond</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Name:</th>
                        <td>
                            <input type="text" name="name"  size="45" value="<c:out value='${customer.customerName}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Birthday:</th>
                        <td>
                            <input type="date" id="birthday" name="birthday" value="${customerBirthday}" size="45">
                        </td>
                    </tr>
                    <tr>
                        <th>Gender:</th>
                        <td>
                            <select class="form-control form-select"  name="gender">
                                <option value="1" + ${gender1}>Nam</option>
                                <option value="0" + ${gender0}>Nu</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Id Card:</th>
                        <td>
                            <input type="text" name="idCard" size="45" value="<c:out value='${customer.customerIdCard}' />">
                        </td>
                    </tr>
                    <tr>
                        <th>Phone:</th>
                        <td>
                            <input type="text" name="phone" size="45" value="<c:out value='${customer.customerPhone}' />">
                        </td>
                    </tr>
                    <tr>
                        <th>Email:</th>
                        <td>
                            <input type="text" name="email" size="45" value="<c:out value='${customer.customerEmail}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Address:</th>
                        <td>
                            <input type="text" name="address" size="45" value="<c:out value='${customer.customerAddress}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Edit"/>
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

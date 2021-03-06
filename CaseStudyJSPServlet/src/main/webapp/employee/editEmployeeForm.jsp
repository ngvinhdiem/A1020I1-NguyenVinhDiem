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
            <form method="post">
                <table border="1" cellpadding="5">
                    <br><h3>Edit Employee</h3>
                    <tr>
                        <th>Id:</th>
                        <td>
                            <c:out value='${employee.employeeId}' />

                        </td>
                    </tr>
                    <tr>
                        <th>Name:</th>
                        <td>
                            <input type="text" name="name" size="45" value="<c:out value='${employee.employeeName}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Birthday:</th>
                        <td>
                            <input type="date" id="birthday" name="birthday" size="45" value="<c:out value='${employee.employeeBirthday}' />">
                        </td>
                    </tr>
                    <tr>
                        <th>Id Card:</th>
                        <td>
                            <input type="text" name="idCard" size="45" value="<c:out value='${employee.employeeIdCard}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Salary:</th>
                        <td>
                            <input type="text" name="salary" size="45" value="<c:out value='${employee.employeeSalary}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Phone:</th>
                        <td>
                            <input type="text" name="phone" size="45" value="<c:out value='${employee.employeePhone}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Email:</th>
                        <td>
                            <input type="text" name="email" size="45" value="<c:out value='${employee.employeeEmail}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Address:</th>
                        <td>
                            <input type="text" name="address" size="45" value="<c:out value='${employee.employeeAddress}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Position :</th>
                        <td>
                            <select class="form-control form-select" name="positionId">
                                <option value="1"+ ${position1}>Le Tan</option>
                                <option value="2"+ ${position2}>Phuc Vu</option>
                                <option value="3"+ ${position3}>Chuyen Vien</option>
                                <option value="4"+ ${position4}>Giam Sat</option>
                                <option value="5"+ ${position5}>Quan Ly</option>
                                <option value="6"+ ${position6}>Giam Doc</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Education Degree :</th>
                        <td>
                            <select class="form-control form-select" name="educationDegreeId">
                                <option value="1"+ ${educationDegree1}>Trung Cap</option>
                                <option value="2"+ ${educationDegree2}>Cao Dang</option>
                                <option value="3"+ ${educationDegree3}>Dai Hoc</option>
                                <option value="4"+ ${educationDegree4}>Sau Dai Hoc</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Division :</th>
                        <td>
                            <select class="form-control form-select" name="divisionId">
                                <option value="1"+ ${division1}>Sale-Marketing</option>
                                <option value="2"+ ${division2}>Hanh Chinh</option>
                                <option value="3"+ ${division3}>Phuc Vu</option>
                                <option value="4"+ ${division4}>Quan Ly</option>
                            </select>
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

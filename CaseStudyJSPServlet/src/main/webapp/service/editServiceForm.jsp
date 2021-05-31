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
                <a href="furama?action=add-service" class="list-group-item">Add New Service</a>
                <a href="furama?action=list-services" class="list-group-item">List All Services</a>

            </div>
        </div>
    </aside>
    <article class="col-sm-10">
        <div align="center">
            <form method="post">
                <table border="1" cellpadding="5">
                <h4>Edit Service</h4>
                    <tr>
                        <th>Id:</th>
                        <td>
                            <c:out value='${service.serviceId}' />
                        </td>
                    </tr>
                    <tr>
                        <th>Name:</th>
                        <td>
                            <input type="text" name="name" size="45" value="<c:out value='${service.serviceName}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Area:</th>
                        <td>
                            <input type="text" name="area" size="45" value="<c:out value='${service.serviceArea}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Cost:</th>
                        <td>
                            <input type="text" name="cost" size="45" value="<c:out value='${service.serviceCost}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Max People:</th>
                        <td>
                            <input type="text" name="maxPeople" size="45" value="<c:out value='${service.serviceMaxPeople}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Rent Type :</th>
                        <td>
                            <select class="form-control form-select" name="rentType">
                                <option value="1"+ ${rentType1}>Nam</option>
                                <option value="2"+ ${rentType2}>Thang</option>
                                <option value="3"+ ${rentType3}>Ngay</option>
                                <option value="4"+ ${rentType4}>Gio</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Type :</th>
                        <td>
                            <select class="form-control form-select" name="type">
                                <option value="1"+ ${type1}>Villa</option>
                                <option value="2"+ ${type2}>House</option>
                                <option value="3"+ ${type3}>Room</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Standard Room:</th>
                        <td>
                            <input type="text" name="standardRoom" size="45" value="<c:out value='${service.standardRoom}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Description Other Convenience:</th>
                        <td>
                            <input type="text" name="descriptionOtherConvenience" size="45"
                                   value="<c:out value='${service.descriptionOtherConvenience}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Pool Area:</th>
                        <td>
                            <input type="text" name="poolArea" size="45" value="<c:out value='${service.poolArea}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Number of Floors:</th>
                        <td>
                            <input type="text" name="numberOfFloors" size="45"
                                   value="<c:out value='${service.numberOfFloors}' />"/>
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

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
                    <br> <h4>Add New Service</h4>
                    <tr>
                        <th>Name:</th>
                        <td>
                            <input type="text" name="name" size="45"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Area:</th>
                        <td>
                            <input type="text" name="area" size="45"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Cost:</th>
                        <td>
                            <input type="text" name="cost" size="45"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Max People:</th>
                        <td>
                            <input type="text" name="maxPeople" size="45"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Rent Type :</th>
                        <td>
                            <select class="form-control form-select" name="rentType">
                                <option value="1">Nam</option>
                                <option value="2">Thang</option>
                                <option value="3">Ngay</option>
                                <option value="4">Gio</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Type :</th>
                        <td>
                            <select class="form-control form-select" name="type">
                                <option value="1">Villa</option>
                                <option value="2">House</option>
                                <option value="3">Room</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Standard Room:</th>
                        <td>
                            <input type="text" name="standardRoom" size="45"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Description Other Convenience:</th>
                        <td>
                            <input type="text" name="descriptionOtherConvenience" size="45"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Pool Area:</th>
                        <td>
                            <input type="text" name="poolArea" size="45"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Number of Floors:</th>
                        <td>
                            <input type="text" name="numberOfFloors" size="45"/>
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

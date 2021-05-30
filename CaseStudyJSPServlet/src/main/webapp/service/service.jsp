
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
                <strong>Service</strong>
            </div>
            <div class="list-group">
                <a href="furama?action=add-service" class="list-group-item">Add New Service</a>
                <a href="furama?action=list-services" class="list-group-item">List All Services</a>

            </div>
        </div>
    </aside>


</div>


<footer>
    <%@include file="../body/footer.jsp" %>
</footer>

</body>
</html>


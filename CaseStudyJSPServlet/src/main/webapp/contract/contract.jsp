
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


</div>


<footer>
    <%@include file="../body/footer.jsp" %>
</footer>

</body>
</html>


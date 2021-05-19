
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<%
    float firstOperand=Float.parseFloat(request.getParameter("firstOperand"));
    float secondOperand=Float.parseFloat(request.getParameter("secondOperand"));
    String operator= (request.getParameter("operator"));
    out.print(firstOperand+operator+secondOperand+"=");
%>
${result}

</body>
</html>

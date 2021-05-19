
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
    <%
        String productDescription=request.getParameter("productDescription");
        float listPrice=Float.parseFloat(request.getParameter("listPrice"));
        float discountPercent=Float.parseFloat(request.getParameter("discountPercent"));
        out.print("Product Description: "+productDescription+"<br>");
        out.print("List Price: "+listPrice+"<br>");
        out.print("Discount Percent: "+discountPercent+"<br>");
        out.print("Discount Amount: "+listPrice*discountPercent*0.01+"<br>");
        out.print("Discount Price: "+(listPrice-(listPrice*discountPercent*0.01))+"<br>");
    %>





</table>
</body>
</html>

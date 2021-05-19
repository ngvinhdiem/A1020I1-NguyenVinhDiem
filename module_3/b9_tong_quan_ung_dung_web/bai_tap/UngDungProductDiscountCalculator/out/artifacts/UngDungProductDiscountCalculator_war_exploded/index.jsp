<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Product Discount Calculator</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Currency Converter</h2>
<form action="/calculator" method="post">
  <label>Product Description: </label><br/>
  <input type="text" name="productDescription"/><br/>
  <label>List Price: </label><br/>
  <input type="text" name="listPrice"/><br/>
  <label>Discount Percent: </label><br/>
  <input type="text" name="discountPercent"/><br/>
  <input type = "submit" id = "submit" value = "Calculator"/>
</form>
</body>
</html>

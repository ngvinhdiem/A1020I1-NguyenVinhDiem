
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
</head>
<body>
<h3>Caculator</h3>
<form method="post" action="/calculator">
  <input type="number" name="firstNum">
  <input type="number" name="secondNum"><br>

  <input type="submit" name="operator" value="Addition(+)">
  <input type="submit" name="operator" value="Subtraction(-)">
  <input type="submit" name="operator" value="Multiplication(x)">
  <input type="submit" name="operator" value="Division(/)">
</form>
<a>Result: ${result}</a>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
</head>
<body>
<form method="post" action="/currency">
  <table>
    <tr>
      <td>USD</td>
      <td><input type="number" name="usd"></td>
    </tr>
    <tr>
      <td><input type="submit" value="Convert"></td>
    </tr>
  </table>
</form>
<h3>${result}</h3>
</body>
</html>
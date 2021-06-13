<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
</head>
<body>
<form method="post" action="/dictionary">
  <input type="text" name="search" placeholder="Enter your word: ">
  <input type="submit" id="submit" value="Search">
</form>
<a>${result}</a>
</body>
</html>
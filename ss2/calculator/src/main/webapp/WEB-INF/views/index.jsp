<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>calculator
</h1>
<br/>
<form action="/calculator" method="post">
    <input required value="${num1}" type="number" name="num1">
    <input required value="${num2}" type="number" name="num2">
    <br>
    <br>
    <button name="action" type="submit" value="add">Addition</button>
    <button name="action" type="submit" value="sub">Subtraction</button>
    <button type="submit" name="action" value="div">Division</button>
    <button type="submit" value="mul" name="action">Multiplication</button>
    <br>
    <br>
    <h2>Result:${action}  ${result}</h2>
</form>


</body>
</html>
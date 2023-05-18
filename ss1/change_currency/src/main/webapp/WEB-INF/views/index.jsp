<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1 style="text-align: center"><%= "Hello World!" %>
</h1>
<br/>
<div style="text-align: center"><form  action="/" method="post">
    <input width="100px" name="usd" type="number" placeholder="USD" value="${usd}">
    <br>
    <br>
    <input width="100px" name="vnd" type="number" placeholder="VND" value="${vnd}">
    <br>
    <br>
    <button  type="submit">CONVERT</button>
    <h2 style="color: red">${result}</h2>
</form></div>





</body>
</html>
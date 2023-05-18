<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1 style="text-align: center">Translator
</h1>
<br/>
<form style="text-align: center" action="/" method="post">
<input value="${english}" name="english" type="text" placeholder="Enter english vocabulary">
    <br>
    <br>
    <br>
    <button type="submit">
        translate
    </button>
    <br>
    <br>
    <br>
    <h2>${viet}</h2>
</form>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="	https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js">
</head>
<body>
<h1 style="text-align: center">Choose Your Own Ingredients
</h1>
<br/>
<div style="margin: 0 auto" >

    <form style="width: 30%" action="/add" method="post">
        <div class="form-check form-switch">
            <input value="lettuce" name="ingredient" class="form-check-input" type="checkbox" id="flexSwitchCheckDefault">
            <label class="form-check-label" for="flexSwitchCheckDefault">Lettuce</label>
        </div>
        <div class="form-check form-switch">
            <input value="tomato" name="ingredient" class="form-check-input" type="checkbox" id="flexSwitchCheckDefault1">
            <label class="form-check-label" for="flexSwitchCheckDefault1">Tomato</label>
        </div>
        <div class="form-check form-switch">
            <input value="mustard" name="ingredient" class="form-check-input" type="checkbox" id="flexSwitchCheckDefault2">
            <label class="form-check-label" for="flexSwitchCheckDefault2">Mustard</label>
        </div>
        <div  class="form-check form-switch">
            <input value="sprouts" name="ingredient" class="form-check-input" type="checkbox" id="flexSwitchCheckDefault3">
            <label class="form-check-label" for="flexSwitchCheckDefault3">Sprouts</label>
        </div>
        <button  class="btn btn-success" type="submit">Save</button>
    </form>
    <h1>You have chosen</h1>
<c:forEach var="list" items="${list}">
    <h2>${list}</h2>
</c:forEach>
</div>


</body>
</html>
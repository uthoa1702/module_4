<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1> Settings
</h1>
<br/>
<div style="display: inline-block">
    <fieldset>
        <form:form action="update" method="post" modelAttribute="emailContainer">
            <table>
                <tr>
                    <td><b>Languages</b></td>
                    <td>
                        <form:select path="language" items="${languages}"/>

                    </td>
                </tr>

                <tr>
                    <td>
                        <b>Page size:</b>
                    </td>
                    <td>
                        Show
                        <form:select path="pages" items="${pageSizes}"/>

                        emails per page
                    </td>
                </tr>

                <tr>
                    <td>
                        <b>Spams filter:</b>
                    </td>
                    <td>
                        <form:checkbox path="spamFilter"/> Enable spam filter
                    </td>
                </tr>

                <tr>
                    <td><b>Signature</b></td>
                    <td>
                        <form:textarea path="signature"/>
                    </td>
                </tr>

                <tr>
                    <td></td>
                    <td>
                        <button type="submit">Update</button>
                        <button type="reset">Cancel</button>
                    </td>
                </tr>


            </table>


        </form:form>

    </fieldset>


</div>


</body>
</html>
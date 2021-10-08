<%-- 
    Document   : login
    Created on : 7-Oct-2021, 3:41:25 PM
    Author     : bdavi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <div>
            <form method="post" action="login">
                Username: <input type="text" name="username" value="${uname}" required><br>
                Password: <input type="password" name="password" value="${psswd}" required><br>
                <input type="submit" value="Log in">
            </form>
            <%--Everything within the c: tag is part of JSTL
            <c:if test="${invalidInput}">
                <p>"Invalid login"</p>
            </c:if>--%>
            <c:choose>
                <c:when test="${invalidInput}">
                    <p>"Invalid login"</p>
                </c:when>
                <c:when test="${loggedOut}">
                    <p>"You have successfully logged out"</p>
                </c:when>
            </c:choose>
        </div>
    </body>
</html>

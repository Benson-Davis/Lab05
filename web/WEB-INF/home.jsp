<%-- 
    Document   : home
    Created on : 8-Oct-2021, 9:57:40 AM
    Author     : bdavi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <h3>Hello ${uname}</h3>
        <a href="login?logout">Log out</a><%-- create a parameter called logout, and if it has been clicked(isn't null) then load login--%>
    </body>
</html>

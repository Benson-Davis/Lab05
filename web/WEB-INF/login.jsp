<%-- 
    Document   : login
    Created on : 7-Oct-2021, 3:41:25 PM
    Author     : bdavi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                Username: <input type="text" name="username" value=""><br>
                Password: <input type="text" name="password" value=""><br>
                <input type="submit" value="Log in">
            </form>
        </div>
    </body>
</html>

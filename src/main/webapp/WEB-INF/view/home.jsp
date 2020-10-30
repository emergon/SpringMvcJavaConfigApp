<%-- 
    Document   : home
    Created on : Oct 30, 2020, 7:04:02 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World, This is Home Page</h1>
        
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/customer">Customers</a>
            </li>
        </ul>
    </body>
</html>

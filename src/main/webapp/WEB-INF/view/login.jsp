<%-- 
    Document   : login
    Created on : Nov 2, 2020, 7:08:22 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Please login</h1>
        <h3>${message}</h3>
        <form:form action="${pageContext.request.contextPath}/login" 
                   method="POST" 
                   modelAttribute="xrhsths">
            Username: <form:input path="username"/>
            <form:errors path="username"/>
            <br/>
            Password: <form:password path="password"/>
            <form:errors path="password" cssStyle="color:red"/>
            <br/>
            DOB:<input type="date" name="dob"/>
            <form:errors path="dob"/>
            <br/>
            <input type="submit" value="Login"/>
        </form:form>
    </body>
</html>

<%-- 
    Document   : header
    Created on : Nov 2, 2020, 8:16:01 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Spring Application</h1>
<h3>You are logged in as ${xrhsths.username}</h3>
<p>
    <a href="${pageContext.request.contextPath}/logout">Logout</a>
</p>
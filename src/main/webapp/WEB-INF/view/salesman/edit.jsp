<%-- 
    Document   : edit
    Created on : Oct 30, 2020, 8:55:31 PM
    Author     : user
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../styling/styling.css" />
        <title>Edit Salesman</title>
    </head>
    <body>
        <%--<%@include file="../header.jsp" %>--%>
        <section class="container">
            <h2>Create Salesman</h2>
            <form:form class="form" 
                       action="${pageContext.request.contextPath}/salesman/edit" 
                       method="POST"
                       modelAttribute="salesman">
                <div>
                    <label for="salesmanid">Id</label>
                    <form:input id="salesmanid" path="scode" readonly="true"/>
                </div>
                <div>
                    <label for="sname">Enter Name</label>
                    <form:input id="sname" path="sname"/>
                    <form:errors path="sname"/>
                </div>
                <div>
                    <label for="scity">Enter City</label>
                    <form:input id="scity" path="scity"/>
                    <form:errors path="scity"/>
                </div>
                <div>
                    <label for="scomm">Enter Commission</label>
                    <input id="scomm" type="number" step="0.01" name="scomm" value="${salesman.scomm}"/>
                    <form:errors path="scomm"/>
                </div>
                <input class="btn" type="submit" value="Submit"/>
            </form:form>
        </section>
        <%--<jsp:include page="../footer.jsp"/>--%>
    </body>
</html>

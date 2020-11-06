<%-- 
    Document   : create
    Created on : Oct 30, 2020, 8:20:11 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Salesman</title>
        <link rel="stylesheet" href="../styling/styling.css" />
    </head>
    <body>
        <%--<jsp:include page="../header.jsp"/>--%>
        <section class="container">
            <h2>Create Salesman</h2>
            <form:form class="form" 
                       action="${pageContext.request.contextPath}/salesman/create" 
                       modelAttribute="salesman" 
                       method="POST">
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
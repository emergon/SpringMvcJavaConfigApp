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
        <title>Create Customer</title>
        <link rel="stylesheet" href="../styling/styling.css" />
    </head>
    <body>
        <%--<jsp:include page="../header.jsp"/>--%>
        <section class="container">
            <h2>Create Customer</h2>
            <form:form class="form" 
                       action="${pageContext.request.contextPath}/customer/create" 
                       modelAttribute="customer" 
                       method="POST">
                <label for="cname">Enter Name</label>
                <!--path: getter is called when loading, setter is called when submitting-->
                <!--path attribute will be populated from modelAttribute-->
                <form:input id="cname" path="cname"/>
                <input class="btn" type="submit" value="Submit"/>
            </form:form>
        </section>

        <%--<jsp:include page="../footer.jsp"/>--%>
    </body>
</html>
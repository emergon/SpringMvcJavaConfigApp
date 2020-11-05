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
        <title>Create Product</title>
        <link rel="stylesheet" href="../styling/styling.css" />
    </head>
    <body>
        <%--<jsp:include page="../header.jsp"/>--%>
        <section class="container">
            <h2>Create Product</h2>
            <form:form class="form" 
                       action="${pageContext.request.contextPath}/product/create" 
                       modelAttribute="product" 
                       method="POST">
                <div>
                    <label for="description">Enter description</label>
                    <form:input id="description" path="pdescr"/>
                    <form:errors path="pdescr"/>
                </div>
                <div>
                    <label for="price">Enter price</label>
                    <input id="price" type="number" name="pprice"/>
                    <form:errors path="pprice"/>
                </div>

                <input class="btn" type="submit" value="Submit"/>
            </form:form>
        </section>

        <%--<jsp:include page="../footer.jsp"/>--%>
    </body>
</html>
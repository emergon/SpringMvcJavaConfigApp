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
        <title>Edit Product</title>
    </head>
    <body>
        <%--<%@include file="../header.jsp" %>--%>
        <section class="container">
            <h2>Create Product</h2>
            <form:form class="form" 
                       action="${pageContext.request.contextPath}/product/edit" 
                       method="POST"
                       modelAttribute="product">
                <div>
                    <label for="productid">Id</label>
                    <form:input id="productid" path="pcode" readonly="true"/>
                </div>
                <div>
                    <label for="description">Enter description</label>
                    <form:input id="description" path="pdescr"/>
                    <form:errors path="pdescr"/>
                </div>
                <div>
                    <label for="price">Enter price</label>
                    <input id="price" type="number" name="pprice" value="${product.pprice}"/>
                    <form:errors path="pprice"/>
                </div>
                <input class="btn" type="submit" value="Submit"/>
            </form:form>
        </section>
        <%--<jsp:include page="../footer.jsp"/>--%>
    </body>
</html>

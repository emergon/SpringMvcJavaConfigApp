<%-- 
    Document   : productList
    Created on : 10 Οκτ 2020, 8:38:50 μμ
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products List</title>
        <link rel="stylesheet" href="styling/styling.css" />
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container">
            <h2>List Of Products</h2>
            <div class="btn-area">
                <a  class="btn" href="${pageContext.request.contextPath}/product/create">Create A New Product</a> 
            </div>
            <p>
                ${productMessage}
            </p>
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th colspan="2">Action</th>
                    </tr>
                </thead>
                <tbody> 
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td>${product.pcode}</td>
                            <td>${product.pdescr}</td>
                            <td>${product.pprice}</td>
                            <td class="buttontd"><a class="btn" href="product/edit?kwdikos=${product.pcode}">Edit</a></td>
                            <td class="buttontd"><a class="btn" href="product/delete?id=${product.pcode}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>


            </table>
        </section>

        <%--<jsp:include page="../footer.jsp"/>--%>

    </body>
</html>
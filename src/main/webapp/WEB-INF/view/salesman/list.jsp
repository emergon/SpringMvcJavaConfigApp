<%-- 
    Document   : salesmanList
    Created on : 10 Οκτ 2020, 8:38:50 μμ
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salesmen List</title>
        <link rel="stylesheet" href="styling/styling.css" />
    </head>
    <body>
        <jsp:include page="../header.jsp"/>
        <section class="container">
            <h2>List Of Salesmen</h2>
            <div class="btn-area">
                <a  class="btn" href="${pageContext.request.contextPath}/salesman/create">Create A New Salesman</a> 
            </div>
            <p>
                ${salesmanMessage}
            </p>
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>City</th>
                        <th>Commission</th>
                        <th colspan="2">Action</th>
                    </tr>
                </thead>
                <tbody> 
                    <c:forEach items="${salesmen}" var="salesman">
                        <tr>
                            <td>${salesman.scode}</td>
                            <td>${salesman.sname}</td>
                            <td>${salesman.scity}</td>
                            <td>${salesman.scomm}</td>
                            <td class="buttontd"><a class="btn" href="salesman/edit?kwdikos=${salesman.scode}">Edit</a></td>
                            <td class="buttontd"><a class="btn" href="salesman/delete?id=${salesman.scode}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>


            </table>
        </section>

        <%--<jsp:include page="../footer.jsp"/>--%>

    </body>
</html>
<%--<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<html>--%>
<%--    <head>--%>
<%--        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">--%>
<%--        <title>List Todos Page</title>--%>
<%--    </head>--%>
<%--    <body>--%>

<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>


        <div class="container">
        <hr>
        <div><h2 style="background-color: beige">To do List</h2></div>
        <table class="table">
            <thead>
                <tr>
                    <th>id</th>
                    <th>Description</th>
                    <th>target Date</th>
                    <th>Is Done </th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>
                            ${todo.id}
                        </td>
                        <td>
                                ${todo.description}
                        </td>
                        <td>
                                ${todo.targetDate}
                        </td>
                        <td>
                                ${todo.done}
                        </td>
                        <td>
                            <a href="delete-todo?id=${todo.id}" class="btn btn-warning"> DELETE </a>
                        </td>
                        <td>
                            <a href="update-todo?id=${todo.id}" class="btn btn-success"> UPDATE </a>
                        </td>
                    </tr>

                </c:forEach>
            </tbody>
        </table>
            <a href="add-todo" class="btn btn-success">Add Todo</a>
        </div>
<%@ include file="common/footer.jspf" %>
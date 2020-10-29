<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Statistics</title>
    <h1>Exposition statistics</h1>

    <meta charset="UTF-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a  class="navbar-brand" href="/">Exhibitions</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <a href="/?lang=en">English</a>
            &nbsp;&nbsp;

            <a  href="/?lang=ua">Ukraine</a>

            <div style="text-align: right;padding:5px;margin:5px 0px;" >
                <a href="/login" class="btn btn-primary">Login</a>
            </div>
            <div style="text-align: right;padding:5px;margin:5px 0px;" >
                <a  href="/logout" >Logout</a>
            </div>
        </form>
    </div>
</nav>
<div class="container my-2">
    <h1>Exposition List</h1>
    <table border="1" class="table table-striped table-responsive-md">
        <thead>
        <tr>
            <th>
                <a href="'/page/' + ${currentPage} + '?sortField=theme&sortDir=' + ${reverseSortDir}">
                    Theme</a>
            </th>
            <th>
                <a href="@{'/page/' + ${currentPage} + '?sortField=price&sortDir=' + ${reverseSortDir}}">
                    Price</a>
            </th>
            <th>
                <a href="@{'/page/' + ${currentPage} + '?sortField=date&sortDir=' + ${reverseSortDir}}">
                    Date</a>
            </th>
            <th>
                <a href="@{'/page/' + ${currentPage} + '?sortField=halls&sortDir=' + ${reverseSortDir}}">
                    Halls</a>
            </th>

            <th>Purchased tickets</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${expositions}" var="exposition">
            <tr>
                <td> ${exposition.theme}</td>
                <td>${exposition.price}</td>
                <td>${exposition.date}</td>
                <td><c:forEach items="${exposition.halls}" var="hall">
                    ${hall.name}
                </c:forEach>
                </td>
                <td>${exposition.countOfTickets}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%--    <div th:if="${totalPages > 1}">--%>
    <%--        <div class="row col-sm-10">--%>
    <%--            <div class="col-sm-2">--%>
    <%--                Total Rows: [[${totalItems}]]--%>
    <%--            </div>--%>
    <%--            <div class="col-sm-2">--%>
    <%--					<span th:each="i: ${#numbers.sequence(1, totalPages)}">--%>
    <%--						<a th:if="${currentPage != i}"--%>
    <%--                           th:href="@{'/page/' + ${i}+ '?sortField=' + ${sortField} + '&sortDir=' + ${sortDir}}">[[${i}]]</a>--%>
    <%--						<span th:unless="${currentPage != i}">[[${i}]]</span>  &nbsp; &nbsp;--%>
    <%--					</span>--%>
    <%--            </div>--%>
    <%--            <div class="col-sm-1">--%>
    <%--                <a th:if="${currentPage < totalPages}"--%>
    <%--                   th:href="@{'/page/' + ${currentPage + 1}+ '?sortField=' + ${sortField} + '&sortDir=' + ${sortDir}}" data-th-text="#{label.next}">Next</a>--%>
    <%--                <span th:unless="${currentPage < totalPages}" data-th-text="#{label.next}">Next</span>--%>
    <%--            </div>--%>

    <%--            <div class="col-sm-1">--%>
    <%--                <a th:if="${currentPage < totalPages}"--%>
    <%--                   th:href="@{'/page/' + ${totalPages}+ '?sortField=' + ${sortField} + '&sortDir=' + ${sortDir}}" data-th-text="#{label.last}">Last</a>--%>
    <%--                <span th:unless="${currentPage < totalPages}" data-th-text="#{label.last}">Last</span>--%>
    <%--            </div>--%>
    <%--        </div>--%>
    <%--    </div>--%>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
        crossorigin="anonymous"></script>

</body>
</html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="pagecontent"/>
<html lang="${sessionScope.lang}">
<head>
    <meta charset="UTF-8">
    <title>Simple Web Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>

<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/"><fmt:message key="label.Expositions"/></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <form action="/filterByDate" method="post">
        <div><fmt:message key="label.FilterByDate"/></div>
        <input type="date" name="filterDate" value="${filterDate}">
        <button type="submit">Find</button>
    </form>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <a href="?sessionLocale=en"><fmt:message key="label.English"/></a>
            &nbsp
            <a href="?sessionLocale=uk"><fmt:message key="label.Ukraine"/></a>
            &nbsp
<%--            <c:choose>--%>
<%--                <c:when test="${role!='NULL'}">--%>
                    <div style="text-align: right;padding:5px;margin:5px 0px;" >
                        <a  href="/login" class="btn btn-primary"><fmt:message key="label.Login"/></a>
                    </div>
<%--                </c:when>--%>
<%--            </c:choose>--%>
<%--            <c:choose>--%>
<%--                <c:when test="${role=='NULL'}">--%>
                    <div style="text-align: right;padding:5px;margin:5px 0px;" >
                        <a href="/logout"  ><fmt:message key="label.Logout"/></a>
                    </div>
<%--                </c:when>--%>
<%--            </c:choose>--%>
        </form>
    </div>
</nav>

<div class="container my-2">
    <h1><fmt:message key="label.ExpositionList"/></h1>
    <c:choose>
        <c:when test="${role=='ADMIN'}">
            <a href="/admin/addExposition.jsp" class="btn btn-primary btn-sm mb-3"> <fmt:message key="label.AddExposition"/> </a>
            <a href="/admin/userList" class="btn btn-primary btn-sm mb-3"><fmt:message key="label.UserList"/></a></span
            <span><a href="/admin/statistics" class="btn btn-primary btn-sm mb-3"><fmt:message key="label.Statistics"/></a></span>
        </c:when>
    </c:choose>

    <table border="1" class="table table-striped table-responsive-md">
        <thead>
        <tr>
            <th>
                <a href="'/page/' + ${currentPage} + '?sortField=theme&sortDir=' + ${reverseSortDir}">
                    <fmt:message key="label.Theme"/></a>
            </th>
            <th>
                <a href="@{'/page/' + ${currentPage} + '?sortField=price&sortDir=' + ${reverseSortDir}}">
                    <fmt:message key="label.Price"/></a>
            </th>
            <th>
                <a href="@{'/page/' + ${currentPage} + '?sortField=date&sortDir=' + ${reverseSortDir}}">
                    <fmt:message key="label.Date"/></a>
            </th>
            <th>
                <a href="@{'/page/' + ${currentPage} + '?sortField=halls&sortDir=' + ${reverseSortDir}}">
                    <fmt:message key="label.Halls"/></a>
            </th>
            <c:choose>
            <c:when test="${role=='ADMIN'||role=='USER'}">
            <th>  <fmt:message key="label.Actions"/></th>
            </c:when>
            </c:choose>
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
                <td>
                    <c:choose>
                    <c:when test="${role=='ADMIN'}">
                    <a href="/admin/updateExposition?id=${exposition.id}"
                       class="btn btn-primary"><fmt:message key="label.Update"/></a>
                    <a href="/admin/deleteExposition?id=${exposition.id}"
                       class="btn btn-danger"><fmt:message key="label.Delete"/></a>
                    <a href="/admin/addHalls?id=${exposition.id}"
                       class="btn btn-outline-success my-2 my-sm-0"><fmt:message key="label.AddHalls"/></a>
                        <a href="/buyTicket?id=${exposition.id}" class="btn btn-outline-success my-2 my-sm-0"><fmt:message key="label.BuyTicket"/></a>
                        </c:when>
                            <c:when test="${role=='USER'}">
                    <a href="/buyTicket?id=${exposition.id}" class="btn btn-outline-success my-2 my-sm-0"><fmt:message key="label.BuyTicket"/></a>
                        </c:when>
                        </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="showExpositions?page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
    <c:if test="${currentPage lt noOfPages}">
        <td><a href="showExpositions?page=${currentPage + 1}"><fmt:message key="label.Next"/></a></td>
    </c:if>
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
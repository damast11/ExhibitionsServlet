<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="pagecontent"/>

<html lang="${sessionScope.lang}" >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><fmt:message key="label.Expositions"/></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/showExpositions" ><fmt:message key="label.Expositions"/></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <a href="/showExpositions"><fmt:message key="label.ShowExpositions"/></a>


    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <a href="?sessionLocale=en" ><fmt:message key="label.English"/></a>
            &nbsp;&nbsp
            <a href="?sessionLocale=uk" ><fmt:message key="label.Ukraine"/></a>
            &nbsp;&nbsp
<%--<c:choose>--%>
<%--    <c:when test="${role!='NULL'}">--%>
            <div style="text-align: right;padding:5px;margin:5px 0px;" >
                <a  href="/login" class="btn btn-primary"><fmt:message key="label.Login"/></a>
            </div>
<%--    </c:when>--%>
<%--</c:choose>--%>
<%--<c:choose>--%>
<%--    <c:when test="${role=='NULL'}">--%>
            <div style="text-align: right;padding:5px;margin:5px 0px;" >
                <a href="/logout"  ><fmt:message key="label.Logout"/></a>
            </div>
<%--    </c:when>--%>
<%--</c:choose>--%>
        </form>
    </div>
</nav>
<style>
    .parent {
        margin: 20%; /* Отступы вокруг элемента */
        padding: 10px; /* Поля вокруг текста */
    }
</style>
<div class="parent">
<p align="center"> <fmt:message key="label.Task"/></p>
</div>
</body>
</html>

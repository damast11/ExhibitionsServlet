<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="pagecontent"/>
<!DOCTYPE html>

<html lang="${sessionScope.lang}">
<head>
    <meta charset="UTF-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/showExpositions"><fmt:message key="label.Expositions"/></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>


    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <a href="?sessionLocale=en"><fmt:message key="label.English"/></a>
            &nbsp;&nbsp
            <a href="?sessionLocale=uk"><fmt:message key="label.Ukraine"/></a>
            &nbsp;&nbsp; &nbsp
            <div style="text-align: right;padding:5px;margin:5px 0px;">
                <a href="/login" class="btn btn-primary"><fmt:message key="label.Login"/></a>
            </div>
            <div style="text-align: right;padding:5px;margin:5px 0px;">
                <a href="/logout"><fmt:message key="label.Logout"/></a>
            </div>
        </form>
    </div>
</nav>

<div class="container">
    <fmt:message key="label.AddNewUser"/>
</div>
<div class="container">
    <form action="/registration" method="post">
        <fmt:message key="label.Login"/>: <input type="text" name="username" class="form-control mb-4 col-4"/>

        <fmt:message key="label.Password"/>: <input type="password" name="password" class="form-control mb-4 col-4"/>

        <button type="submit" class="btn btn-info col-2"> Sign in</button>
    </form>
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
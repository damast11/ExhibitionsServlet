<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="pagecontent"/>

<html lang="${sessionScope.lang}">
<head>
    <title>Login in system</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<%
    response.setHeader("Cache-Control","no-store");
%>
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

        </form>
    </div>
</nav>
<div class="container">
    <form action="/login" method="post">
        <fmt:message key="label.Login"/> <input type="text" name="name" class="form-control mb-4 col-4"/>

        <fmt:message key="label.Password"/> <input type="password" name="pass" class="form-control mb-4 col-4"/>

        <button  type="submit"  class="btn btn-info col-2"> <fmt:message key="label.SignIn"/></button>
    </form>
    <a href="registration.jsp" class="btn btn-info col-2"><fmt:message key="label.Registration"/></a>
</div>


</body>
</html>
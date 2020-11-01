<!DOCTYPE html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="pagecontent"/>
<html lang="en"
      xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="ISO-8859-1">
    <title >Update Exposition</title>

    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/" >Exhibitions</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <a href="/?lang=en">English</a>
            &nbsp;&nbsp;
            <c:choose>
                <c:when test="${role!='NULL'}">
                    <div style="text-align: right;padding:5px;margin:5px 0px;" >
                        <a  href="/login" class="btn btn-primary"><fmt:message key="label.Login"/></a>
                    </div>
                </c:when>
            </c:choose>
            <c:choose>
                <c:when test="${role=='NULL'}">
                    <div style="text-align: right;padding:5px;margin:5px 0px;" >
                        <a href="/logout"  ><fmt:message key="label.Logout"/></a>
                    </div>
                </c:when>
            </c:choose>
        </form>
    </div>
</nav>

<div class="container">
    <hr>
    <h2 >Add Exhibition</h2>

    <form action=/admin/addExposition  method="POST" >

        <input type="hidden" name="id" value=${exposition.id} />

        <input type="text" name="theme" value=${exposition.theme}>

        <input type="text" name="price" value=${exposition.price} >

        <input type="date" name="date" value=${exposition.date}>

        <button type="submit" class="btn btn-info col-2" >Add</button>
    </form>

    <hr>

    <a href =${pageContext.request.contextPath}/showExpositions> Back</a>
</div>
</body>
</html>
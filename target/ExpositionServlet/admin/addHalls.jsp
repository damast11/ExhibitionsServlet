<!DOCTYPE HTML>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="pagecontent"/>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title >Developer</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
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
            <a href="/?lang=en" >English</a>
            <a href="/?lang=en" >Ukraine</a>
            &nbsp;&nbsp;

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
        </form>
    </div>
</nav>

<h1 >Add hall</h1>

    <div class="col-md-4">
        <div class="panel panel-default">
            <div class="panel-heading" >Exposition info</div>
            <div class="panel-body" style="padding-left: 5px;">
                Theme: "${exposition.theme}" <br/>
                Price: "${exposition.price}" <br/>
                Date: "${exposition.date}" <br/>
                <br/>Halls:
                <c:forEach items="${halls}" var="hall">
                <tr>
                    <td>"${hall.name}"</td>
                </tr>
                </c:forEach>
            </div>
        </div>
        <form action="/admin/addHallsToExposition?id=${exposition.id}" method="post"  >
        <div class="col-md-6">
            <select class="form-control" name="hallId">
                <c:forEach items="${halls}" var="hall">
                <option  value="${hall.id}">${hall.name}</option>
                </c:forEach>
            </select>
        </div>
        <input type="submit" class="btn btn-success" value="Add Hall"/>
        </form>
    </div>
</form>
</body>
</html>
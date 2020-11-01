<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="pagecontent"/>

<html>
<head>
    <title>Title</title>

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
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <div style="text-align: center;padding:5px;margin:5px 0px;">
        <c:forEach items="${users}" var="user">
            <tr>
                <td> ${user.username}</td>
                <td> ${user.role}</td>
            </tr>
        </c:forEach>
    </div>
    </tbody>
</table>
<a href =${pageContext.request.contextPath}/showExpositions> Back</a>
</body>
</html>

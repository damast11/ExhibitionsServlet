<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="pagecontent"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="label.TicketBought"/></title>
    <h1> <fmt:message key="label.TicketBought"/></h1>
    <a href="/showExpositions"><fmt:message key="label.GoBack"/> </a>
</head>
<body>

</body>
</html>
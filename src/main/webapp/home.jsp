<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Index</title>
</head>
<body>
<c:if test="${sessionScope.user==null}">
    <p>Hello Guest</p>
    <a href="/registration">Registration</a>
    <a href="/authorization">Authorization</a>
</c:if>
<c:if test="${sessionScope.user!=null}">
    <p>Hello ${sessionScope.user.name}</p>
    <a href="/calc">Calculator</a>
    <a href="/logout">Logout</a>
</c:if>

<c:forEach items="${requestScope.users}" var="user">
    <p> ${user.name}</p>
</c:forEach>

</body>
</html>
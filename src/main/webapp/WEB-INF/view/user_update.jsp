<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${not empty user}">
        <h1>Update User ${user.id}</h1>
        <form action="${pageContext.request.contextPath}/user/update?id=${user.id}" method="POST">
            <label>
                <span>Username</span>
                <input type="text" name="username" placeholder="username" value="${user.username}" />
            </label><br>
            <input type="hidden" name="_method" value="PUT" />
            <input type="submit" value="Submit">
        </form>
    </c:when>
    <c:otherwise>
        <span>An error has occurred!</span>
    </c:otherwise>
</c:choose>
</body>
</html>

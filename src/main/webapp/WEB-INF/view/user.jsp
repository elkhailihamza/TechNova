<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>USER LIST</h1>
    <jsp:useBean id="users" scope="request" type="java.util.List"/>
    <c:choose>
        <c:when test="${not empty users}">
            <ul>
                <c:forEach var="user" items="${users}">
                    <li>
                        Name: ${user.username}
                    </li>
                </c:forEach>
            </ul>
        </c:when>
        <c:otherwise>
            <p>No users can be found!</p>
        </c:otherwise>
    </c:choose>

    <form action="${pageContext.request.contextPath}/user" method="POST">
        <label>
            <span>Username</span>
            <input type="text" name="username" placeholder="username" />
        </label><br>
        <label>
            <span>Password</span>
            <input type="password" name="password" placeholder="password" />
        </label><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>

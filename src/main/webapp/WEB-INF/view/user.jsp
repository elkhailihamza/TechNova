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
                    <li style="display: flex; gap: 16px; justify-items: center">
                        Name: ${user.username}
                        <form action="${pageContext.request.contextPath}/user?id=${user.id}" method="POST">
                            <input type="hidden" name="_method" value="DELETE">
                            <button type="submit" style="cursor: pointer; background: transparent; border: 0">
                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="#000000" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><line x1="18" y1="6" x2="6" y2="18"></line><line x1="6" y1="6" x2="18" y2="18"></line></svg>
                            </button>
                        </form>
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

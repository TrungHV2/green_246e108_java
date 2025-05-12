<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form action="/login" method="post">
        <input type="text" placeholder="Tài khoản..." name="username" value="${username}"><br>
        <input type="password" placeholder="Mật khẩu..." name="password" value="${password}"><br>
        <label for="">
            <c:if test="${remember == 'true'}">
                <input type="checkbox" value="true" name="remember" checked> Remember
            </c:if>
            <c:if test="${remember != 'true'}">
                <input type="checkbox" value="true" name="remember"> Remember
            </c:if>
        </label>
        <button>Login</button>
    </form>
</body>
</html>

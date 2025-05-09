<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Categories</title>
    <style>
        .active {
            color: red;
            font-weight: bold;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <h1>List Categories</h1>
    <p>
        <a href="/categories?action=create">Thêm mới</a>
    </p>
    <table border="1" cellspacing="0" cellpadding="3" width="100%">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Action</th>
        </tr>
        <c:forEach var="c" items="${pageable.data}">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>
                    <a href="">Edit</a> |
                    <a href="">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p>
        <c:forEach var="i" begin="1" end="${pageable.total}">
            <c:if test="${pageable.page == i}">
                <a href="javascripts:void(0)" class="active">${i}</a> |
            </c:if>
            <c:if test="${pageable.page != i}">
                <a href="/categories?page=${i}">${i}</a> |
            </c:if>
        </c:forEach>
    </p>
</body>
</html>

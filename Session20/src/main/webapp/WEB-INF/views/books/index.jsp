<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1" cellspacing="0" cellpadding="3" width="100%">
        <tr>
            <th>Id</th>
            <th>Category</th>
            <th>Book Name</th>
            <th>Author</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        <c:forEach var="b" items="${books}">
            <tr>
                <td>${b.bookId}</td>
                <td>${b.category.name}</td>
                <td>${b.bookName}</td>
                <td>${b.author}</td>
                <td>${b.price}</td>
                <td>
                    <a href="">Edit</a> |
                    <a href="">Remove</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

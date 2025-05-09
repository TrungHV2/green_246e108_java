<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>List books</title>
</head>
<body>
    <h1>List books</h1>
    <p>
        <a href="/book-add">Thêm mới</a>
    </p>
    <p>
    <form action="/book-list" method="get">
        <input type="text" placeholder="Tìm kiếm...."> <button>Tìm</button>
    </form>
    </p>
    <table border="1" cellpadding="3" cellspacing="0" width="100%">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Author</th>
            <th>Category</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        <c:forEach var="b" items="${data}">
            <tr>
                <td>${b.bookId}</td>
                <td>${b.bookName}</td>
                <td>${b.author}</td>
                <td>${b.categoryId}</td>
                <td>${b.price}</td>
                <td>
                    <a href="/book-edit?bookId=${b.bookId}">Edit</a> |
                    <a onclick="return confirm('Bạn có muốn xóa không?');" href="/book-delete?bookId=${b.bookId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

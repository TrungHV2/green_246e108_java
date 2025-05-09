<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit book</title>
</head>
<body>
<h1>Book Info</h1>
<form action="/book-edit" method="post">
    <input type="hidden" name="bookId" readonly value="${book.bookId}">
    <table cellpadding="3" cellspacing="0">
        <tr>
            <th>BookName</th>
            <td><input type="text" name="bookName" value="${book.bookName}"></td>
        </tr>
        <tr>
            <th>Author</th>
            <td><input type="text" name="author" value="${book.author}"></td>
        </tr>
        <tr>
            <th>Category</th>
            <td>
                <select name="categoryId">
                    <c:forEach items="${categories}" var="c">
                        <c:if test="${book.categoryId == c.id}">
                            <option value="${c.id}" selected>${c.name}</option>
                        </c:if>
                        <c:if test="${book.categoryId != c.id}">
                            <option value="${c.id}">${c.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>Price</th>
            <td><input type="number" name="price" value="${book.price}"></td>
        </tr>
        <tr>
            <td><a href="/book-list">Back</a></td>
            <td><button>Update</button></td>
        </tr>
    </table>
</form>
</body>
</html>

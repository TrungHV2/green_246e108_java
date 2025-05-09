<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new book</title>
</head>
<body>
    <h1>Book Info</h1>
    <form action="/book-add" method="post">
        <table cellpadding="3" cellspacing="0">
            <tr>
                <th>Id</th>
                <td><input type="text" name="bookId"></td>
            </tr>
            <tr>
                <th>BookName</th>
                <td><input type="text" name="bookName"></td>
            </tr>
            <tr>
                <th>Author</th>
                <td><input type="text" name="author"></td>
            </tr>
            <tr>
                <th>Category</th>
                <td>
                    <select name="categoryId">
                        <c:forEach items="${categories}" var="c">
                            <option value="${c.id}" selected>${c.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Price</th>
                <td><input type="number" name="price"></td>
            </tr>
            <tr>
                <td><a href="/book-list">Back</a></td>
                <td><button>Save</button></td>
            </tr>
        </table>
    </form>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Categories list</h1>
    <table border="1" cellpadding="3" cellspacing="0" width="100%">
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Action</th>
      </tr>
      <c:forEach items="${data}" var="c">
        <tr>
          <td>${c.id}</td>
          <td>${c.name}</td>
          <td>
            <a href="">Edit</a> |
            <a href="">Remove</a>
          </td>
        </tr>
      </c:forEach>
    </table>
</body>
</html>

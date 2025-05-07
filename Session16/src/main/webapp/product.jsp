<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Products list</title>
</head>
<body>
    <h1>Id: ${id}</h1>
    <h1>List products</h1>
    <table border="1" cellpadding="5" cellspacing="0" width="100%">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Created</th>
            <th>Status</th>
        </tr>
        <c:forEach items="${data}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td><fmt:formatNumber value="${p.price}" /></td>
                <td><fmt:formatDate value="${p.created}" pattern="dd/MM/yyyy HH:mm:ss" /></td>
                <c:if test="${p.status}">
                    <td>Còn hàng</td>
                </c:if>
                <c:if test="${!p.status}">
                    <td>Hết hàng</td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Student</title>
</head>
<body>
    <h1>Student Info</h1>
    <f:form action="/student/add" method="post" modelAttribute="st">
        <f:input path="id" /> <br>
        <f:input path="name" /><br>
        <f:input path="age" /><br>
        <button>Save</button>
    </f:form>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Product Create</title>
    <style>
        .txt_error {
            color: darkred;
            font-style: italic;
        }
    </style>
</head>
<body>
    <h1>Product info</h1>
    <f:form action="/product/create" method="post" modelAttribute="product" enctype="multipart/form-data">
        <table cellpadding="3">
            <tr>
                <th>Id</th>
                <td>
                    <f:input path="productId" /> <br>
                    <f:errors path="productId" cssClass="txt_error" />
                </td>
            </tr>
            <tr>
                <th>Name</th>
                <td>
                    <f:input path="productName" /> <br>
                    <f:errors path="productName" cssClass="txt_error" />
                </td>
            </tr>
            <tr>
                <th>Description</th>
                <td>
                    <f:input path="productDescription" /> <br>
                    <f:errors path="productDescription" cssClass="txt_error" />
                </td>
            </tr>
            <tr>
                <th>Price</th>
                <td>
                    <f:input path="price" /> <br>
                    <f:errors path="price" cssClass="txt_error" />
                </td>
            </tr>
            <tr>
                <th>Created</th>
                <td>
                    <f:input path="created" type="date" /> <br>
                    <f:errors path="created" cssClass="txt_error" />
                </td>
            </tr>
            <tr>
                <th>Image</th>
                <td>
                    <f:input path="image" type="file" /> <br>
                    <f:errors path="image" cssClass="txt_error" />
                </td>
            </tr>
            <tr>
                <th></th>
                <td><button>Save</button></td>
            </tr>
        </table>
    </f:form>
</body>
</html>

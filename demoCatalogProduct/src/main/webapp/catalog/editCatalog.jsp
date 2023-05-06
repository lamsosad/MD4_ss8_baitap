<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 05/05/2023
  Time: 3:48 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Catalog</title>
</head>
<body style="text-align: center">
<h1>Edit Catalog</h1>
<form action="CatalogServlet?action=update" method="post">
    <b>ID: </b>
    <input type="text" name="id" value="${catalog.getId()}" readonly><br><br>
    <b>NAME: </b>
    <input type="text" name="name" value="${catalog.getName()}"><br><br>
    <button type="submit" style="background-color: orange">EDIT</button>
</form>
</body>
</html>

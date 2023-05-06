<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 05/05/2023
  Time: 1:38 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body style="text-align: center">
<h1>Create Catalog</h1>
<form action="CatalogServlet?action=create" method="post">
    <b>Name</b>
    <input type="text" name="name">
    <button type="submit" style="background-color: green">ADD</button>
</form>
</body>
</html>

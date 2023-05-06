<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 05/05/2023
  Time: 9:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body style="text-align: center">
<h1>Create Product</h1>
<form action="ProductServlet?action=create" method="post">
    <b>Name</b>
    <input type="text" name="name"><br><br>
    <b>Price</b>
    <input type="number" name="price"><br><br>
    <b>Quantity</b>
    <input type="number" name="quantity"><br><br>
    <b>ID Catalog</b>
    <select name="catalog">
        <c:forEach items="${list}" var="cata">
            <option value="${cata.getName()}">${cata.getName()}</option>
        </c:forEach>
    </select>
    <button type="submit" style="background-color: green">ADD</button>
</form>
</body>
</html>

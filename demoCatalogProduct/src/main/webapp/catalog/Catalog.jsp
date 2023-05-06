<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 05/05/2023
  Time: 11:18 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Catalog</title>
</head>

<body style="text-align: center">
<h1>Catalog</h1>
<a href="CatalogServlet?action=create"><button style="background-color: green">Create Catalog</button></a>
<br>
<br>
<div style="display: flex;justify-content: center">
    <table style="border: 2px solid black">
        <tr style="border: 2px solid black">
            <th style="border: 2px solid black">ID</th>
            <th style="border: 2px solid black">NAME</th>
            <th colspan="2" style="border: 2px solid black">ACTION</th>
        </tr>
        <c:forEach items="${list}" var="cata">
            <tr style="border: 2px solid black">
                <td style="border: 2px solid black">${cata.getId()}</td>
                <td style="border: 2px solid black">${cata.getName()}</td>
                <td>
                    <a href="CatalogServlet?action=edit&id=${cata.getId()}&name=${cata.getName()}"><button style="border: 2px solid black;background-color: orange">Edit</button></a>
                </td>
                <td>
                    <a href="CatalogServlet?action=delete&id=${cata.getId()}"><button  style="border: 2px solid black;background-color: red">Delete</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 05/05/2023
  Time: 11:41 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body style="text-align: center">
<h1>Product</h1>
<a href="ProductServlet?action=create"><button style="background-color: green">Create Product</button></a>
<br>
<br>
<br>
<div style="display: flex;justify-content: center">
    <table style="border: 2px solid black;text-align: center">
        <tr style="border: 2px solid black">
            <th style="border: 2px solid black">ID</th>
            <th style="border: 2px solid black">NAME</th>
            <th style="border: 2px solid black">PRICE</th>
            <th style="border: 2px solid black">QUANTITY</th>
            <th style="border: 2px solid black">CATALOG</th>
            <th colspan="2" style="border: 2px solid black">ACTION</th>
        </tr>
        <c:forEach items="${listPro}" var="pro">
            <tr style="border: 2px solid black">
                <td style="border: 2px solid black">${pro.getId()}</td>
                <td style="border: 2px solid black">${pro.getName()}</td>
                <td style="border: 2px solid black">${pro.getPrice()}$</td>
                <td style="border: 2px solid black">${pro.getQuantity()}</td>
                <td style="border: 2px solid black">${pro.getCatalog()}</td>
                <td>
                    <button style="border: 2px solid black;background-color: orange">Edit</button>
                </td>
                <td>
                    <button style="border: 2px solid black;background-color: red">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

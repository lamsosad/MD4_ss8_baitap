<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body style="text-align: center">
<h1><%= "Hello World!" %>
</h1>
<br/>
<div style="display: flex;justify-content: center">
<a href="CatalogServlet?action=show"><button style=" width: 200px;height: 70px;border-radius: 10px;background-color: aquamarine">Catalog</button></a> &nbsp; &nbsp; &nbsp; &nbsp;
<a href="ProductServlet?action=show"><button style=" width: 200px;height: 70px;border-radius: 10px;background-color: #b476ee">Product</button></a>
</div>
</body>
</html>
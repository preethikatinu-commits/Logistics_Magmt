
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products List</title>
</head>
<body>
<h2>All Products</h2>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th><th>Name</th><th>Category</th><th>Price</th><th>Stock</th><th>Actions</th>
    </tr>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.category}</td>
            <td>${p.price}</td>
            <td>${p.stock}</td>
            <td>
                <a href="editProduct?id=${p.id}">Edit</a> |
                <a href="deleteProduct?id=${p.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<br/>
<a href="newProduct.jsp">Add New Product</a>
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
<h2>Edit Product</h2> 	  

<form action="updateProduct" method="post">
    <input type="hidden" name="id" value="${product.id}"/>

    Name: <input type="text" name="name" value="${product.name}"/><br/><br/>
    Category: <input type="text" name="category" value="${product.category}"/><br/><br/>
    Price: <input type="number" step="0.01" name="price" value="${product.price}"/><br/><br/>
    Stock: <input type="number" name="stock" value="${product.stock}"/><br/><br/>
    Customer ID: <input type="number" name="customerId" value="${product.customerId}"/><br/><br/>
    Vehicle ID: <input type="number" name="vehicleId" value="${product.vehicleId}"/><br/><br/>
    Weight: <input type="number" name="weight" value="${product.weight}"/><br/><br/>

    <input type="submit" value="Update"/>
</form>

<a href="listProducts">Back to list</a>
</body>
</html>
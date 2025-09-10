

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
<h2>Add New Product</h2>

<form action="createProduct" method="post">
    Name: <input type="text" name="name"/><br/><br/>
    Category: <input type="text" name="category"/><br/><br/>
    Price: <input type="number" step="0.01" name="price"/><br/><br/>
    Stock: <input type="number" name="stock"/><br/><br/>
    Customer ID: <input type="number" name="customerId"/><br/><br/>
    Vehicle ID: <input type="number" name="vehicleId"/><br/><br/>
    Weight: <input type="number" name="weight"/><br/><br/>
    
    <input type="submit" value="Save"/>
</form>

<a href="listProducts">Back to list</a>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Bills</title>
</head>
<body>
<h2>Bill Summary for ${summary.employeeName}</h2>

<p>Total Bills Today: ${summary.totalBillsToday}</p>
<p>Total Amount Today: ${summary.totalAmount}</p>

<a href="/web/employees">Back to Employee List</a>
</body>
</html>

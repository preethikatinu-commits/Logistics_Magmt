<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>
<h2>Employees List</h2>
<table border="1">
    <tr>
        <th>ID</th><th>Name</th><th>Role</th><th>Action</th>
    </tr>
    <c:forEach var="emp" items="${employees}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.role}</td>
            <td>
                <a href="/web/employees/${emp.id}/bills/today">View Bills Today</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

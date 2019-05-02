<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 02.05.2019
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update department page</title>
</head>
<body>
<h3>Updating department with id: ${department.id}</h3>
<form action="update-department-action" method="get">
    <table>
        <tr>
            <td>Department name</td>
            <td><input type="text" name="departmentName" value="${department.departmentName}"></td>
        </tr>
        <tr>
            <td>Comments</td>
            <td><input type="text" name="comments" value="${department.comments}"></td>
        </tr>
        <tr>
            <td>
                <button type="submit">Update</button>
                <input type="hidden" name="id" value="${department.id}">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 02.05.2019
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create employee page</title>
</head>
<body>
<form action="create-employee-action" method="post">
    <table>
        <tr>
            <td>First name</td>
            <td><input type="text" name="firstName"></td>
        </tr>
        <tr>
            <td>Last name</td>
            <td><input type="text" name="lastName"></td>
        </tr>
        <tr>
            <td>Patronymic</td>
            <td><input type="text" name="patronymic"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>Age</td>
            <td><input type="text" name="age"></td>
        </tr>
        <tr>
            <td>Phone number</td>
            <td><input type="text" name="phoneNumber"></td>
        </tr>
        <tr>
            <td>Employment date</td>
            <td><input type="date"  name="employmentDate"></td>
        </tr>
        <tr>
            <td>Department id</td>
            <td>
                <input disabled type="text" name="departmentId" value="${departmentId}">
            </td>
        </tr>
        <tr>
            <td>
                <%--<input type="submit" name="submit" value="Create">--%>
                <button type="submit">Create</button>
                <input type="hidden" value="${departmentId}" name="departmentId">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

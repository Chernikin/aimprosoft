<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 01.05.2019
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage employes page</title>
</head>
<body>
<h3>${successMessage}</h3>
<div>
    <table cellpadding="5" cellspacing="5" border="1">
        <tr>
            <td colspan="11" align="center"><b>All employees from department</b></td>
        </tr>
        <tr>
            <td colspan="11">
                <button><a href="create-employee-page"><b>Create Employee</b></a></button>
            </td>
        </tr>
        <tr>
            <td><b>Id</b></td>
            <td><b>First name</b></td>
            <td><b>Last name</b></td>
            <td><b>Patronymic</b></td>
            <td><b>Email</b></td>
            <td><b>Phone number</b></td>
            <td><b>Employment date</b></td>
            <td><b>Dismissal date</b></td>
            <td><b>Department</b></td>
            <td><b>Update</b></td>
            <td><b>Delete</b></td>
        </tr>
        <c:forEach items="${allEmployeesFromDepartment}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.patronymic}</td>
                <td>${employee.email}</td>
                <td>${employee.phoneNumber}</td>
                <td>${employee.employmentDate}</td>
                <td>${employee.dismissalDate}</td>
                <td>${department.id}</td>
                <td>
                    <form action="link-to-update-employee" method="post">
                        <button type="submit">update employee</button>
                        <input type="hidden" value="${employee.id}" name="id">
                    </form>
                </td>
                <td>
                    <form action="delete-employee" method="post">
                        <button type="submit">delete employee</button>
                        <input type="hidden" value="${employee.id}" name="id">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

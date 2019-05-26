<%--
  Created by IntelliJ IDEA.
  User: andrii.khodyka
  Date: 5/27/2019
  Time: 12:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage = "true" contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--https://www.journaldev.com/2049/jsp-exception-handling-jsp-error-page--%>

    <h3>Sorry, an error is happened!</h3>
    <div><%=exception.getMessage()%><div>
</body>
</html>

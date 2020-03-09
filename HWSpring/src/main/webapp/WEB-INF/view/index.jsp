<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
    <link href="<spring:url value="/static/css/style.css"/>" rel="stylesheet"/>
</head>
<body>
<h1>Home page</h1>

<br>
    <a href="<spring:url value="/students"/>">Students</a></br>
    <a href="<spring:url value="/groups"/>">Groups</a>
</p>
</body>
</html>

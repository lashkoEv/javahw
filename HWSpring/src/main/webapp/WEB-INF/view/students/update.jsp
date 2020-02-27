<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Student Info</title>
    <link href="<spring:url value="/static/css/style.css"/>" rel="stylesheet"/>
</head>
<body>
<h1>Student Info</h1>

<div>${error}</div>
<form method="post">
    <label>Id:
        <input type="text" name="id" id="id" placeholder="${student.id}" readonly/>
    </label><br/>
    <label>First Name:
        <input type="text" name="firstName" id="firstName" placeholder="${student.firstName}"/>
    </label><br/>
    <label>Last Name:
        <input type="text" name="lastName" id="lastName" placeholder="${student.lastName}"/>
    </label><br/>
    <label>Age:
        <input name="age" id="age" type="number" min="8" max="60" placeholder="${student.age}"/>
    </label><br/>
    <label>Group:
        <input type="text" name="group" id="group" placeholder="${student.group}"/>
    </label><br/>
    <button type="submit">Update</button>
</form>
<p>
    <a href="<c:url value="/students"/>">Go to students list</a>
</p>
</body>
</html>
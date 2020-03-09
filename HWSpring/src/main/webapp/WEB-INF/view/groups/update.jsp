<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new student</title>
    <link href="<c:url value="/static/css/style.css"/>" rel="stylesheet"/>
</head>
<body>
<h1>Update group</h1>
<form method="post">
    <label>New name:
    <input name="groupName" id="groupName"/>
    </label>
    <br/>
    <button type="submit">Update</button>
</form>
</body>
</html>
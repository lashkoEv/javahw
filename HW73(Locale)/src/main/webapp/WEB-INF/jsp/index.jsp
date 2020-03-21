<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Регистрация пользователя</title>
    <style>
        label {
            width: 200px;
        }

        input {
            width: 200px;
        }

        label, input {
            display: inline-block;
        }

        form > div {
            margin-top: 16px;
        }

        table {
            border-collapse: collapse;
            margin: 0 auto;
        }

        table, td, th {
            border: 1px solid black;
        }

        .error {
            outline-color: red;
        }

        .error-message {
            color: red;
        }
    </style>
</head>

<body>
    <spring:url value='/' var="url"/>
    <form:form method="post" modelAttribute="user" action="${url}">
        <div>
            <form:label path="login"><spring:message code="login"/>:</form:label>
            <form:input path="login" cssErrorClass="error"/>
            <form:errors path="login" cssClass="error-message"/>
        </div>
        <div>
            <form:label path="password"><spring:message code="password"/>:</form:label>
            <form:input type="password" path="password" cssErrorClass="error"/>
            <form:errors path="password" cssClass="error-message"/>
        </div>
        <div>
            <form:label path="replayPassword"><spring:message code="replayPassword"/>:</form:label>
            <form:input type="password" path="replayPassword" cssErrorClass="error"/>
            <form:errors path="replayPassword" cssClass="error-message"/>
        </div>
        <div>
            <form:label path="email"><spring:message code="email"/>:</form:label>
            <form:input path="email" cssErrorClass="error"/>
            <form:errors path="email" cssClass="error-message"/>
        </div>
        <div>
            <form:label path="phone"><spring:message code="phone"/>:</form:label>
            <form:input path="phone" placeholder="[+38] 0*********" cssErrorClass="error"/>
            <form:errors path="phone" cssClass="error-message"/>
        </div>
        <div>
            <form:label path="gender"><spring:message code="gender"/>:</form:label>
            <form:select path="gender" cssErrorClass="error">
                <form:option value="male"><spring:message code="male"/></form:option>
                <form:option value="female"><spring:message code="female"/></form:option>
            </form:select>
            <form:errors path="gender" cssClass="error-message"/>
        </div>
        <div>
            <input type="submit"/>
        </div>
    </form:form>

    <p>${message}</p>

</body>
</html>
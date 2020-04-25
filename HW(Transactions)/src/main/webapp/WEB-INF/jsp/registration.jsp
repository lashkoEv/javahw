<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <style>
        input {
            margin: 10px;
        }
    </style>
</head>
<body>

<form method="post" action="registration">
    <label>First name:
        <input type="text" name="firstName">
    </label><br/>
    <label>Last name:
        <input type="text" name="lastName">
    </label><br/>
    <label>Login:
        <input type="text" name="login">
    </label><br/>
    <label>Password:
        <input type="text" name="password">
    </label><br/>
    <button type="submit">Send</button>
</form>

</body>
</html>

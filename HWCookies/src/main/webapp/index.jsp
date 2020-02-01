<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cookies</title>
    <style>
        input{
            margin: 3px;
        }
    </style>
</head>
<body>
<h2>All cookies:</h2>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
            out.println("Name: " + cookies[i].getName());
            out.println(" Value: " + cookies[i].getValue());
            out.println("<br/>");
        }
    } else {
        out.println("No cookies");
    }
%>
<h2>Add cookie:</h2>
    <form method="post" action="add">
        <label>Key:
            <input name="key"/>
        </label><br/>
        <label>Value:
            <input name="value"/>
        </label><br/>
        <label>Time:
            <input name="time"/>
        </label><br/>
        <label>Domain:
            <input name="domain"/>
        </label><br/>
        <label>HTTP:
            <input type="radio" name="httpHttps" value="HTTP" checked/>
        </label>
        <label>HTTPS:
            <input type="radio" name="httpHttps" value="HTTPS"/>
        </label><br/>
        <button type="submit">Add</button>
    </form>

    <h2>Edit cookie</h2>
    <form method="post" action="edit">
        <label>Key:
            <input name="key"/>
        </label><br/>

        <label>Value:
            <input name="value"/>
        </label><br/>

        <label>Time:
            <input name="time"/>
        </label><br/>
        <label>Domain:
            <input name="domain"/>
        </label><br/>

        <label>HTTP:
            <input type="radio" name="httpHttps" value="HTTP" checked/>
        </label>
        <label>HTTPS:
            <input type="radio" name="httpHttps" value="HTTPS"/>
        </label><br/>
        <button type="submit">Edit</button>
    </form>

    <h2>Delete cookie</h2>
    <form method="post" action="delete">
        <label>Key:
            <input name="key"/>
        </label><br/>
        <button type="submit">Delete</button>
    </form>
</body>
</html>

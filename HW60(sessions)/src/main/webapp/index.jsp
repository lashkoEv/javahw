<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hw.CDDisk" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>CDDisk</title>
    <style>
        table {
            border-radius: 1px;
        }
    </style>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Type of content</th>
        <th>Cost</th>
    </tr>
    </thead>
    <tbody>
    <%
        if(session.getAttribute("disk")!= null) {
            List<CDDisk> disks = (List<CDDisk>)session.getAttribute("disk");
            for (CDDisk d: disks) {
                out.write("<tr>");
                out.write("<td>" + d.getName() + "</td>");
                out.write("<td>" + d.getTypeOfContent() + "</td>");
                out.write("<td>" + d.getCost() + "</td>");
                out.write("</tr>");
            }
        }
    %>
    </tbody>
</table>
<footer>
    <a href="<%=request.getContextPath()%>add.jsp">Add</a><br/>
    <a href="<%=request.getContextPath()%>delete.jsp">Delete</a><br/>
    <a href="<%=request.getContextPath()%>edit.jsp">Edit</a><br/>
</footer>
</body>
</html>

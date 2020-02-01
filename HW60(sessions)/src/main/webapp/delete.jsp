<%@ page import="hw.CDDisk" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<form method="post">
    <h1>Delete disk</h1>
    <label>NameDisk:
        <input name="name" required/>
    </label>
    <button type="submit">Delete</button>
</form>
<%
    if("POST".equals(request.getMethod())){
        List<CDDisk> disks = (List<CDDisk>)session.getAttribute("disk");
        for (CDDisk disk: disks) {
            if(request.getParameter("name").equals(disk.getName())) {
                disks.remove(disk);
                break;
            }
        }
    }
    if(session.isNew() || session.getAttribute("disk") == null) {
        session.setAttribute("disk", new ArrayList<CDDisk>());
    }
%>
<footer>
    <a href="<%=request.getContextPath()%>index.jsp">Back</a>
</footer>
</body>
</html>

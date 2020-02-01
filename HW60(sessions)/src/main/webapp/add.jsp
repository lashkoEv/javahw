<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="hw.CDDisk" %>
<html>
<head>
    <style>
        input{
            margin: 3px;
        }
    </style>
</head>
<body>
<form method="post">
    <h1>Add disk</h1>
    <label>
        Name: <input name="name" required/>
    </label><br/>
    <label>
        Type of content: <input name="type" required/>
    </label><br/>
    <label>
        Cost: <input name="cost" min="0" required/>
    </label><br/>
    <button type="submit">Add</button>
</form>
<%
    if(session.isNew() || session.getAttribute("disk") == null){
        session.setAttribute("disk",new ArrayList<CDDisk>());
    }
    if("POST".equals(request.getMethod())){
        List<CDDisk> disks = (List<CDDisk>) session.getAttribute("disk");
        CDDisk diskCd = new CDDisk(request.getParameter("name"),request.getParameter("type"),Double.parseDouble(request.getParameter("cost")));
        disks.add(diskCd);
    }
%>
<footer>
    <a href="<%=request.getContextPath()%>index.jsp">Back</a>
</footer>
</body>
</html>

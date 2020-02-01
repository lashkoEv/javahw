<%@ page import="hw.CDDisk" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        input {
            margin: 3px;
        }
    </style>
</head>
<body>
<form method="post">
    <h1>Edit disk</h1>
    <label>Name:
        <input name="name" required/>
    </label><br/>
    <label>Type of payment:
        <input name="type" required/>
    </label><br/>
    <label>Cost:
        <input name="cost" min="0" required/>
    </label><br/>
    <button type="submit">Edit</button>
</form>
<%
    if("POST".equals(request.getMethod())){
        List<CDDisk> disks = (List<CDDisk>) session.getAttribute("disk");
        for (CDDisk d: disks) {
            if(request.getParameter("name").equals(d.getName())){
                disks.remove(d);
                CDDisk diskCd = new CDDisk(d.getName(), request.getParameter("type"), Integer.parseInt(request.getParameter("cost")));
                disks.add(diskCd);
                break;
            }else{
            }
        }
    }

    if(session.isNew() || session.getAttribute("disk") == null){
        session.setAttribute("disk",new ArrayList<CDDisk>());
    }
%>
<footer>
    <a href="<%=request.getContextPath()%>index.jsp">Back</a>
</footer>
</body>
</html>

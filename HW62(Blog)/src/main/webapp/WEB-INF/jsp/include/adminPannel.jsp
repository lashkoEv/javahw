<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<div class="card my-4">
    <h5 class="card-header">Admin panel</h5>
    <div class="card-body">
        <div class="row">
            <div>
                <ul class="list-unstyled mb-0">
                    <li style="margin-left: 15px">
                        <%if(session.getAttribute("count") == null) {
                            out.println("You are not authorized!");
                        }else{
                            out.println("Authorized people: " + session.getAttribute("count"));
                        }%>

                    </li>
                    <li>
                        <a class="nav-link" href="<%=request.getContextPath()%>/add">Add</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%=request.getContextPath()%>/edit">Edit</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%=request.getContextPath()%>/delete">Delete</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%=request.getContextPath()%>/authorization">Authorization</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>


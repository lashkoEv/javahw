<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>

<%@include file="../include/header.jsp"%>

<div class="container">

    <h1>Groups</h1>

    <table class="highlight">
        <thead>
        <tr>
            <th>Id</th>
            <th>Title</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${groups}" var="g">
            <tr>
                <td>${g.id}</td>
                <td>${g.title}</td>
                <td>
                    <a href="<spring:url value="/groups/edit/${g.id}"/>">Update</a>
                    <a href="<spring:url value="/groups/delete/${g.id}"/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <jsp:include page="../include/scripts.jsp"/>

</div>

<%@include file="../include/footer.jsp"%>

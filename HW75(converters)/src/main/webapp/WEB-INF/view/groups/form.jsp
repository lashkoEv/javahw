<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%@include file="../include/header.jsp" %>

<div class="container">

    <h1>Enter group information</h1>

    <div class="row">
        <form:form modelAttribute="group" class="col s12" method="post">
            <form:hidden path="id"/>
            <div class="row">
                <div class="input-field col s6">
                    <form:input path="title" required="required" class="validate"/>
                    <form:label path="title">Title</form:label>
                    <form:errors path="title" class="helper-text" data-error="wrong" data-success="right"/>
                </div>
                <div class="input-field col s6">
                    <input type="submit" class="btn"/>
                </div>
            </div>
        </form:form>
    </div>

    <jsp:include page="../include/scripts.jsp"/>

</div>

<%@include file="../include/footer.jsp" %>


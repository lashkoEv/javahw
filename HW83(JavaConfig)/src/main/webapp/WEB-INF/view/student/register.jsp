<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<c:set var="title" value="Create Students"/>
<%@include file="../include/header.jsp" %>

<div class="container">

    <h1>${title}</h1>

    <div class="row">
        <form:form modelAttribute="studentDto" class="col s12" method="post">
            <form:hidden path="id"/>
            <div class="row">
                <div class="input-field col s6">
                    <form:input path="firstName" required="required" class="validate"/>
                    <form:label path="firstName">First Name</form:label>
                    <form:errors path="firstName" class="helper-text" data-error="wrong" data-success="right"/>
                </div>
                <div class="input-field col s6">
                    <form:input path="lastName" required="required" class="validate"/>
                    <form:label path="lastName">Last Name</form:label>
                    <form:errors path="lastName" class="helper-text" data-error="wrong" data-success="right"/>
                </div>
            </div>

            <div class="row">
                <div class="input-field col s6">
                    <form:select path="groupId" cssClass="validate">
                        <form:option value="" disabled="true" selected="true">Choose your option</form:option>
                        <form:options items="${groups}" itemLabel="name" itemValue="id"/>
                    </form:select>
                    <form:label path="groupId">Group</form:label>
                    <form:errors path="groupId" class="error-text helper-text" data-error="wrong" data-success="right"/>
                </div>
                <div class="input-field col s6">
                    <form:input path="birthDate" required="required" type="text" class="validate datepicker"/>
                    <form:label path="birthDate">Birth date</form:label>
                    <form:errors path="birthDate" class="error-text helper-text" data-error="wrong"
                                 data-success="right"/>
                </div>
            </div>
            <div class="row">
                <input type="hidden" name="role" value="ROLE_USER"/>
                <secure:csrfInput/>
                <div class="input-field col s6">
                    <form:input path="login" required="required" class="validate"/>
                    <form:label path="login">Login</form:label>
                    <form:errors path="login" class="helper-text" data-error="wrong" data-success="right"/>
                </div>
                <div class="input-field col s6">
                    <form:input path="password" required="required" class="validate"/>
                    <form:label path="password">Password</form:label>
                    <form:errors path="password" class="helper-text" data-error="wrong" data-success="right"/>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s6">
                    <label for="remember-me">Remember me</label>
                    <input type="checkbox" style="opacity: 2; pointer-events: auto" id="remember-me" name="remember-me">
                </div>
            </div>
            <div class="row">
                <div class="input-field col s6">
                    <button type="submit" class="btn">Registration<i class="material-icons right">send</i></button>
                </div>
            </div>
        </form:form>
    </div>

    <jsp:include page="../include/scripts.jsp"/>
</div>

<%@include file="../include/footer.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Al's
  Date: 28.02.2020
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" modelAttribute="user">

    <form:label path="login">Login</form:label>
    <form:input path="login"/>
    <form:errors path="login" /><br>

    <form:label path="password">Password</form:label>
    <form:password path="password"/>
    <form:errors path="password" /><br>

    <form:label path="passwordRepeat">Repeat password</form:label>
    <form:password path="passwordRepeat"/>
    <form:errors path="passwordRepeat" /><br>

    <form:label path="country">Country</form:label>
    <form:select path="country">
        <form:option value="Russia"/>
        <form:option value="USA"/>
        <form:option value="Germany"/>
        <form:option value="China"/>
    </form:select><br>
    <form:errors path="country"/>

    <form:label path="sex">Sex</form:label>
    <form:radiobutton path="sex" value="M"/>
    <form:radiobutton path="sex" value="F"/>
    <form:errors path="sex"/><br>


    <form:label path="birthday">Birthday</form:label>
    <form:input path="birthday"/>
    <form:errors path="birthday"/>

    <input type="submit" value="Ok">
</form:form>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Al's
  Date: 27.02.2020
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value="/" />">Homepage</a><br><br>
<c:if test="${not empty message}">
    <h1>${message}</h1>
</c:if>
<form:form method="POST" modelAttribute="calc">

<form:label path="operand">Первое число</form:label>
<form:input path="operand"/>
<form:errors path="operand" /><br>

    <form:label path="operator">Выберите знак</form:label>
    <form:select path="operator">
        <form:option value="minus"/>
        <form:option value="plus"/>
    </form:select><br>

<form:label path="operand2">Второе число</form:label>
<form:input path="operand2"/>
<form:errors path="operand2" /><br>

<input type="submit" value="Ok"/>

</form:form>

</body>
</html>

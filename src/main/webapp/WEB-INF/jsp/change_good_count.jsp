<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Отгрузка товара</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div>
    <form:form method="POST" >
        <h2>Отгрузка товара: <c:out value="${good.title}" /></h2>

        <div>
            <input name="count" type="text" placeholder="Штук отгрузить"/><br>
        </div>
        <button type="submit">Отгрузить</button>
    </form:form>
    <a href="/">Главная</a>
</div>
</body>
</html>
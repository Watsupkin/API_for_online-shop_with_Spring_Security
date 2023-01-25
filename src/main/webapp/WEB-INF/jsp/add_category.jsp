<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Создание категории</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div>
    <form:form method="POST" >
        <h2>Создание категории</h2>
        <div>
            <input name="catName" type="text" placeholder="Название категории"
                   autofocus="true"/><br>
        <button type="submit">Создать</button>
    </form:form>
    <a href="/">Главная</a>
</div>
</body>
</html>
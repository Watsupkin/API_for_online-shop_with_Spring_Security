<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Товары</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
<div>
    <h2>Товары категории</h2>
    <a href="/">Главная</a>
    <table>
        <thead>
        <th>ID товара</th>
        <th>Название</th>
        <th>Цена</th>
        <th>Количество на скаладе</th>
        <th>Категории товара</th>
        </thead>
        <c:forEach items="${goods}" var="good">
            <tr>
                <td>${good.id}</td>
                <td>${good.title}</td>
                <td>${good.price}</td>
                <td>${good.count}</td>
                <td>
                    <c:forEach items="${good.categories}" var="cat">${cat.name} </c:forEach>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
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
    <h2>Товары (только для залогинившихся пользователей)</h2>
    <a href="/">Главная</a>
    <sec:authorize access="hasRole('ADMIN')">
        <h4><a href="/add_good">Создать товар</a></h4>
        <h4><a href="/add_category">Создать категорию</a></h4>
    </sec:authorize>
    <table>
        <thead>
        <th>ID товара</th>
        <th>Название</th>
        <th>Цена</th>
        <th>Количество на скаладе</th>
        <th>Категории товара</th>
        <sec:authorize access="hasRole('ADMIN')">
            <th>Отгрузка</th>
            <th>Редактировать товар</th>
        </sec:authorize>
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

                <sec:authorize access="hasRole('ADMIN')">
                <td>
                    <h4><a href="/change_good_count/${good.id}">Отгрузить</a></h4>
                </td>
                <td>
                    <h4><a href="/change_good/${good.id}">Редактировать</a></h4>
                </td>
                </sec:authorize>

            </tr>
        </c:forEach>
    </table>
    <table>
        <thead>
        <th>Список доступных категорий</th>
        </thead>
        <tr>
            <td>
                <c:forEach items="${categories}" var="catt">
                    <a href="/by_cats/${catt.id}">${catt.name}</a>
                </c:forEach>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Создание товара</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div>
    <form:form method="POST" modelAttribute="goodForm">
        <h2>Создание товара</h2>
        <div>
            <input name="title" type="text" placeholder="Название"
                   autofocus="true"/><br>
            <input name="price" type="text" placeholder="Цена"/><br>
            <input name="count" type="text" placeholder="Штук на складе"/><br>
            <input name="catName" type="text" placeholder="Категории"/><br>
            <h5>Если добавляете несколько категорий, введите через запятую</h5>
        </div>
        <button type="submit">Создать</button>
    </form:form>
    <table>
        <thead>
            <th>Список доступных категорий</th>
        </thead>
        <tr>
            <td>
                <c:forEach items="${categories}" var="cat">
                    ${cat.name}
                </c:forEach>
            </td>
        </tr>
    </table>
    <a href="/">Главная</a>
</div>
</body>
</html>
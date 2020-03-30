<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пользователи</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Упраление пользователями</h1>
    <h2>
        <a href="/admin/add">Добавить пользователя</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/admin">Все пользователи</a>
    </h2>
</div>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Список пользователей</h2></caption>
        <tr>
            <th>Id</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Дата рождения</th>
            <th>Паспортные данные</th>
            <th>Роль</th>
            <th>Логин</th>
            <th>Опции</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.id}" /></td>
                <td><c:out value="${user.name}" /></td>
                <td><c:out value="${user.surname}" /></td>
                <td><c:out value="${user.dateOfBirth}" /></td>
                <td><c:out value="${user.passport}" /></td>
                <td><c:out value="${user.role}" /></td>
                <td><c:out value="${user.login}" /></td>
                <td>
                    <a href="/admin/edit?id=<c:out value='${user.id}' />">Редактировать</a>
                    <a href="/admin/delete?id=<c:out value='${user.id}'/>">Удалить</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User info</title>
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5">
        <caption>
            <h2>
                Информация о вас
            </h2>
        </caption>
        <tr>
            <th>Имя:</th>
            <td>
                <input type="text" name="name" size="45" value="<c:out value='${user.name}'/>" readonly/>
            </td>
        </tr>
        <tr>
            <th>Фамилия:</th>
            <td>
                <input type="text" name="surname" size="45" value="<c:out value='${user.surname}'/>" readonly/>
            </td>
        </tr>
        <tr>
            <th>Дата рождения:</th>
            <td>
                <input type="text" name="dateOfBirth" size="10" value="<c:out value='${user.dateOfBirth}'/>" readonly/>
            </td>
        </tr>
        <tr>
            <th>Паспортные данные:</th>
            <td>
                <input type="text" name="passport" size="15" value="<c:out value='${user.passport}'/>" readonly/>
            </td>
        </tr>
        <tr>
            <th>Роль:</th>
            <td>
                <input type="text" name="passport" size="15" value="<c:out value='${user.role}'/>" readonly/>
            </td>
        </tr>
        <tr>
            <th>Логин:</th>
            <td>
                <input type="text" name="passport" size="15" value="<c:out value='${user.login}'/>" readonly/>
            </td>
        </tr>
        <tr>
            <th>Пароль:</th>
            <td>
                <input type="password" name="passport" size="15" value="<c:out value='${user.password}'/>" readonly/>
            </td>
        </tr>
    </table>
</div>
</body>
</html>

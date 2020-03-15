<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пользователи</title>
    <meta charset="UTF-8">
</head>
<body>
<div style="text-align: center;">
    <h1>Упраление пользователями</h1>
    <h2>
        <a href="/add">Добавить пользователя</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">Все пользователи</a>
    </h2>
</div>
<div align="center">
    <form action="add" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Добавить пользователя
                </h2>
            </caption>

            <tr>
                <th>Имя:</th>
                <td>
                    <input type="text" name="name" size="45" value=""/>
                </td>
            </tr>
            <tr>
                <th>Фамилия:</th>
                <td>
                    <input type="text" name="surname" size="45" value=""/>
                </td>
            </tr>
            <tr>
                <th>Дата рождения:</th>
                <td>
                    <input type="text" name="dateOfBirth" size="10" value=""/>
                </td>
            </tr>
            <tr>
                <th>Паспортные данные:</th>
                <td>
                    <input type="text" name="passport" size="15" value=""/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Сохранить"/>
                </td>
            </tr>

        </table>
    </form>
</div>
</body>
</html>

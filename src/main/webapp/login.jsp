<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div align="center">
    <form action="/login" method="post">
        <table border="1" cellpadding="5">
            <tr>
                <th>Логин:</th>
                <td>
                    <input type="text" name="login" size="45" value=""/>
                </td>
            </tr>
            <tr>
                <th>Пароль:</th>
                <td>
                    <input type="text" name="password" size="45" value=""/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Войти"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

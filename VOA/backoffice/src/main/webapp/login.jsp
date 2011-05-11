<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Вход в систему</title>
</head>

<%
    if (request.getParameter("login_error") != null) {
%>
<font color="red"><b>Введены неверные пользовательские данные!</b></font>
<%
    }
%>
<style type="text/css">
    #wrapper, #container {
        height: 130px;
        width: 300px;
    }

    #wrapper {
        bottom: 50%;
        right: 50%;
        position: absolute;
    }

    #container {
        left: 50%;
        position: absolute;
        top: 50%;
    }

</style>

<body>
<div id="wrapper">
    <div id="container">
        <form action="j_spring_security_check" method="post">
            <table border="0">
                <tr>
                    <td>
                        <table style='background-color: #dfe8f6; border: 1px solid #99BBE8'>
                            <tr>
                                <td></td>
                            </tr>

                            <tr>
                                <td></td>
                            </tr>

                            <tr>
                                <td>Имя пользователя:</td>
                                <td></td>
                                <td><input type="text" size="25" name="j_username"
                                           value="admin">
                            </tr>
                            <tr>
                                <td></td>
                            </tr>
                            <tr>
                                <td>Пароль:</td>
                                <td></td>
                                <td><input type="password" size="25" name="j_password"
                                           value="adminpassword"></td>
                            </tr>
                            <tr>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td>
                                    <button type="submit" name="login" value="Login" style='float:right; width:100px'>
                                        Войти
                                    </button>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>

        </form>
    </div>
</div>
</body>
</html>
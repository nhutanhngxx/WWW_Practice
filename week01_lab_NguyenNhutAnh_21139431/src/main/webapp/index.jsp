<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Đăng nhập</title>
        <link rel="stylesheet" href="./index.css">
    </head>
    <body>
        <form action="controller" method="post">
            <h1>ĐĂNG NHẬP</h1>
            <p>Tên đăng nhập:</p>
            <input type="text" placeholder="Ten dang nhap..." name="account_id" required>
            <p>Mật khẩu: </p>
            <input type="password" placeholder="Mat khau..." name="password" required>
            <button type="submit" value="login" name="action" class="button-login">ĐĂNG NHẬP</button>
        </form>
    </body>
</html>
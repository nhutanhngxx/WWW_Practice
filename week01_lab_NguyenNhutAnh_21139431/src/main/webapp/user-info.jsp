<%@ page import="vn.edu.iuh.fit.week01_lab_nguyennhutanh_21139431.models.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Info</title>
    <link rel="stylesheet" href="./user-info.css">
</head>
<body>
<form action="controller" method="post">
    <h1>USER DASHBOARD</h1>
    <%
        Account ac = (Account) session.getAttribute("user");
        if (ac != null) {
    %>
    <p class="mess-hello">Xin chào, <b><%= ac.getFullName() %></b> !</p>
    <%
        }
    %>
    <h2>Thông tin người dùng</h2>
    <table>
        <thead>
        <tr>
            <th>Account ID</th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <%= ac.getAccountId() %>
            </td>
            <td>
                <%= ac.getFullName() %>
            </td>
            <td>
                <%= ac.getPhone() %>
            </td>
            <td>
                <%= ac.getEmail() %>
            </td>
            <td>
                <%= ac.getStatus() == 1 ? "Active" : ac.getStatus() == 0 ? "Deactive" : "Xóa" %>
            </td>
        </tr>
        </tbody>
    </table>
</form>
<form action="controller" method="post">
    <div class="buttons-group">
        <button type="submit" value="logout-user" name="action" class="logout-user">Đăng xuất</button>
        <div class="group-inline">
            <button type="submit" name="action" value="add-user">Thêm tài khoản</button>
            <button type="submit" name="action" value="edit-user">Cập nhật tài khoản</button>
            <button type="submit" name="action" value="delete-user">Xóa tài khoản</button>
        </div>
    </div>
</form>
</body>
</html>

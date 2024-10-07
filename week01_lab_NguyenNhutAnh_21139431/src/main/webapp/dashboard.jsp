<%@ page import="vn.edu.iuh.fit.week01_lab_nguyennhutanh_21139431.models.Account" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="./dashboard.css">
</head>
<body>
<form action="controller" method="post">
    <h1>ADMIN DASHBOARD</h1>
    <%
        Account ac = (Account) session.getAttribute("account");
        if (ac != null) {
    %>
    <p class="mess-hello">Xin chào, <b><%= ac.getFullName() %></b> !</p>
    <%
        }
    %>
    <h2>Danh sách tài khoản</h2>
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
        <%
            List<Account> list = (List<Account>) request.getAttribute("listAccounts");
            for (Account account : list) {

        %>
        <tr>
            <td>
                <%= account.getAccountId() %>
            </td>
            <td>
                <%= account.getFullName() %>
            </td>
            <td>
                <%= account.getPhone() %>
            </td>
            <td>
                <%= account.getEmail() %>
            </td>
            <td>
                <%= account.getStatus() == 1 ? "Active" : account.getStatus() == 0 ? "Deactive" : "Xóa" %>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</form>
<form action="controller" method="post">
    <div class="buttons-group">
        <button type="submit" value="logout" name="action" class="logout">Đăng xuất</button>
        <div class="group-inline">
            <button type="submit" name="action" value="add">Thêm tài khoản</button>
            <button type="submit" name="action" value="edit">Cập nhật tài khoản</button>
            <button type="submit" name="action" value="delete">Xóa tài khoản</button>
        </div>
    </div>
</form>
</body>
</html>

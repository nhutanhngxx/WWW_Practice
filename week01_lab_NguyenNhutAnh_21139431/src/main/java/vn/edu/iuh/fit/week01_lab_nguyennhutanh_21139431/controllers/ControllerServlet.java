package vn.edu.iuh.fit.week01_lab_nguyennhutanh_21139431.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.week01_lab_nguyennhutanh_21139431.models.Account;
import vn.edu.iuh.fit.week01_lab_nguyennhutanh_21139431.services.AccountDAO;
import vn.edu.iuh.fit.week01_lab_nguyennhutanh_21139431.services.GrantAccessDAO;

import javax.annotation.processing.Messager;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controller", value = "/controller")
public class ControllerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private AccountDAO accountDAO;

    @Override
    public void init() throws ServletException {
        accountDAO = new AccountDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("Action = " + action);

        if (action == null || action.isEmpty()) {
            response.sendRedirect("index.jsp");
            return;
        }

        switch (action) {
            case "login":
                // Lấy dữ liệu từ form
                String account_id = request.getParameter("account_id");
                String password = request.getParameter("password");

                // Tạo session
                HttpSession session = request.getSession();

                // Lưu dữ liệu vào session
                session.setAttribute("account_id", account_id);
                session.setAttribute("password", password);

                // Kiểm tra đăng nhập
                GrantAccessDAO grantAccessDAO = new GrantAccessDAO();
                String role_id = grantAccessDAO.isAdmin(account_id);

                if (role_id != null) {
                    if (role_id.equals("admin")) {
                        AccountDAO accountDAO = new AccountDAO();
                        accountDAO.login(account_id, password);
                        Account result = accountDAO.login(account_id, password);
                        if (result != null) {
                            List<Account> accounts = accountDAO.getAllAccount();
                            session.setAttribute("account", result);
                            request.setAttribute("listAccounts", accounts);
                            RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
                            dispatcher.forward(request, response);
                        }
                    } else {
                        AccountDAO accountDAO = new AccountDAO();
                        accountDAO.login(account_id, password);
                        Account result = accountDAO.login(account_id, password);
                        if (result != null) {
                            session.setAttribute("user", result);
                            RequestDispatcher dispatcher = request.getRequestDispatcher("user-info.jsp");
                            dispatcher.forward(request, response);
                        }
                    }
                } else {
                    response.sendRedirect("index.jsp");
                }
                break;
            case "logout":
                response.sendRedirect("index.jsp");
                break;
            case "logout-user":
                response.sendRedirect("index.jsp");
                break;
        }
    }
}
package vn.edu.iuh.fit.week01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week01.beans.LoginBeans;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);

        String us = req.getParameter("us");
        String pw = req.getParameter("pw");
        LoginBeans loginBeans = new LoginBeans();

        PrintWriter printWriter = resp.getWriter();

        Boolean result = loginBeans.login(us, pw);

        if (result) {
            printWriter.println("Wellcome " + us + "!!");
        } else {
            printWriter.println("Error!!");
        }

    }
}

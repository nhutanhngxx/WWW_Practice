package vn.edu.iuh.fit.session01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "mult", value = "/mult")
public class MulTableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        for (int i = 2; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                out.println(+ i + " * " + j + "=" + (i * j) +"<br/>");
            }
            out.println("<hr/>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<html><h1>POST</h1></html>");
    }
}

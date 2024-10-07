package vn.edu.iuh.fit.session02.svlCtx;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SecondServlet", value = "/second")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<h1>Second: " + req.getAttribute("tel") + "</h1>");

        out.println("<h1>" + getServletContext().getAttribute("add") + "</h1>");
    }
}

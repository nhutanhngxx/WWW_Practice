package vn.edu.iuh.fit.session01;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ty", value = "/teo")
public class MyGenericServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        ServletConfig cfg = getServletConfig();
        String n = cfg.getInitParameter("name");

        PrintWriter out = servletResponse.getWriter();
        out.println("<html>Hell " + n + "</html>");
    }
}

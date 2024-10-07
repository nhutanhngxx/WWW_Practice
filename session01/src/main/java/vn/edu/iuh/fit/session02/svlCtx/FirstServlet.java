package vn.edu.iuh.fit.session02.svlCtx;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServlet",
        value = "/first",
        initParams = {
                @WebInitParam(name = "x", value = "Nguyen Van Teo", description = "This is name of the first person")
        }
)
public class FirstServlet extends HttpServlet {
    private ServletConfig cfg;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
       this.cfg = config;
       getServletContext().setAttribute("add", "12 Nguyen Van Bao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = cfg.getInitParameter("x");
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + name + "</h1>");
        out.println("<h1>" + getServletContext().getAttribute("add") + "</h1>");
        req.setAttribute("tel","0912345678");
        out.println("<h1>" + req.getAttribute("tel") + "</h1>");

        String html ="<a href = \"second\">Forward to Second Servlet</a>";
        req.getRequestDispatcher("second").forward(req, resp);
        out.println(html);
    }
}

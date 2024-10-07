package vn.edu.iuh.fit.model.view;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ACER on 9/7/2024.
 */

@WebServlet(name = "AddView", value = "/add")
public class AddView extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Result</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>RESULT</h1>");
        Object result = request.getAttribute("result");
        if (result != null) {
            out.println("<p> This result of " + request.getAttribute("a")
                    + " + " + request.getAttribute("b") + " = "
                    + result + "</p>");
        } else {
            out.println("<p>No result available. Please make sure you have provided valid input.</p>");
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ACER on 9/3/2024.
 */

@WebServlet(name = "register", value = "get")
public class RegistrationForm extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String facebook = request.getParameter("facebook");
        String shortbio = request.getParameter("shortbio");
        String html = "<br>" + "<html>"
                + "<head>" + "<title>Result Page</title>"
                + "</head>" + "<body>"
                + "First Name: "+ name +"<br>"
                + "Email: "+ email +"<br> Facebook URL: "+ facebook +"<br>"
                + "Short Bio: "+ shortbio +"<br>"
                + "</body>" + "</html>";
        out.println(html);
    }
}

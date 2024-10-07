package vn.edu.iuh.fit.model.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.model.model.Calculator;

import java.io.IOException;

@WebServlet(name = "controller", value = "/controller")
public class Controller extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        Calculator calculator = new Calculator();

        if (action.equalsIgnoreCase("add")) {

            int a = Integer.parseInt(request.getParameter("a"));
            int b = Integer.parseInt(request.getParameter("b"));

            int result = calculator.add(a, b);
            request.setAttribute("result", result);
            request.setAttribute("a", a);
            request.setAttribute("b", b);
            request.getRequestDispatcher("/add").forward(request, response);
        } else {
            response.getWriter().println("Action is missing or invalid!");
        }
    }
}

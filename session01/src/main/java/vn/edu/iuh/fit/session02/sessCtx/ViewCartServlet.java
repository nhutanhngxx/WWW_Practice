package vn.edu.iuh.fit.session02.sessCtx;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.session02.sessCtx.objs.Cart;
import vn.edu.iuh.fit.session02.sessCtx.objs.CartItem;
import vn.edu.iuh.fit.session02.sessCtx.objs.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "ViewCartServlet", value = "/view_cart")
public class ViewCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);//khong co session thi tao moi 1 cai
        ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("products");

        Object cart_obj = session.getAttribute("cart");
        Cart cart = null;
        PrintWriter out = resp.getWriter();

        if (cart_obj == null) {
            out.println("<h1>Empty Shopping Cart</h1>");
        } else {
            String html = "<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"90%\">";
            html += "<tr><td>ID</td> <td>Name</td> <td>Quanlity</td> <td>Price</td> <td>amount</td></tr>";

            double sum = 0d;

            cart = (Cart) cart_obj;
            for (CartItem item : cart.getCart()) {
                long id = item.getPid();
                Product p = new Product();
                p.setProductId(id);
                Product selP = products.get(products.indexOf(p));
                double amount = selP.getPrice() * item.getQuantity();
                sum += amount;

                html += "<tr>";
                html += "<td>" + selP.getProductId() + "</td>";
                html += "<td>" + selP.getProductName() + "</td>";
                html += "<td>" + item.getQuantity() + "</td>";
                html += "<td>" + selP.getPrice() + "</td>";
                html += "<td>" + amount + "</td>";
                html += "</tr>";
            }
            out.println(html);
            out.println("<h2>Total amount: " + sum + "</h2>");
        }


    }
}

package vn.edu.iuh.fit.session02.sessCtx;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.datafaker.Faker;
import net.datafaker.providers.food.Beer;
import vn.edu.iuh.fit.session02.sessCtx.objs.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(name = "ProductListing", value = "/product_list")
public class ProductListing extends HttpServlet {
    private List<Product> products = new ArrayList<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        Faker faker = new Faker();
        Beer beer = faker.beer();
        Random rnd = new Random();
        for (int i = 0; i < 20; i++) {
            products.add(new Product(i, beer.name(), beer.brand(), rnd.nextDouble() * 10000));
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);//khong co session thi tao moi 1 cai
        session.setAttribute("products", products);

        String html = "<body>";
        html += "<h1>Product Listing</h1>";

        html+="<a href=\"view_cart\">View Cart</a>";

        html += "<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"90%\">";
        html += "<tr><td>ID</td> <td>Name</td> <td>Des</td> <td>Price</td> </tr>";
        for (Product p : products) {
            html += "<tr>";
            html += "<td>" + p.getProductId() + "</td>";
            html += "<td>" + p.getProductName() + "</td>";
            html += "<td>" + p.getDescription() + "</td>";
            html += "<td>" + p.getPrice() + "</td>";
            html += "<td> <a href=\"add2card?id=" + p.getProductId() + "\">Add</a> </td>";
            html += "</tr>";
        }
        html += "</table>";
        resp.getWriter().println(html);
    }
}

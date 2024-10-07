package vn.edu.iuh.fit.session02.sessCtx;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.session02.sessCtx.objs.Cart;
import vn.edu.iuh.fit.session02.sessCtx.objs.CartItem;

import java.io.IOException;

@WebServlet(name = "Add2CartServlet", value = "/add2card")
public class Add2CartServlet extends HttpServlet {
    private Cart cart;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);//khong co session thi tao moi 1 cai
//        ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("products");*/
        Object obj = session.getAttribute("cart");
        if(obj==null){
            cart = new Cart();
        }else{
            cart = (Cart) obj;
        }

        long id = Long.parseLong(req.getParameter("id"));
        CartItem item = new CartItem(id, 1);
        cart.addProduct(item);

        session.setAttribute("cart",cart);

//        PrintWriter out = resp.getWriter();
//        out.println(products.get(Integer.parseInt(id)).toString());

        //add xong, quay lai trang product list
        resp.sendRedirect("product_list");
    }
}

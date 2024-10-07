package vn.edu.iuh.fit.session02.asyncSvl;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.AsyncListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "HeavyProcessingServlet", value = "/heavy", asyncSupported = true)
public class HeavyProcessingServlet extends HttpServlet {
    private HeavyTask task;

    @Override
    public void init() throws ServletException {
        task = new HeavyTask();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String p1= req.getParameter("p1");
        String p2= req.getParameter("p2");
        AsyncContext ctx = req.startAsync();
        ctx.addListener(new TeoAsycListener());
        ctx.start(
                new Runnable() {
                    @Override
                    public void run() {
                        String st = task.xuly(p1, p2);//take a long time
                        try {
                            resp.getWriter().println(st);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
        resp.getWriter().println("finished");
    }
}

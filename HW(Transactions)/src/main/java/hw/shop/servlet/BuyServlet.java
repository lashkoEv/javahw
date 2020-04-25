package hw.shop.servlet;

import db.Shop;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/buy", name = "buy")
public class BuyServlet extends HttpServlet {
    Shop shop;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        shop = new Shop();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        shop.buyAll();
        req.getRequestDispatcher("/WEB-INF/jsp/buy.jsp").forward(req, resp);
    }
}

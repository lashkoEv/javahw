package hw.shop.servlet;


import db.Shop;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "shop", urlPatterns = "/shop")
public class ShopServlet extends HttpServlet {
    Shop shop;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        shop = new Shop();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        if (null == req.getParameter("quantity") && null == req.getParameter("product") && null == req.getParameter("cost")) {
            pw.append(shop.getOrder());
        } else {
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            int product = Integer.parseInt(req.getParameter("product"));
            double cost = Double.parseDouble(req.getParameter("cost"));
            pw.append(shop.addOrder(quantity, product, cost));
        }

    }
}

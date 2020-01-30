package hw.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!"".equals(req.getParameter("key"))) {
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals(req.getParameter("key"))) {
                        c.setMaxAge(0);
                        resp.addCookie(c);
                        break;
                    }
                }
            }
        }
        resp.sendRedirect(getServletContext().getContextPath() + "/");
    }
}

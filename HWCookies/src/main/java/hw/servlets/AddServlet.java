package hw.servlets;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie[] cookies = req.getCookies();
        boolean created = false;

        for (Cookie c : cookies) {
            if (c.getName().equals(req.getParameter("key"))) {
                created = true;
            }
        }
        String key = req.getParameter("key");
        String value = req.getParameter("value");
        String domain = req.getParameter("domain");
        String time = req.getParameter("time");
        String http = req.getParameter("httpHttps");

        if (!"".equals(key) && !"".equals(value) && !created) {
            Cookie c = new Cookie(key, value);

            if (!"".equals(domain)) {
                c.setDomain(domain);
            }
            if (!"".equals(time)) {
                c.setMaxAge(Integer.parseInt(time));
            }
            if ("HTTPS".equals(http)) {
                c.setSecure(true);
            } else {
                c.setSecure(false);
            }

            resp.addCookie(c);
        }

        resp.sendRedirect(getServletContext().getContextPath() + "/");
    }
}

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
        System.out.println(key);
        System.out.println(value);
        System.out.println(domain);
        System.out.println(Integer.parseInt(time));
        System.out.println(http);

        if (!"".equals(key) && !"".equals(value) && !created) {
            Cookie cookie = new Cookie(key, value);

            if (!"".equals(domain)) {
                cookie.setDomain(domain);
            }
            if (!"".equals(time)) {
                cookie.setMaxAge(Integer.parseInt(time));
            }
            if ("HTTPS".equals(http)) {
                cookie.setSecure(true);
            } else {
                cookie.setSecure(false);
            }
            System.out.println(cookie.getValue());
            System.out.println(cookie.getName());
            System.out.println(cookie.getSecure());
            System.out.println(cookie.getMaxAge());

            resp.addCookie(cookie);

            cookies = req.getCookies();
            for (Cookie c : cookies) {
                System.out.println(c.getName());
            }
        }

        resp.sendRedirect(getServletContext().getContextPath() + "/");
    }
}

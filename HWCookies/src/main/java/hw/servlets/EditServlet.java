package hw.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        String key = req.getParameter("key");
        String value = req.getParameter("value");
        String domain = req.getParameter("domain");
        String time = req.getParameter("time");
        String http = req.getParameter("httpHttps");
      /*  System.out.println(key);
        System.out.println(value);
        System.out.println(domain);
        System.out.println(Integer.parseInt(time));
        System.out.println(http);

       */

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(key)) {
                    if (!"".equals(value)) {
                        c.setValue(value);
                    } else {
                        c.setValue(c.getValue());
                    }
                    if (!"".equals(time)) {
                        c.setMaxAge(Integer.parseInt(time));
                    } else {
                        c.setMaxAge(c.getMaxAge());
                    }
                    if (!"".equals(domain)) {
                        c.setDomain(domain);
                    }else {
                        c.setDomain(c.getDomain());
                    }
                    if ("HTTPS".equals(http)) {
                        c.setSecure(true);
                    } else {
                        c.setSecure(false);
                    }
                    resp.addCookie(c);
                }
            }
        }
        resp.sendRedirect(getServletContext().getContextPath() + "/");
    }
}

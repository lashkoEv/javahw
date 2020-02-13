package servlet;

import listener.UserListener;
import org.graalvm.compiler.hotspot.phases.LoadJavaMirrorWithKlassPhase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/authorization", name = "authorization")
public class AuthorizationServlet extends HttpServlet {
    final static String LOGIN = "admin";
    final static String PASSWORD = "admin";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/authorization.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login != null && password != null) {
            HttpSession session = req.getSession();
            Object admin = session.getAttribute("admin");
            if (admin != null) {
                session.removeAttribute("admin");
            }
            session.setAttribute("count", UserListener.getCount());
            if (login.equals(LOGIN) && password.equals(PASSWORD)) {
                session.setAttribute("admin", "admin");
            }
            resp.sendRedirect(req.getContextPath() + "/");
        }
    }
}

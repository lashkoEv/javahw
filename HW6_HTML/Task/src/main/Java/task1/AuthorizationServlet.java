package task1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthorizationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String LOGIN = "admin";
        final String PASSWORD = "123";
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        PrintWriter writer = resp.getWriter();
        if (login.equals(LOGIN) && password.equals(PASSWORD)) {
            writer.println("<table>" +
                    "<tr>" +
                    "<th>Id</th>" +
                    "<th>Login</th>" +
                    "<th>Password</th>" +
                    "<th>Gender</th>" +
                    "<th>Phone</th>" +
                    "<th>Email</th>" +
                    "<th>Subscribe</th>" +
                    "</tr>");
            writer.print(Users.stringBuilder);
        } else {
            writer.println("You must be an admin account to view table!");
        }
        writer.println("<p></p>");
        writer.println("<a href=\"index.html\">Back</a>");
    }
}
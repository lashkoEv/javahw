package task1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

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

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            String connString;
            connString = "jdbc:mysql://localhost/registration?serverTimezone=Europe/Kiev&characterEncoding=utf8";
            String user = "root";
            String DbPassword = "";
            try (Connection conn = DriverManager.getConnection(connString, user, DbPassword)) {

                Statement stmt = conn.createStatement();

                ResultSet resultSet = stmt.executeQuery("SELECT * from registration.users");
                while (resultSet.next()) {
                    writer.print("<tr>" +
                            "<td>" + resultSet.getInt(1) + "</td>" +
                            "<td>" + resultSet.getString(2) + "</td>" +
                            "<td>" + resultSet.getString(3) + "</td>" +
                            "<td>" + resultSet.getString(4) + "</td>" +
                            "<td>" + resultSet.getString(5) + "</td>" +
                            "<td>" + resultSet.getString(6) + "</td>" +
                            "<td>" + resultSet.getBoolean(7) + "</td>" +
                            "</tr>");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }else {
            writer.println("You must be an admin account to view table!");
        }

        writer.println("<p></p>");
        writer.println("<a href=\"index.html\">Back</a>");
    }
}
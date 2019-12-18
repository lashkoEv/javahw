package task1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

public class RegistrationServlet extends HttpServlet {

    public static final String INSERT = "INSERT INTO registration.users(login, password, gender, phone, email, subscribe) VALUES (?, ?, ?, ?, ?, ?)";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        if (gender == null) {
            gender = "male";
        } else {
            gender = "female";
        }
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String subscribe = req.getParameter("subscribe");
        boolean s;
        if (subscribe == null) {
            s = false;
        } else {
            s = true;
        }
        PrintWriter writer = resp.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String connString = "jdbc:mysql://localhost:3306/registration?serverTimezone=Europe/Kiev&characterEncoding=utf8";
        String user = "root";
        String DbPassword = "";
        try (Connection conn = DriverManager.getConnection(connString, user, DbPassword)) {
            PreparedStatement pstmt = conn.prepareStatement(INSERT);

            pstmt.setString(1, login);
            pstmt.setString(2, password);
            pstmt.setString(3, gender);
            pstmt.setString(4, phone);
            pstmt.setString(5, email);
            pstmt.setBoolean(6, s);
            pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        writer.println("<p>Add new user!" +
                "</p><p>Login: " + login +
                "</p><p>Password: " + password +
                "</p><p>Gender: " + gender +
                "</p><p>Phone: " + phone +
                "</p><p>Email: " + email +
                "</p><p>Subscribe: " + subscribe + "</p>");
        writer.println("<a href=\"index.html\">Back</a>");
    }
}
package org.itstep;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class SearchServlet extends HttpServlet {

    public static final String SELECT = "SELECT count(*) from people.person where first_name = ? AND last_name = ?";
    public static final String INDEX = "CREATE index if not exists person_first_name_idx on person(first_name)";

    String url;
    String user;
    String password;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        url = getServletContext().getInitParameter("db:url");
        user = getServletContext().getInitParameter("db:user");
        password = getServletContext().getInitParameter("db:pass");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        int count = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(url, user, password)) {

           // http://localhost:8080/search?first_name=Vasja&last_name=Smith for jetty

            long start = System.currentTimeMillis();
            Statement statement = connection.createStatement();
            boolean index = statement.execute(INDEX);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, last_name);
            ResultSet resultSet = preparedStatement.executeQuery();
            long time = System.currentTimeMillis() - start;
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            writer.println("Persons found: " + count);
            writer.println("Time: " + time + " milliseconds");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
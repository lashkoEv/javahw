package hw52;

import java.sql.*;

public class DBConnection {

    public String connect(String s){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String connString = "jdbc:mysql://localhost/movies?serverTimezone=Europe/Kiev&characterEncoding=utf8";
        String user = "root";
        String DbPassword = "";
        try (Connection conn = DriverManager.getConnection(connString, user, DbPassword)) {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(s);
            return printSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Нет подключения!";
    }

    private String printSet(ResultSet resultSet) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("<style>" +
                "table{border-collapse: collapse; margin: 10px;}" +
                "td, th {padding: 3px;border: 1px solid black;}" +
                "th {background: lightblue;}</style>" +
                "<table><tr>" +
                "<th>Код фильма</th>" +
                "<th>Код продюссера</th>" +
                "<th>Название</th>" +
                "<th>Год выпуска</th>" +
                "<th>Рейтинг</th>" +
                "<th>Сюжет</th>" +
                "<th>Длительность</th></tr>");
        while (resultSet.next()) {
            sb.append("<tr>" +
                    "<td>" + resultSet.getInt(1) + "</td>" +
                    "<td>" + resultSet.getInt(2) + "</td>" +
                    "<td>" + resultSet.getString(3) + "</td>" +
                    "<td>" + resultSet.getInt(4) + "</td>" +
                    "<td>" + resultSet.getInt(5) + "</td>" +
                    "<td>" + resultSet.getString(6) + "</td>" +
                    "<td>" + resultSet.getTime(7) + "</td>" +
                    "</tr>");
        }
        return sb.toString();
    }
}

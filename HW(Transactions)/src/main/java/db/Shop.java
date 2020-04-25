package db;

import lombok.NoArgsConstructor;

import java.sql.*;

@NoArgsConstructor
public class Shop {

    private int currentBuyer;

    public static final String URL = "jdbc:mysql://localhost/shop?serverTimezone=Europe/Kiev&characterEncoding=utf8";
    public static final String USER = "root";
    public static final String PASSWORD = "";

    public static final String INSERT_BUYER = "INSERT into buyers(first_name, last_name, login, password) VALUES (?,?,?,?)";
    public static final String BUY_ALL = "DELETE FROM orders WHERE 1=1";
    public static final String FIND_BUYER = "SELECT id, login, password from buyers where login like(?) and password like(?)";
    public static final String ADD_ORDER = "INSERT into orders(id_buyer, id_product, quantity) VALUES (?,?,?)";
    public static final String ADD_PRODUCT = "UPDATE stock SET amount = amount - 1 where product = ?";
    public static final String GET_PRODUCTS = "SELECT stock.id, products.name, sellers.id as seller, amount, cost FROM stock, sellers, products where product=products.id and seller=sellers.id";
    public static final String GET_PRODUCT = "SELECT orders.id, products.name, quantity, cost FROM orders, stock, products where products.id = id_product and products.id = stock.product";

    public String addBuyer(String firstName, String lastName, String login, String password) {
        if (!"".equals(firstName) && !"".equals(lastName) && !"".equals(login) && !"".equals(password)) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BUYER);
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, login);
                preparedStatement.setString(4, password);
                preparedStatement.execute();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("select @@IDENTITY");
                rs.next();
                currentBuyer = rs.getInt(1);
                return "";
            } catch (SQLException e) {
                System.out.println(e.getLocalizedMessage());
                return e.getLocalizedMessage();
            }
        } else {
            return "Null!";
        }
    }

    public String addOrder(int quantity, int product, double cost) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            double totalCost = 0;

            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement(ADD_ORDER);
            preparedStatement.setInt(1, currentBuyer);
            preparedStatement.setInt(2, product);
            preparedStatement.setFloat(3, quantity);
            preparedStatement.execute();
            PreparedStatement preparedStatement2 = connection.prepareStatement(ADD_PRODUCT);
            preparedStatement2.setInt(1, product);
            preparedStatement2.execute();

            connection.commit();

            StringBuilder sb = new StringBuilder();
            sb.append("<body><table><caption>In stock</caption><tr>")
                    .append("<th>Id</th>")
                    .append("<th>Name</th>")
                    .append("<th>Seller</th>")
                    .append("<th>Amount</th>")
                    .append("<th>Cost</th>")
                    .append("<th>Add</th>")
                    .append("</tr>");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_PRODUCTS);
            while (resultSet.next()) {
                if (resultSet.getInt("amount") > 1) {
                    sb.append("<tr>" + "<th>").append(resultSet.getInt("id")).append("</th>")
                            .append("<th>").append(resultSet.getString("name")).append("</th>")
                            .append("<th>").append(resultSet.getInt("seller")).append("</th>")
                            .append("<th>").append(resultSet.getInt("amount")).append("</th>")
                            .append("<th>").append(resultSet.getFloat("cost")).append("</th>")
                            .append("<th><a href=\"shop?product=").append(resultSet.getString("id"))
                            .append("&cost=").append(resultSet.getDouble("cost"))
                            .append("&quantity=").append(resultSet.getInt("amount"))
                            .append("\" ").append("/>Add</a></th>").append("</tr>");
                }
            }

            ResultSet resultSet2 = statement.executeQuery(GET_PRODUCT);
            sb.append("")
                    .append("<table><caption>Basket</caption>")
                    .append("<tr>")
                    .append("<th>Id</th>")
                    .append("<th>Product</th>")
                    .append("<th>Quantity</th>")
                    .append("<th>Cost</th>")
                    .append("</tr>");
            while (resultSet2.next()) {
                sb.append("<tr>" + "<th>").append(resultSet2.getInt("id")).append("</th>")
                        .append("<th>").append(resultSet2.getString("name")).append("</th>")
                        .append("<th>").append(1).append("</th>")
                        .append("<th>").append(resultSet2.getFloat("cost")).append("</th>")
                        .append("</tr>");
                totalCost += Double.parseDouble(String.valueOf(resultSet2.getDouble("cost")));
            }

            sb.append("<p>Total cost: ")
                    .append(totalCost)
                    .append("<p/><a href=\"buy\">Buy</a></p>");

            return sb.toString();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getOrder() {
        StringBuilder sb = new StringBuilder();
        sb.append("<body>");
        sb.append("<table><caption>In stock</caption><tr>")
                .append("<th>Id</th>")
                .append("<th>Name</th>")
                .append("<th>Seller</th>")
                .append("<th>Amount</th>")
                .append("<th>Cost</th>")
                .append("<th>Add</th>" )
                .append("</tr>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(GET_PRODUCTS);
            while (resultSet.next()) {
                if (resultSet.getInt("amount") > 1) {
                    sb.append("<tr>" + "<th>").append(resultSet.getInt("id")).append("</th>")
                            .append("<th>").append(resultSet.getString("name")).append("</th>")
                            .append("<th>").append(resultSet.getInt("seller")).append("</th>")
                            .append("<th>").append(resultSet.getInt("amount")).append("</th>")
                            .append("<th>").append(resultSet.getFloat("cost")).append("</th>")
                            .append("<th><a href=\"shop?product=").append(resultSet.getString("id"))
                            .append("&cost=").append(resultSet.getDouble("cost"))
                            .append("&quantity=").append(resultSet.getInt("amount"))
                            .append("\" ").append("/>Add</a></th>").append("</tr>");
                }
            }
            sb.append("</table>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public void buyAll() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(BUY_ALL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String findBuyer(String login, String password) {
        if (!"".equals(login) && !"".equals(password)) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                PreparedStatement preparedStatement = connection.prepareStatement(FIND_BUYER);
                preparedStatement.setString(1, login);
                preparedStatement.setString(2, password);
                ResultSet rs = preparedStatement.executeQuery();
                rs.next();
                if (!"".equals(rs.getString("login"))) {
                    currentBuyer = rs.getInt("id");
                    return "";
                }
            } catch (SQLException e) {
                System.out.println(e.getLocalizedMessage());
                return e.getLocalizedMessage();
            }
        }
        return "Null!";
    }
}

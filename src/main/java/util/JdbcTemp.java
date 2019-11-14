package util;


import model.Product;
import service.Order;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class JdbcTemp {

    private JdbcTemp() {
    }

    final static String url = "jdbc:sqlite:db.sqlite";

    public static int executeUpdate(String newName, int id) {

        String sql = "UPDATE products SET name = ? WHERE id = ? ;";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new SqlMappingExeption(e);
        }
    }

    public static List<Product> executeQuery(int minPrice, int maxPrice) {

        String sql = "SELECT id, name, category, quantity, isAvailable," +
                " price FROM products WHERE price BETWEEN ? AND ?;";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ) {
            preparedStatement.setInt(1, minPrice);
            preparedStatement.setInt(2, maxPrice);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Product> results = new LinkedList<>();
            while (resultSet.next()) {
                results.add(new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("category"),
                        resultSet.getInt("quantity"),
                        resultSet.getBoolean("isAvailable"),
                        resultSet.getInt("price")
                ));
            }
            return results;
        } catch (SQLException e) {
            throw new SqlMappingExeption(e);
        }
    }

    public static List<Product> selectAll() {

        String sql = "SELECT id, name, category, quantity, isAvailable," +
                " price FROM products;";
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);
        ) {
            List<Product> results = new LinkedList<>();
            while (resultSet.next()) {
                results.add(new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("category"),
                        resultSet.getInt("quantity"),
                        resultSet.getBoolean("isAvailable"),
                        resultSet.getInt("price")
                ));
            }
            return results;
        } catch (SQLException e) {
            throw new SqlMappingExeption(e);
        }
    }

    public static List<Order> getOrdersByDate() {

        String sql = "SELECT id, customer_id, order_price, status," +
                " date FROM orders ORDER BY date";

        try (
                Connection connection = DriverManager.getConnection(url);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            List<Order> orders = new LinkedList<>();
            while (resultSet.next()) {
                orders.add(new Order());
            }
            return orders;
        } catch (SQLException e) {
            throw new SqlMappingExeption(e);
        }

    }


}



// Update -> UPDATE, INSERT, DELETE

// Execute -> делай, что хочешь
//Statement statement = connection.createStatement();
//ResultSet resultSet = statement.executeQuery(value);